package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PIMPage {

    WebDriver driver;
    WebDriverWait wdwait;
    List<WebElement> listTopBarNavs;
    WebElement textEmployeeInformation;
    WebElement addButton;
    WebElement textADDEmployee;
    WebElement fieldFirstName;
    WebElement fieldLastName;
    WebElement fieldEmployeeId;
    WebElement saveAddEmployeeGreenButton;
    WebElement employeeIdInPeronalDetails;
    WebElement employeeNameAbovePicture;
    List<WebElement> listOfParentElements;
    List<WebElement> listOfChildElements;
    List<WebElement> listOfGrandsonElements;

    public PIMPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTextEmployeeInformation() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--h5.oxd-table-filter-title"));
    }

    public WebElement getAddButton() {
        return driver.findElement(By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon"));
    }

    public WebElement getTextAddEmployee() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title"));
    }

    public WebElement getFieldFirstName() {
        return driver.findElement(By.cssSelector(".oxd-input.oxd-input--active.orangehrm-firstname"));
    }

    public WebElement getFieldLastName() {
        return driver.findElement(By.cssSelector(".oxd-input.oxd-input--active.orangehrm-lastname"));
    }

    public WebElement getFieldEmployeeId() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
    }

    public WebElement getSaveAddEmployeeGreenButton() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
    }

    public WebElement getEmployeeIdInPeronalDetails() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
    }

    public WebElement getEmployeeNameAbovePicture() {
        return driver.findElement(By.className("orangehrm-edit-employee-name"));
    }

    //--------
    public void redirectionToTopBarNav(String requestedNav) {
        listTopBarNavs = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name")));
        JavascriptExecutor js = (JavascriptExecutor)
                driver;
        for (int i = 0; i < listTopBarNavs.size(); i++) {
            WebElement redirection = listTopBarNavs.get(i);
            js.executeScript("arguments[0].scrollIntoView(true);", redirection);
            if (redirection.getText().equals(requestedNav)) {
                redirection.click();
                break;
            }
        }
    }

    public void searchFormular(String value) {
        listOfParentElements = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".oxd-input-group.oxd-input-field-bottom-space")));
        for (int i = 0; i < listOfParentElements.size(); i++) {
            WebElement parent = listOfParentElements.get(i);
            for (int j = 0; j < listOfChildElements.size(); j++) {
                WebElement child = parent.findElement(By.className("oxd-input-group__label-wrapper"));
                WebElement grandson = parent.findElement(By.cssSelector(".oxd-input.oxd-input--active"));
                if (child.getText().equals(value)) {
                    grandson.sendKeys("Uspelo je");
                    break;
                }
            }
        }


    }
}



