package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class WithdrawalMoreThanCustomerHasTest extends BaseTest {

    final String firstName = "Tanos";
    final String lastName = "Razrushitel";
    final String postCode = "yyy";
    final String currency = "Rupee";
    final String newCustomer = firstName + " " + lastName;
    final String deposit = "100";
    final String startingBalance = "0";
    final String withdraw = "101";
    final String errorMassage = "Transaction Failed. You can not withdraw amount more than the balance.";

    @Test
    public void withdrawalForAmountMoreThanCustomerHas() {
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
        Assert.assertEquals(accountPage.checkBalance().getText(),deposit);
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),errorMassage);
    }

}
