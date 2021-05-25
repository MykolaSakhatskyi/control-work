package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentBaseClass {

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][@ng-click='customer()']")
    private WebElement customerLoginButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][@ng-click='manager()']")
    private WebElement bankManagerLoginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement clickCustomerLoginButton() {
        return customerLoginButton;
    }

    public WebElement clickBankManagerLoginButton() {
        return bankManagerLoginButton;
    }

}
