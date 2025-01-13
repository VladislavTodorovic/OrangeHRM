package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MaintenancePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement textAdministratorAccess;
    WebElement cancelButton;

    public MaintenancePage( WebDriver driver,WebDriverWait wdwait) {
        this.wdwait = wdwait;
        this.driver = driver;
    }

    public WebElement getTextAdministratorAccess() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-admin-access-title"));
    }

    public WebElement getCancelButton() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--large.oxd-button--ghost.orangehrm-admin-access-button"));
    }

}