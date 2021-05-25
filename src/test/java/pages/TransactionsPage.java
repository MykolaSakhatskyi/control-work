package pages;

import helpers.ParentBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransactionsPage extends ParentBaseClass {

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[2]")
    private WebElement transactionAmountCredit;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[1]/td[3]")
    private WebElement transactionTypeCredit;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[2]/td[2]")
    private WebElement transactionAmountDebit;

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']/tbody/tr[2]/td[3]")
    private WebElement transactionTypeDebit;

    public TransactionsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTransactionAmountCredit() {
        return transactionAmountCredit;
    }

    public WebElement getTransactionTypeCredit() {
        return transactionTypeCredit;
    }

    public WebElement getTransactionAmountDebit() {
        return transactionAmountDebit;
    }

    public WebElement getTransactionTypeDebit() {
        return transactionTypeDebit;
    }

}
