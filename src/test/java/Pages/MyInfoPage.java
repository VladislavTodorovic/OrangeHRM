package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyInfoPage {

    WebDriver driver;
    WebDriverWait wdwait;

    WebElement employeeNavigation;

    public MyInfoPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEmployeeNavigation() {
        return driver.findElement(By.className("orangehrm-edit-employee-navigation"));
    }
}
