package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpenAccountPage extends ParentBaseClass {

    @FindBy(xpath = "//button[@class='btn home']")
    private WebElement homeButton;

    @FindBy(id = "userSelect")
    private WebElement customerNameDropdownList;

    @FindBy(id = "currency")
    private WebElement currencyDropdownList;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement processButton;

    public OpenAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickProcessButton() {
        processButton.click();
    }

    public void selectNewCustomerAndCurrency(WebElement dropdownList, String newCustomerOrCurrency) {
        Select selectNewCustomerOrCurrency = new Select(dropdownList);
        selectNewCustomerOrCurrency.selectByVisibleText(newCustomerOrCurrency);
    }

    public void selectNewCustomer(String newCustomer) {
        selectNewCustomerAndCurrency(customerNameDropdownList, newCustomer);
    }

    public void selectCurrency(String currency) {
        selectNewCustomerAndCurrency(currencyDropdownList, currency);
    }

    public void clickHomeButton() {
        homeButton.click();
    }

}
