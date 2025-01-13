
package Base;
import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.RequestPasswordResetCodePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public RequestPasswordResetCodePage requestPasswordResetCodePage;
    public AdminPage adminPage;


    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wdwait);
        requestPasswordResetCodePage = new RequestPasswordResetCodePage(driver, wdwait);
        dashboardPage = new DashboardPage(driver, wdwait);
        adminPage = new AdminPage(driver, wdwait);

    }

    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
}
