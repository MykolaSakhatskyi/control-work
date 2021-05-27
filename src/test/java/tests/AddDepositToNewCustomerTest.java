package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddDepositToNewCustomerTest extends BaseTest {

    final String firstName = "Cat";
    final String lastName = "Leopold";
    final String postCode = "&?#%<>";
    final String currency = "Dollar";
    final String newCustomer = firstName + " " + lastName;
    final String deposit = "300";
    final String transactionType = "Credit";
    final String startingBalance = "0";
    final String successfulMassage = "Deposit Successful";

    @Test
    public void checkingAdditionDepositToNewCustomer() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLoginButton();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        alertAccept();
        addCustomerPage.clickOpenAccountButton();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectNewCustomer(newCustomer);
        openAccountPage.selectCurrency(currency);
        openAccountPage.clickProcessButton();
        alertAccept();
        openAccountPage.clickHomeButton();

        loginPage.clickCustomerLoginButton();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.selectNewCustomer(newCustomer);
        customerLoginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.checkBalance().getText(), startingBalance);
        accountPage.clickDepositTab();
        accountPage.sendAmountDepositAndWithdrawField().sendKeys(deposit);
        accountPage.clickDepositAndWithdrawButton();
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),successfulMassage);
        Assert.assertEquals(accountPage.checkBalance().getText(),deposit);
        driver.navigate().refresh();
        accountPage.clickTransactionsTab();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        Assert.assertEquals(transactionsPage.getTransactionAmountCredit().getText(),deposit);
        Assert.assertEquals(transactionsPage.getTransactionTypeCredit().getText(), transactionType);
    }
}
