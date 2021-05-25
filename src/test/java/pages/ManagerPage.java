package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentBaseClass {

    @FindBy(className = "btn home")
    private WebElement homeButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='addCust()']")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='openAccount()']")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='showCust()']")
    private WebElement customersButton;

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    public WebElement clickHomeButton() {
        return homeButton;
    }

    public WebElement clickAddCustomerButton() {
        return addCustomerButton;
    }

    public WebElement clickOpenAccountButton() {
        return openAccountButton;
    }

    public WebElement clickCustomersButton() {
        return customersButton;
    }

}
