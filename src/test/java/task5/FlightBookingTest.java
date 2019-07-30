package task5;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.phpTravels.MainPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FlightBookingTest {
    private static WebDriver driver;
    private MainPage mainPage = new MainPage(driver);
    private String departureAirport = "WAW";
    private String arrivalAirport = "JFK";
    private String departureDate = "2019-10-10";
    private String arrivalDate = "2019-10-30";
    private int numberOfPassengers = 1;
    private String searchResultsURL = "https://www.phptravels.net/thflights/search/" +
            departureAirport + "/" + arrivalAirport + "/return/" +
            departureDate + "/" + arrivalDate + "/" + numberOfPassengers + "/0/0";

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
        mainPage.enterFlightDetails(departureAirport, arrivalAirport, departureDate, arrivalDate, numberOfPassengers);
        mainPage.searchForFlights();
        Assert.assertTrue(mainPage.wait.until(ExpectedConditions.urlToBe(searchResultsURL)));
    }

    @Test
    public void FlightBookingTest_02_shouldChooseFlight() {

    }


    @AfterClass
    public static void tearDown() throws Exception {
        //driver.quit();
    }
}
