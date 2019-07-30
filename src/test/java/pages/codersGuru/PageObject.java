//package pages.codersGuru;
//
//import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//
//import java.util.concurrent.TimeUnit;
//
//public class PageObject {
//    private WebDriver driver;
//
//    public PageObject(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    void waitForLoading(WebDriver driver) {
//        // Wait for loading (max 10sek)
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    void fillInField(WebElement fieldName, String inputText) {
//        fieldName.click();
//        fieldName.clear();
//        fieldName.sendKeys(inputText);
//    }
//
//    void confirmWebAddress(String webPageAddress, WebDriver driver) {
//        // Check if current url is an expected one
//        Assert.assertEquals(webPageAddress, driver.getCurrentUrl());
//    }
//}
