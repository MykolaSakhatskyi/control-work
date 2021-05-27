package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerPage extends ParentBaseClass {

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='addCust()']")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='openAccount()']")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab'][@ng-click='showCust()']")
    private WebElement customersButton;

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddCustomerButton() {
        addCustomerButton.click();
    }

}
