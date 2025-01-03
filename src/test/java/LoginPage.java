import com.google.common.base.VerifyException;
import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void seUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }


    @Test(priority = 10)
    public void UserCanLogInWithValidCredentials() {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement menuItemDashboard = driver.findElement(By.cssSelector(".oxd-main-menu-item.active"));
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertTrue(menuItemDashboard.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @Test(priority=20)
    public void UserCannotLogInWithInvalidPassword(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("amin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement invalidCredentialsNotification = driver.findElement(By.cssSelector(".oxd-alert.oxd-alert--error"));
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
        Assert.assertTrue(invalidCredentialsNotification.isDisplayed());
    }

    @Test(priority=30)
    public void UserCannotLogInWithInvalidUsername(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("lopta");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement invalidCredentialsNotification = driver.findElement(By.cssSelector(".oxd-alert.oxd-alert--error"));
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
        Assert.assertTrue(invalidCredentialsNotification.isDisplayed());
    }

    @Test(priority=40)
    public void UserCannotLogInWithPasswordFieldEmpty(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("Admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement requiredNotification = driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
        Assert.assertEquals(requiredNotification.getText(), "Required");
    }

    @Test(priority=50)
    public void UserCannotLogInWithusernameFieldEmpty(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        WebElement requiredNotification = driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
        Assert.assertEquals(requiredNotification.getText(), "Required");
    }

    @Test(priority=60)
    public void UserCannotLogInWithUsernameWrittenInLowercase(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
    }

    @Test(priority=70)
    public void UserCannotLogInWithUsernameWrittenInUppercase(){
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("ADMIN");
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();
        passwordField.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
    }

    @Test(priority=80)
    public void UserCanResetPassword (){
        WebElement forgottenPasswordLink = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header"));
        forgottenPasswordLink.click();
        WebElement usernameForgottenPasswordField = driver.findElement(By.cssSelector(".oxd-input.oxd-input--active"));
        usernameForgottenPasswordField.clear();
        usernameForgottenPasswordField.sendKeys("Admin");
        WebElement resetPasswordButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--large.oxd-button--secondary.orangehrm-forgot-password-button.orangehrm-forgot-password-button--reset"));
        resetPasswordButton.click();
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";
        WebElement resetPasswordNotification = driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-forgot-password-title"));
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
        Assert.assertTrue(resetPasswordNotification.isDisplayed());
    }

    @Test(priority=90)
    public void UserCanCancelResettingPassword(){
        WebElement forgottenPasswordLink = driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.orangehrm-login-forgot-header"));
        forgottenPasswordLink.click();
        WebElement cancelButton = driver.findElement(By.cssSelector(".oxd-button.oxd-button--large.oxd-button--ghost.orangehrm-forgot-password-button.orangehrm-forgot-password-button--cancel"));
        cancelButton.click();
        String expectedURl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
    }

    @Test(priority=100)
    public void UserCanGoToOrangeHRMWebsite() {
        WebElement linkToOrangeHRM = driver.findElement(By.linkText("OrangeHRM, Inc"));
        linkToOrangeHRM.click();
        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));
        String expectedURl = "https://www.orangehrm.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURl);
    }

    @AfterMethod
    public void removeCookies() {
       driver.manage().deleteAllCookies();
       driver.close();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}





