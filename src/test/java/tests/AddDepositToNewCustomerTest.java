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
        loginPage.clickBankManagerLoginButton().click();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton().click();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        addCustomerPage.clickAddCustomerButton().click();
        driver.switchTo().alert().accept();
        addCustomerPage.clickOpenAccountButton().click();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.clickCustomerNameDropdownList().click();
        openAccountPage.selectNewCustomerAndCurrency(openAccountPage.clickCustomerNameDropdownList(), newCustomer);
        openAccountPage.clickCustomerNameDropdownList().click();
        openAccountPage.clickCurrencyDropdownList().click();
        openAccountPage.selectNewCustomerAndCurrency(openAccountPage.clickCurrencyDropdownList(),currency);
        openAccountPage.clickCurrencyDropdownList().click();
        openAccountPage.clickProcessButton().click();
        driver.switchTo().alert().accept();
        openAccountPage.clickHomeButton().click();

        loginPage.clickCustomerLoginButton().click();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.clickDropdown().click();
        customerLoginPage.selectNewCustomer(newCustomer);
        customerLoginPage.clickDropdown().click();
        customerLoginPage.clickLoginButton().click();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.checkBalance().getText(), startingBalance);
        accountPage.clickDepositTab().click();
        accountPage.sendAmountDepositAndWithdrawField().sendKeys(deposit);
        accountPage.clickDepositAndWithdrawButton().click();
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),successfulMassage);
        Assert.assertEquals(accountPage.checkBalance().getText(),deposit);
        driver.navigate().refresh();
        accountPage.clickTransactionsTab().click();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        Assert.assertEquals(transactionsPage.getTransactionAmountCredit().getText(),deposit);
        Assert.assertEquals(transactionsPage.getTransactionTypeCredit().getText(), transactionType);
    }
}
