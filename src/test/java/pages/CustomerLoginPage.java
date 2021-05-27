package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage extends ParentBaseClass {

    @FindBy(id = "userSelect")
    private WebElement dropdownList;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    private WebElement loginButton;


    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton () {
        loginButton.click();
    }

    public void selectNewCustomer(String newCustomer) {
        Select selectNewCustomer = new Select(dropdownList);
        selectNewCustomer.selectByVisibleText(newCustomer);
    }

}
