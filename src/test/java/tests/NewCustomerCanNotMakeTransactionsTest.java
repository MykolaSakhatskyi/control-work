package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class NewCustomerCanNotMakeTransactionsTest extends BaseTest {

    final String firstName = "Vasia";
    final String lastName = "Petrov";
    final String postCode = "1sd3Rt4";
    final String newCustomer = firstName + " " + lastName;

    @Test
    public void checkThatNewCustomerCanNotMakeTransactions () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLoginButton();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        alertAccept();
        addCustomerPage.clickHomeButton();

        loginPage.clickCustomerLoginButton();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.selectNewCustomer(newCustomer);
        customerLoginPage.clickLoginButton();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText().getText(),"Please open an account with us.");
    }
}
