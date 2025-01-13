package Tests;
import Base.BaseOtherTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class DashboardTest extends BaseOtherTest {


    private String originalTab;

    @BeforeMethod
    public void pageSetUp() {
        originalTab = driver.getWindowHandle();
    }

    @Test (priority=10)
    public void redirectionToAdminPage(){
        dashboardPage.redirectionToPage("Admin");
    }

    @Test (priority=20)
    public void redirectionToPIMPage(){
        dashboardPage.redirectionToPage("PIM");
    }

    @Test (priority=30)
    public void redirectionToLeavePage(){
        dashboardPage.redirectionToPage("Leave");
    }

    @Test (priority=40)
    public void redirectionToTimePage(){
        dashboardPage.redirectionToPage("Time");
    }

    @Test (priority=50)
    public void redirectionRecruitmentPage(){
        dashboardPage.redirectionToPage("Recruitment");
    }

    @Test (priority=60)
    public void redirectionToMyInfoPage(){
        dashboardPage.redirectionToPage("My Info");
    }

    @Test (priority=70)
    public void redirectionToPerformancePage(){
        dashboardPage.redirectionToPage("Performance");
    }

    @Test (priority=80)
    public void redirectionToDashboardPage(){
        dashboardPage.redirectionToPage("Dashboard");
    }

    @Test (priority=90)
    public void redirectionToDirectoryPage(){
        dashboardPage.redirectionToPage("Directory");
    }

    @Test (priority=100)
    public void redirectionToMaintenancePage(){
        dashboardPage.redirectionToPage("Maintenance");
        maintenancePage.getCancelButton().click();
    }

    @Test (priority=110)
    public void redirectionToClaimPage(){
        dashboardPage.redirectionToPage("Claim");
    }

    @Test (priority=120)
    public void redirectionToBuzzPage(){
        dashboardPage.redirectionToPage("Buzz");
    }

    @Test (priority=130)
    public void redirectionFromToRecruitmentPageToDashboardPage(){
        dashboardPage.redirectionToPage("Recruitment");
        dashboardPage.redirectionToPage("Dashboard");
    }

    @Test(priority = 210)
    public void upgradeTheApplication() {
        dashboardPage.getUpgradeButton().click();

    }

    @Test(priority = 220)
    public void aboutTheApplication() {
        dashboardPage.redirectionToItemOfDDL("About");
        dashboardPage.getPopupCloseButton().click();
    }

    @Test(priority = 230)
    public void customerSupport() {
        //dashboardPage.redirectionToPage("Dashboard");
        dashboardPage.redirectionToItemOfDDL("Support");

    }

    @AfterMethod
    public void afterMethod() {
        Set<String> handles = driver.getWindowHandles();
        if (handles.size() > 1) {
            wdwait.until(driver -> driver.getWindowHandles().size() > 1);
            for (String handle : handles) {
                if (!handle.equals(originalTab)) {
                    driver.switchTo().window(handle).close();
                }
            }
        }
        driver.switchTo().window(originalTab);
    }
}