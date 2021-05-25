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
        driver.navigate().refresh();
        accountPage.clickWithdrawTab().click();
        accountPage.sendAmountDepositAndWithdrawField().sendKeys(withdraw);
        accountPage.clickDepositAndWithdrawButton().click();
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),successfulMassage);
        driver.navigate().refresh();
        driver.navigate().refresh();
        accountPage.clickTransactionsTab().click();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        Assert.assertEquals(transactionsPage.getTransactionAmountDebit().getText(),withdraw);
        Assert.assertEquals(transactionsPage.getTransactionTypeDebit().getText(), transactionType);
    }

}
