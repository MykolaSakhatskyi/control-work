package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class WithdrawalLessThanCustomerHasTest extends BaseTest {

    final String firstName = "Capitan";
    final String lastName = "America";
    final String postCode = "78h32h";
    final String currency = "Rupee";
    final String newCustomer = firstName + " " + lastName;
    final String deposit = "47";
    final String startingBalance = "0";
    final String withdraw = "46";
    final String successfulMassage = "Transaction successful";
    final String transactionType = "Debit";

    @Test
    public void withdrawalForAmountLessThanCustomerHas() {
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
        driver.navigate().refresh();
        accountPage.clickWithdrawTab();
        accountPage.sendAmountDepositAndWithdrawField().sendKeys(withdraw);
        accountPage.clickDepositAndWithdrawButton();
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),successfulMassage);
        driver.navigate().refresh();
        driver.navigate().refresh();
        accountPage.clickTransactionsTab();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        Assert.assertEquals(transactionsPage.getTransactionAmountDebit().getText(),withdraw);
        Assert.assertEquals(transactionsPage.getTransactionTypeDebit().getText(), transactionType);
    }

}
