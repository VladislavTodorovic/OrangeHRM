package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopupPage {
    WebDriver driver;
    WebDriverWait wdwait;

    public PopupPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public static void handlePopup(WebDriver driver, WebDriverWait wait) {
        try {

            driver.findElement(By.cssSelector("")).click();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Popup message: " + alertText);
            // Prihvatite popup
            alert.accept();

        } catch (Exception e) {
            System.out.println("Nema popup poruke!" + e.getMessage());
        }
    }
}
