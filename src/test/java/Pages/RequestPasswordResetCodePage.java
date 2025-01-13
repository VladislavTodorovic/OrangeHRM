package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestPasswordResetCodePage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement textResetPasssword;

    public RequestPasswordResetCodePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTextResetPasssword() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-forgot-password-title"));
    }
}