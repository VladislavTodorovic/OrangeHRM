package Base;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseOtherTest {
    public WebDriver driver;
    public WebDriverWait wdwait;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public RequestPasswordResetCodePage requestPasswordResetCodePage;
    public AdminPage adminPage;
    public MaintenancePage maintenancePage;
    public MyInfoPage myInfoPage;




    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
        loginPage = new LoginPage(driver, wdwait);
        requestPasswordResetCodePage = new RequestPasswordResetCodePage(driver, wdwait);
        dashboardPage = new DashboardPage(driver, wdwait);
        adminPage = new AdminPage(driver, wdwait);
        maintenancePage = new MaintenancePage(driver, wdwait);
        myInfoPage = new MyInfoPage(driver, wdwait);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage.validLogin();
    }

    @AfterClass
    public void tearDown(){
        // driver.manage().deleteAllCookies();
        // driver.quit();
    }
}