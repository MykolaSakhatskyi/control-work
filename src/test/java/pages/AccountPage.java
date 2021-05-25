package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountPage extends ParentBaseClass {

    @FindBy(xpath = "//strong[@class='ng-binding'][1]")
    private WebElement accountNumber;

    @FindBy(xpath = "//strong[@class='ng-binding'][2]")
    private WebElement balance;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='transactions()']")
    private WebElement transactionsTab;

    @FindBy(xpath = "//span[@ng-show='noAccount']")
    private WebElement welcomeText;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='deposit()']")
    private WebElement depositTab;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement depositAndWithdrawButton;

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required']")
    private WebElement amountDepositAndWithdrawField;

    @FindBy(xpath = "//span[@class='error ng-binding']")
    private WebElement successfulOrErrorMassage;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='withdrawl()']")
    private WebElement withdrawTab;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement clickTransactionsTab() {
        return transactionsTab;
    }

    public WebElement getWelcomeText () {
        return welcomeText;
    }

    public WebElement checkAccountNumber() {
        return accountNumber;
    }

    public WebElement checkBalance() {
        return balance;
    }

    public WebElement clickDepositTab() {
        return depositTab;
    }

    public WebElement clickDepositAndWithdrawButton() {
        return depositAndWithdrawButton;
    }

    public WebElement sendAmountDepositAndWithdrawField() {
        return amountDepositAndWithdrawField;
    }

    public WebElement getSuccessfulOrErrorMassage() {
        return successfulOrErrorMassage;
    }

    public WebElement clickWithdrawTab() {
        return withdrawTab;
    }

}
