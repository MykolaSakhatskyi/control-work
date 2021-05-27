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
        Assert.assertNotNull(accountPage.checkAccountNumber(),"Customer doesn't have account");
        Assert.assertEquals(accountPage.checkBalance().getText(), startingBalance);
    }
}
