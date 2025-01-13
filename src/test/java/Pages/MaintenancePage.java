package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaintenancePage {
    WebDriver driver;
    WebDriverWait wdwait;


    WebElement cancelButton;

    public MaintenancePage( WebDriver driver,WebDriverWait wdwait) {
        this.wdwait = wdwait;
        this.driver = driver;
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--large.oxd-button--ghost.orangehrm-admin-access-button"));
    }

}