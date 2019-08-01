package pages.codersGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    private WebElement emailForAccountCreationElement;

    public void goToRegistrationForm(String email) {
        fillInField(emailForAccountCreationElement, email);
        WebElement createAccountButton = (emailForAccountCreationElement.findElement(By.xpath("./.."))).findElement(By.cssSelector("input.link"));
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton));
        createAccountButton.click();
    }

    private void fillInField(WebElement fieldName, String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName));
        fieldName.click();
        fieldName.clear();
        fieldName.sendKeys(inputText);
    }

}
