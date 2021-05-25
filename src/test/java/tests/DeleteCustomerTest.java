package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.CustomersListPage;
import pages.LoginPage;
import pages.ManagerPage;

public class DeleteCustomerTest extends BaseTest {

    final String firstName = "Vaselisa";
    final String lastName = "Prekrasnaya";
    final String postCode = "EE1234";

    @Test
    public void addCustomerAndCheckThatCustomerWasAdded () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLoginButton().click();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton().click();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        addCustomerPage.clickAddCustomerButton().click();
        driver.switchTo().alert().accept();
        addCustomerPage.clickCustomersButton().click();

        CustomersListPage customersListPage = new CustomersListPage(driver);
        customersListPage.enterSearchField(firstName);
        customersListPage.clickDeleteButton().click();
        Assert.assertNull(customersListPage.deletedCustomer(),"Customer is not deleted");
    }

}
