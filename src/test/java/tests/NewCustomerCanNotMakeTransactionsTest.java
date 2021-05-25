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
        loginPage.clickBankManagerLoginButton().click();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton().click();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        addCustomerPage.clickAddCustomerButton().click();
        driver.switchTo().alert().accept();
        addCustomerPage.clickHomeButton().click();

        loginPage.clickCustomerLoginButton().click();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.clickDropdown().click();
        customerLoginPage.selectNewCustomer(newCustomer);
        customerLoginPage.clickDropdown().click();
        customerLoginPage.clickLoginButton().click();

        AccountPage accountPage = new AccountPage(driver);
        Assert.assertEquals(accountPage.getWelcomeText().getText(),"Please open an account with us.");
        Assert.assertTrue(accountPage.clickTransactionsTab().isEnabled(),"Transactions button is present on account page");
    }
}
