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
    WebElement searchButtonBelowEmployeeInformationFields;


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

    public WebElement getSearchButtonBelowEmployeeInformationFields() {
        return driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space"));
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

//OVO JE DOBRO, NE DIRAJ GA DA NE BI SVE POKVARIO!
    public void searchFormularForId(String nameOfField, String valueInField) {
        List<WebElement> listOfParentElements = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".oxd-input-group.oxd-input-field-bottom-space")));
        for (WebElement parent : listOfParentElements) {
            List<WebElement> childElements = parent.findElements(By.className("oxd-input-group__label-wrapper"));
            for (WebElement child : childElements) {
                if (child.getText().equals(nameOfField)) {
                    List<WebElement> grandsonElements = parent.findElements(By.cssSelector(".oxd-input.oxd-input--active"));
                    if (!grandsonElements.isEmpty()) {
                        WebElement grandson = grandsonElements.get(0);
                        if (grandson.isDisplayed() && grandson.isEnabled()) {
                            grandson.sendKeys(valueInField);
                            break;
                        }
                    }
                    }
                }
            }
        }

    public void searchFormularForEmployeeNameOrSupervisorName(String nameOfField, String valueInField) {
        List<WebElement> listOfParentElements = wdwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".oxd-input-group.oxd-input-field-bottom-space")));

        for (WebElement parent : listOfParentElements) {
            // Nalazimo child elemente
            List<WebElement> childElements = parent.findElements(By.className("oxd-input-group__label-wrapper"));

            for (WebElement child : childElements) {
                // Ako je tekst u child elementu jednak nameOfField, unosimo vrednost u grandson
                if (child.getText().equals(nameOfField)) {

                    // Nalazimo grandson elemente u okviru trenutnog parent elementa
                    List<WebElement> grandsonElements = parent.findElements(By.cssSelector(".oxd-autocomplete-text-input.oxd-autocomplete-text-input--active"));

                    if (!grandsonElements.isEmpty()) {
                        WebElement grandson = grandsonElements.get(0);

                        // Proveravamo da li je grandson prikazan i omogućeno je da se u njega unese tekst
                        if (grandson.isDisplayed() && grandson.isEnabled()) {
                            grandson.sendKeys(valueInField);
                            grandson.click();  // Ako je potrebno, kliknite na element nakon unosa

                            break;  // Prekidamo petlju nakon što smo uneli vrednost u grandson
                        }
                    }
                }
            }
        }
    }


    }





