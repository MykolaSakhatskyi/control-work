package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomersListPage extends ParentBaseClass {

    @FindBy(xpath = "//input[@class='form-control ng-pristine ng-untouched ng-valid']")
    private WebElement searchField;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]")
    private WebElement cellPostCode;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[1]")
    private WebElement cellFirstName;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
    private WebElement cellLastName;

    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    private WebElement deleteButton;

    public CustomersListPage(WebDriver driver) {
        super(driver);
    }

    public void enterSearchField(String firstname) {
        searchField.sendKeys(firstname);
    }

    public WebElement getCellFirstName() {
        return cellFirstName;
    }

    public WebElement getCellPostCode() {
        return cellPostCode;
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public WebElement getCellLastName() {
        return cellLastName;
    }

    public boolean deletedCustomer() {
        try {
            cellFirstName.isDisplayed();
            return false;
            }
        catch (NoSuchElementException e){
            return true;}
    }

}
