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

    public WebElement clickCustomerNameDropdownList() {
        return customerNameDropdownList;
    }

    public WebElement clickCurrencyDropdownList() {
        return currencyDropdownList;
    }

    public WebElement clickProcessButton() {
        return processButton;
    }

    public void selectNewCustomerAndCurrency(WebElement dropdownList, String newCustomerOrCurrency) {
        Select selectNewCustomerOrCurrency = new Select(dropdownList);
        selectNewCustomerOrCurrency.selectByVisibleText(newCustomerOrCurrency);
    }

    public WebElement clickHomeButton() {
        return homeButton;
    }

}
