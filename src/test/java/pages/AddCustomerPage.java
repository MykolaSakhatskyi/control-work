package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends ParentBaseClass {

    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='openAccount()']")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='showCust()']")
    private WebElement customersButton;

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required'][@ng-model='fName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required'][@ng-model='lName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required'][@ng-model='postCd']")
    private WebElement postCodeField;

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    public WebElement clickHomeButton() {
        return homeButton;
    }

    public WebElement clickAddCustomerButton() {
        return addCustomerButton;
    }

    public WebElement clickOpenAccountButton() {
        return openAccountButton;}

    public WebElement clickCustomersButton() {
        return customersButton;}

    public void enterNewUser(String firstName, String lastName, String postCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
    }

}
