package Tests;
import Base.BaseOtherTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Admin\n" +
                "User Management");
    }

    @Test (priority=20)
    public void redirectionToPIMPage(){
        dashboardPage.redirectionToPage("PIM");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "PIM");
    }

    @Test (priority=30)
    public void redirectionToLeavePage(){
        dashboardPage.redirectionToPage("Leave");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Leave");
    }

    @Test (priority=40)
    public void redirectionToTimePage(){
        dashboardPage.redirectionToPage("Time");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Time\n" +
                "Timesheets");
    }

    @Test (priority=50)
    public void redirectionRecruitmentPage(){
        dashboardPage.redirectionToPage("Recruitment");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Recruitment");
    }

    @Test (priority=60)
    public void redirectionToMyInfoPage(){
        dashboardPage.redirectionToPage("My Info");
        Assert.assertTrue(myInfoPage.getEmployeeNavigation().getText().contains("Personal Details"));
    }

    @Test (priority=70)
    public void redirectionToPerformancePage(){
        dashboardPage.redirectionToPage("Performance");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Performance\n" +
                "Manage Reviews");
    }

    @Test (priority=80)
    public void redirectionToDashboardPage(){
        dashboardPage.redirectionToPage("Dashboard");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Dashboard");
    }

    @Test (priority=90)
    public void redirectionToDirectoryPage(){
        dashboardPage.redirectionToPage("Directory");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Directory");
    }

    @Test (priority=100)
    public void redirectionToMaintenancePage(){
        dashboardPage.redirectionToPage("Maintenance");
        Assert.assertEquals(maintenancePage.getTextAdministratorAccess().getText(), "Administrator Access");
        maintenancePage.getCancelButton().click();

    }

    @Test (priority=110)
    public void redirectionToClaimPage(){
        dashboardPage.redirectionToPage("Claim");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Claim");
    }

    @Test (priority=120)
    public void redirectionToBuzzPage(){
        dashboardPage.redirectionToPage("Buzz");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Buzz");
    }

    @Test (priority=130)
    public void redirectionFromToRecruitmentPageToDashboardPage(){
        dashboardPage.redirectionToPage("Recruitment");
        dashboardPage.redirectionToPage("Dashboard");
        Assert.assertEquals(dashboardPage.getDashboardHeader().getText(), "Dashboard");
    }

    @Test(priority = 210)
    public void upgradeTheApplication() {
        dashboardPage.getUpgradeButton().click();
        ArrayList<String> listofTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listofTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://orangehrm.com/open-source/upgrade-to-advanced");


    }

    @Test(priority = 220)
    public void aboutTheApplication() {
        dashboardPage.redirectionToItemOfDDL("About");
        Assert.assertTrue(dashboardPage.getPopupCloseButton().isDisplayed());
        dashboardPage.getPopupCloseButton().click();
    }

    @Test(priority = 230)
    public void customerSupport() {
        dashboardPage.redirectionToItemOfDDL("Support");
        Assert.assertEquals(dashboardPage.getTextGettingStartedWithOrangeHRM().getText(), "Getting Started with OrangeHRM");

    }

    @Test(priority = 250)
    public void helpButton(){
    dashboardPage.getHelpButton().click();
        ArrayList<String> listofTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listofTabs.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://starterhelp.orangehrm.com/hc/en-us");

    }

    @Test(priority = 260)
    public void shrinkAndExpandSidebar() {
        dashboardPage.getShrinkArrow().click();
        Assert.assertTrue(dashboardPage.getExpandArrow().isDisplayed());
        dashboardPage.getExpandArrow().click();
        Assert.assertTrue(dashboardPage.getShrinkArrow().isDisplayed());
    }

    @Test(priority = 270)
    public void searchField(){
        dashboardPage.getSearchButton().sendKeys("Vacancies");
        Assert.assertTrue(dashboardPage.getLayoutSpace().getText().contains("Vacancies"));
    }

    @Test(priority = 280)
    public void updatePassword()  {
        dashboardPage.redirectionToItemOfDDL("Change Password");
        dashboardPage.getCurrentPasswordField().sendKeys("admin123");
        dashboardPage.getPasswordField().sendKeys("Asdf1234");
        dashboardPage.getConfirmPasswordField().sendKeys("Asdf1234");
        dashboardPage.getPasswordChangeSaveButton().click();
        // OVDE FALI ASERTACIJA!!!! Popup message traje samo dve sekunde!!



    }


    @Test(priority = 290)
    public void updatePasswordWithWrongCurrentPassword(){
        dashboardPage.redirectionToItemOfDDL("Change Password");
        dashboardPage.getCurrentPasswordField().sendKeys("admin");
        dashboardPage.getPasswordField().sendKeys("Asdf1234");
        dashboardPage.getConfirmPasswordField().sendKeys("Asdf1235");
        dashboardPage.getPasswordChangeSaveButton().click();
        Assert.assertEquals(dashboardPage.getPasswordsDoNotMatch().getText(), "Passwords do not match");
    }

    @Test(priority = 300)
    public void passwordAndConfirmPasswordNotIdentical(){
        dashboardPage.redirectionToItemOfDDL("Change Password");
        dashboardPage.getCurrentPasswordField().sendKeys("admin123");
        dashboardPage.getPasswordField().sendKeys("Asdf1234");
        dashboardPage.getConfirmPasswordField().sendKeys("Asdf1235");
        dashboardPage.getPasswordChangeSaveButton().click();
        Assert.assertEquals(dashboardPage.getPasswordsDoNotMatch().getText(), "Passwords do not match");
    }


    @Test(priority = 400)
    public void logout(){
        dashboardPage.redirectionToItemOfDDL("Logout");
        Assert.assertTrue(loginPage.getLoginButton().isDisplayed());
    }

/*
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
*/

}