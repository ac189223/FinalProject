package pages.codersGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    @FindBy(id = "user-name")
    private WebElement loggedInUserElement;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public boolean userNameIsVisible(String name) {
        wait.until(ExpectedConditions.visibilityOf(loggedInUserElement));
        boolean check = loggedInUserElement.getText().equals(name);
        return check;
    }

    public void preparToLogOut() {
        WebElement settingsLinkElement =  driver.findElement(By.cssSelector("div.header__user-info")).findElement(By.xpath("./a"));
        wait.until(ExpectedConditions.elementToBeClickable(settingsLinkElement));
        settingsLinkElement.click();
        wait.until(ExpectedConditions.urlToBe("https://tester.codersguru.pl/settings"));
    }
}
