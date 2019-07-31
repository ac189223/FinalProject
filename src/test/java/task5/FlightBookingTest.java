package task5;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.phpTravels.MainPage;
import pages.phpTravels.PaymentFormPage;
import pages.phpTravels.SearchResultsPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlightBookingTest {
    private static WebDriver driver;
    private MainPage mainPage = new MainPage(driver);
    private SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    private PaymentFormPage paymentFormPage = new PaymentFormPage(driver);
    private FlightBookingData data = new FlightBookingData();

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
    public void FlightBookingTest_01_shouldSearchForFlights() {
        mainPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/"));
        mainPage.changeToFlightsBooking();
        mainPage.selectRoundTrip();
        mainPage.enterFlightDetails(data.getDepartureAirport(), data.getArrivalAirport(),
                data.getDepartureDate(), data.getArrivalDate(), data.getNumberOfPassengers());
        mainPage.searchForFlights();
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.urlToBe(data.getSearchResultsURL())));
    }

    @Test
    public void FlightBookingTest_02_shouldChooseFlight() {
        searchResultsPage.chooseFlight();
        Assert.assertTrue(searchResultsPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/thflights/checkout")));
    }

    @Test
    public void FlightBookingTest_03_shouldFillInPaymentForm() {
        paymentFormPage.chooseGuestBooking();
        paymentFormPage.enterTravellerInfo(data.getTitle(), data.getName(), data.getSurname(),
                data.getEmail(), data.getPhone(), data.getBirthday(),
                data.getIdCardNumber(), data.getIdCardExpirationDate(), data.getNationality());
        paymentFormPage.enterPaymentInformation(data.getCardType(), data.getCardNumber(),
                data.getCardExpirationMonth(), data.getCardExpirationYear(), data.getCvvNumber());
        paymentFormPage.confirmBooking();
        // Assert.assertTrue(paymentFormPage.wait.until(ExpectedConditions.urlToBe("https://www.phptravels.net/thflights/checkout")));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        //driver.quit();
    }
}
