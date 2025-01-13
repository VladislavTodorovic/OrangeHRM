package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wdwait;

    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    WebElement forgottenPasswordLink;
    WebElement invalidCredentials;
    WebElement passwordRequired;
    WebElement usernameRequired;

    public LoginPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.name("username"));
    }
    public WebElement getPasswordField() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"));
    }

    public WebElement getForgottenPasswordLink() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header"));

    }

    public WebElement getInvalidCredentials() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text"));
    }

    public WebElement getPasswordRequired() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
    }

    public WebElement getUsernameRequired() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
    }

    //----------
    public void login(String username,String password){
        getUsernameField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getLoginButton().click();
    }
    public void validLogin(){
        getUsernameField().sendKeys("Admin");
        getPasswordField().sendKeys("admin123");
        getLoginButton().click();
    }
}