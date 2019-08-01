package task2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.codersGuru.ConfirmationPage;
import pages.codersGuru.MainPage;
import pages.codersGuru.RegisterPage;
import pages.codersGuru.SettingsPage;

public class UserRegistration {
    private WebDriver driver;

    public UserRegistration() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Given("^open browser with page (.*)$")
    public void openCodersGuruPage(String url) { driver.get(url); }


    @When("^user clicks button for account creation for (.*)$")
    public void clickRegistrationButton(String email) {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToRegistrationForm(email);
    }

    @Then("^opens form for registration$")
    public void confirmFormUrl() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.urlToBe("https://tester.codersguru.pl/register/")));
    }

    @And("^user chooses private user registration$")
    public void selectPrivateUser() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.markPrivatePerson();
    }

    @And("^user inputs user details (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void inputsUserDetails(String email, String name, String lastName, String password, String passwordConfirmation, String city, String postalCode, String streetName, String streetNumber) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.enterUserData(email, name, lastName, password, passwordConfirmation, city, postalCode, streetName, streetNumber);
    }

    @And("^user accepts regulations$")
    public void acceptsRegulations() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.confirmRegulations();
    }

    @And("^data is valid$")
    public void checkData() {
        RegisterPage registerPage = new RegisterPage(driver);
        try {
            registerPage.wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("span.form-error"))));
        } catch (NoSuchElementException e) { }
    }

    @And("^user clicks button for registration$")
    public void clickButtonForRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.createAccount();
    }

    @Then("^opens page with confirmation$")
    public void checkConfirmationUrl() {
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.wait.until(ExpectedConditions.urlToBe("https://tester.codersguru.pl/register/confirmed")));
    }

    @And("^user (.*) is logged in$")
    public void userNameVisible(String name) {
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.userNameIsVisible(name));
        confirmationPage.preparToLogOut();
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.logOutUser();
    }

    @And("^close codersGuru page$")
    public void closeCodersGuruPage() {
        driver.quit();
    }

}
