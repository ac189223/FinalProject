package pages.codersGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void logOutUser() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.settings__desktop-buttons-section"))));
        WebElement logOutButtonParent = driver.findElement(By.cssSelector("div.settings__desktop-buttons-section"));
        WebElement logOutButton = logOutButtonParent.findElement(By.cssSelector("button.button"));
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        wait.until(ExpectedConditions.urlToBe("https://tester.codersguru.pl/"));
    }

}
