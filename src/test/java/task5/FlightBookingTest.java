package task5;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.phpTravels.MainPage;
import pages.phpTravels.PaymentFormPage;
import pages.phpTravels.SearchResultsPage;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlightBookingTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver",
                "src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/");
    }

    @Test
    public void FlightBookingTest_01_shouldSearchForFlights() throws IOException {
        MainPage mainPage = new MainPage(driver);
        String departureAirport = "WAW";
        String arrivalAirport = "JFK";
        String departureDate = "2019-10-10";
        String arrivalDate = "2019-10-30";
        int numberOfPassengers = 1;
        String searchResultsURL = "https://www.phptravels.net/thflights/search/" +
                departureAirport + "/" + arrivalAirport + "/return/" +
                departureDate + "/" + arrivalDate + "/" + numberOfPassengers + "/0/0";
        mainPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/"));
        mainPage.changeToFlightsBooking();
        mainPage.selectRoundTrip();
        mainPage.enterFlightDetails(departureAirport, arrivalAirport, departureDate, arrivalDate, numberOfPassengers);
        mainPage.captureSearchDetailsScreenShot();
        mainPage.searchForFlights();
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.urlToBe(searchResultsURL)));
    }

    @Test
    public void FlightBookingTest_02_shouldChooseFlight() {
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.chooseFlight();
        Assert.assertTrue(searchResultsPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/thflights/checkout")));
    }

    @Test
    public void FlightBookingTest_03_shouldFillInPaymentForm() {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.acceptCookies();
        paymentFormPage.chooseGuestBooking();
        paymentFormPage.enterTravellerInfo("Ms.", "Muriel", "Jewell", "MurielRJewell@jourrapide.com ", "917-220-8857", "1970-11-21", "579388816", "2025-02-16", "UNITED STATES");
        paymentFormPage.enterPaymentInformation("Visa", "4539 3078 9852 0425", 12, "2022", "046");
        paymentFormPage.showFlightsDetails();
        Assert.assertTrue(paymentFormPage.flightDetailsVisible());
    }

    @Test
    public void FlightBookingTest_04_shouldCaptureScreenShots() throws IOException {
        PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
        paymentFormPage.captureFlightOverlookScreenShot();
        paymentFormPage.captureFlightDetailsScreenShot();
        paymentFormPage.captureTravellerInfoScreenShot();
        paymentFormPage.capturePaymentInformationScreenShot();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}
