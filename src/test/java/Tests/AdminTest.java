package Tests;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test
    public void addNewSystemUser(){
        loginPage.validLogin();
        //dashboardPage.redirectionAdminPage();
        dashboardPage.redirectionToPage("Admin");




    }


    @AfterMethod
    public void deleteCookies() {
        //driver.manage().deleteAllCookies();
    }


}