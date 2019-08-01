package task5;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.phpTravels.MainPage;
import pages.phpTravels.PaymentFormPage;
import pages.phpTravels.SearchResultsPage;

import java.io.IOException;

public class FlightBookingWithCucumber {
    private WebDriver driver;

    public FlightBookingWithCucumber() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Given("^an open browser with (.*)$")
    public void openPhpTravelsPage(String url) {
        driver.get(url);
    }

    @When("^user inputs flight details (.*), (.*), (.*), (.*), (.*)$")
    public void enterDetailsOfFlight(String departureAirport, String arrivalAirport, String departureDate, String arrivalDate, int numberOfPassengers) throws IOException {
        MainPage mainPage = new MainPage(driver);
        mainPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/"));
        mainPage.changeToFlightsBooking();
        mainPage.selectRoundTrip();
        mainPage.enterFlightDetails(departureAirport, arrivalAirport, departureDate, arrivalDate, numberOfPassengers);
        mainPage.captureSearchDetailsScreenShot();
    }

    @And("^clicks button for flights searching$")
    public void searchForFlightOptions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchForFlights();
    }

    @Then("^opens page with search results for (.*), (.*), (.*), (.*), (.*)$")
    public void checkSearchResultsUrl(String departureAirport, String arrivalAirport, String departureDate, String arrivalDate, int numberOfPassengers) {
        MainPage mainPage = new MainPage(driver);
        String searchResultsURL = "https://www.phptravels.net/thflights/search/" +
                departureAirport + "/" + arrivalAirport + "/return/" +
                departureDate + "/" + arrivalDate + "/" + numberOfPassengers + "/0/0";
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.urlToBe(searchResultsURL)));
    }

    @And("^user clicks button for flight booking$")
    public void chooseFromFlightOptions() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.chooseFlight();
    }

    @Then("^opens form for flight confirmation$")
    public void checkConfirmationPageUrl() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(searchResultsPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/thflights/checkout")));
    }

    @And("^user inputs traveller info (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void inputTravellerInfo(String title, String name, String surname, String email, String phone, String birthday, String idCardNumber, String idCardExpirationDate, String nationality) {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.acceptCookies();
        paymentFormPage.chooseGuestBooking();
        paymentFormPage.enterTravellerInfo(title, name, surname, email, phone, birthday, idCardNumber, idCardExpirationDate, nationality);
    }

    @And("^user inputs payment information (.*), (.*), (.*), (.*), (.*)$")
    public void inputPaymentInformation(String cardType, String cardNumber, int cardExpirationMonth, String cardExpirationYear, String cvvNumber) {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.enterPaymentInformation(cardType, cardNumber, cardExpirationMonth, cardExpirationYear, cvvNumber);
    }

    @And("^user checks flight details$")
    public void openFlightDetails() {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.showFlightsDetails();
    }

    @Then("^flights details are visible$")
    public void checkFlightsDetails() {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        Assert.assertTrue(paymentFormPage.flightDetailsVisible());
    }

    @And("^user can make screenshoots$")
    public void makeScreenshoots() throws IOException {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.captureFlightOverlookScreenShot();
        paymentFormPage.captureFlightDetailsScreenShot();
        paymentFormPage.captureTravellerInfoScreenShot();
        paymentFormPage.capturePaymentInformationScreenShot();
    }

    @And("^close phpTravels page$")
    public void closePhpTravelsPage() {
        driver.quit();
    }
}
