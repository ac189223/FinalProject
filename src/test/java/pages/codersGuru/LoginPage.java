//package pages.codersGuru;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class LoginPage extends PageObject{
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(name = "_username")
//    WebElement emailForLogIntoElement;
//
//    @FindBy(name = "_Password")
//    WebElement passwordElement;
//
//    @FindBy(id = "_submit")
//    WebElement logInButton;
//
//    void logInto(String userName, String password, WebDriver driver) {
//        fillInField(emailForLogIntoElement, userName);
//        fillInField(passwordElement, password);
//        logInButton.click();
//        waitForLoading(driver);
//    }
//
//}
