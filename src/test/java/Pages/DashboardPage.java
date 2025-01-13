
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
    WebElement helpButton;
    WebElement shrinkArrow;
    WebElement expandArrow;
    WebElement searchButton;
    WebElement currentPasswordField;
    WebElement passwordField;
    WebElement confirmPasswordField;
    WebElement passwordChangeSaveButton;
    WebElement textGettingStartedWithOrangeHRM;
    WebElement layoutSpace;
    WebElement popupSuccess;
    WebElement passwordsDoNotMatch;


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

    public WebElement getHelpButton() {
        return wdwait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-icon.bi-question-lg")));
    }

    public WebElement getShrinkArrow() {
        return driver.findElement(By.cssSelector(".oxd-icon.bi-chevron-left"));
    }

    public WebElement getExpandArrow() {
        return driver.findElement(By.cssSelector(".oxd-icon.bi-chevron-right"));
    }

    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector(".oxd-input.oxd-input--active"));
    }

    public WebElement getCurrentPasswordField() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/input"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
    }

    public WebElement getConfirmPasswordField() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input"));
    }

    public WebElement getPasswordChangeSaveButton() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
    }

    public WebElement getTextGettingStartedWithOrangeHRM() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.orangehrm-main-title"));
    }

    public WebElement getLayoutSpace() {
        return driver.findElement(By.className("oxd-layout-context"));
    }

    public WebElement getPopupSuccess() {
      return driver.findElement(By.cssSelector(".oxd-toast-container.oxd-toast-container--bottom"));
    }

    public WebElement getPasswordsDoNotMatch() {
        return driver.findElement(By.cssSelector(".oxd-text.oxd-text--span.oxd-input-field-error-message.oxd-input-group__message"));
    }

    //--------------------------------------------

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
