package Tests;
import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test (priority=10)
    public void userCanLogInWithValidUsernameAndValidPassord(){
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Dashboard");
    }

    @Test (priority=20)
    public void userCannotLogInWithValidUsernameAndInvalidPassword() {
        loginPage.login("Admin", "adin123");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test (priority=30)
    public void userCannotLogInWithInvalidUsernameAndValidPassword() {
        loginPage.login("lopta", "adin123");
        Assert.assertEquals(loginPage.getInvalidCredentials().getText(), "Invalid credentials");
    }

    @Test (priority=40)
    public void userCannotLogInWithValidUsernameAndEmptyPassword(){
        loginPage.login("Admin", "");
        Assert.assertEquals(loginPage.getPasswordRequired().getText(), "Required");
    }

    @Test (priority=50)
    public void userCannotLogInWithUsernameEmptyAndValidPassword(){
        loginPage.login("", "admin123");
        Assert.assertEquals(loginPage.getUsernameRequired().getText(), "Required");
    }

    @Test (priority=60)
    public void userCannotLogInWithUsernameLowercaseAndValidPassword(){
        loginPage.login("admin", "admin123");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test (priority=70)
    public void userCannotLogInWithUsernameUppercaseAndValidPassword(){
        loginPage.login("ADMIN", "admin123");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

    @Test (priority=80)
    public void forgotYourPassword(){
        loginPage.getForgottenPasswordLink().click();
        Assert.assertEquals(requestPasswordResetCodePage.getTextResetPasssword().getText(), "Reset Password");
    }

    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
    }
}