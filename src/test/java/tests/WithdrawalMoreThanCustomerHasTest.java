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
        Assert.assertEquals(accountPage.checkBalance().getText(),deposit);
        Assert.assertEquals(accountPage.getSuccessfulOrErrorMassage().getText(),errorMassage);
    }

}
