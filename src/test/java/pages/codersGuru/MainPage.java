//package pages.codersGuru;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class MainPage extends PageObject {
//
//    public MainPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(name = "button")
//    WebElement logInButton;
//
//    @FindBy(name = "email")
//    WebElement emailForAccountCreationElement;
//
//    @FindBy(className = "main-page-top__email-input-sent")
//    WebElement createAccountButton;
//
//    void goToLoginPage(WebDriver driver) {
//        logInButton.click();
//        waitForLoading(driver);
//    }
//
//    void goToAccountCreationPage(String email, WebDriver driver) {
//        fillInField(emailForAccountCreationElement, email);
//        createAccountButton.click();
//        waitForLoading(driver);
//    }
//
//}
