package tests;

import helpers.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AddCustomerTest extends BaseTest {

    final String firstName = "Miha";
    final String lastName = "Korney";
    final String postCode = "EE1234";

    @Test
    public void addCustomerAndCheckThatCustomerWasAdded () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLoginButton();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.clickAddCustomerButton();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.enterNewUser(firstName, lastName, postCode);
        alertAccept();
        addCustomerPage.clickCustomersButton();

        CustomersListPage customersListPage = new CustomersListPage(driver);
        customersListPage.enterSearchField(firstName);
        Assert.assertEquals(customersListPage.getCellFirstName().getText(),firstName);
        Assert.assertEquals(customersListPage.getCellLastName().getText(),lastName);
        Assert.assertEquals(customersListPage.getCellPostCode().getText(),postCode);
    }

}
