package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentBaseClass {

    protected WebDriver driver;

    protected ParentBaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
