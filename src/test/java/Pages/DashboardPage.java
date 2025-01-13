
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wdwait;
    WebElement dashboardHeader;
    List<WebElement> listOfRedirections;
    WebElement upgradeButton;
    List<WebElement> itemsofDDLNearPhotoOfUser;
    WebElement userDropDown;
    WebElement popupCloseButton;

    public DashboardPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getDashboardHeader() {
        return driver.findElement(By.className("oxd-topbar-header-breadcrumb"));
    }

    public WebElement getUpgradeButton(){
        return wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-icon.orangehrm-upgrade-icon")));
    }

    public WebElement getPopupCloseButton(){
        return wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-dialog-close-button.oxd-dialog-close-button-position")));
    }


    //------
    public void redirectionToPage(String requestedPage) {
        listOfRedirections = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".oxd-text.oxd-text--span.oxd-main-menu-item--name")));
        JavascriptExecutor js = (JavascriptExecutor)
                driver;for (int i = 0; i < listOfRedirections.size(); i++) {WebElement redirection = listOfRedirections.get(i);
            js.executeScript("arguments[0].scrollIntoView(true);", redirection);
            if (redirection.getText().equals(requestedPage)){
                redirection.click();
                break;}
        }
    }

    public void redirectionToItemOfDDL(String requestedOption) {
        userDropDown = driver.findElement(By.className("oxd-userdropdown-tab"));
        userDropDown.click();
        itemsofDDLNearPhotoOfUser = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("oxd-userdropdown-link")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < itemsofDDLNearPhotoOfUser.size(); i++) {
            WebElement redirection = itemsofDDLNearPhotoOfUser.get(i);
            js.executeScript("arguments[0].scrollIntoView(true);", redirection);
            if (redirection.getText().equals(requestedOption)){
                redirection.click();
                break;
            }
        }
    }
}
