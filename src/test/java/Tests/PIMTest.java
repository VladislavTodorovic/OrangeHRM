package Tests;

import Base.BaseOtherTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class PIMTest extends BaseOtherTest {

    private String originalTab;


    @BeforeMethod
    public void pageSetUp() {
        originalTab = driver.getWindowHandle();
        dashboardPage.redirectionToPage("PIM");
    }

    @Test(priority = 10)
    public void redirectionToAddEmployee(){
        pimPage.redirectionToTopBarNav("Add Employee");
        Assert.assertEquals(pimPage.getTextEmployeeInformation().getText(), "Employee Information");

    }


    @Test(priority = 20)
    public void addNewEmployeeFirstTime() {
    pimPage.getAddButton().click();
    pimPage.getFieldFirstName().sendKeys("Jovan");
    for(int i=0; i<4; i++) {
        pimPage.getFieldEmployeeId().sendKeys(Keys.BACK_SPACE);
    }
    pimPage.getFieldEmployeeId().sendKeys(employeeIdByVlajke);
    pimPage.getFieldLastName().sendKeys("Jovic");
    pimPage.getSaveAddEmployeeGreenButton().click();
    wdwait.until(ExpectedConditions.visibilityOf(pimPage.getEmployeeNameAbovePicture()));
    String valueId = pimPage.getEmployeeIdInPeronalDetails().getAttribute("value");
    Assert.assertEquals(valueId, employeeIdByVlajke);
    }

    @Test(priority = 30)
    public void searchByEmloyeeName(){
        pimPage.searchFormularForEmployeeNameOrSupervisorName("Employee Name", "Jovan Jovic");
        pimPage.getSearchButtonBelowEmployeeInformationFields().click();

    }

    @Test(priority = 40)
    public void searchByEmployeeId (){
        pimPage.searchFormularForId("Employee Id", employeeIdByVlajke);
        pimPage.getSearchButtonBelowEmployeeInformationFields().click();
    }

    @Test(priority = 45)
    public void izaberiOpcijuUDroplisti() {


    }
    @Test(priority = 50)
    public void searchByEmploymentStatys(){
        pimPage.searchFormularForEmployeeNameSelectInField("Employment Status", "Freelance");
    }

    @Test(priority = 70)
    public void searchBySupervisorName(){
        pimPage.searchFormularForEmployeeNameOrSupervisorName("Supervisor Name", "Peter Mac Anderson");
        pimPage.getSearchButtonBelowEmployeeInformationFields().click();
    }


    @Test(priority = 140)
    public void deleteEmployee(){

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
