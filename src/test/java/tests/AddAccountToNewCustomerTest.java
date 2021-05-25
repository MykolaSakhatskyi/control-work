package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddAccountToNewCustomerTest extends BaseTest {

    final String firstName = "Genka";
    final String lastName = "Krokodilov";
    final String postCode = "lorVrach";
    final String currency = "Pound";
    final String newCustomer = firstName + " " + lastName;
    final String startingBalance = "0";

    @Test
    public void addAccountToNewCustomerAndCheckThatAccountWasAdded() {
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
        Assert.assertNotNull(accountPage.checkAccountNumber(),"Customer doesn't have account");
        Assert.assertEquals(accountPage.checkBalance().getText(), startingBalance);
    }
}
