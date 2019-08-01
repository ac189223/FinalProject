package pages.phpTravels;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class MainPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "fa-plane")
    private WebElement flightsSelectorElement;

    @FindBy(id = "thflights")
    private WebElement flightsSelectPanel;

    @FindBy(id = "s2id_origin")
    private WebElement locationFromClickable;

    @FindBy(id = "select2-drop")
    private WebElement locationSelectParent;

    @FindBy(id = "s2id_destination")
    private WebElement locationToClickable;

    @FindBy(name = "departure")
    private WebElement departureDateElement;

    @FindBy(name = "arrival")
    private WebElement arrivalDateElement;

    @FindBy(id = "round")
    private WebElement roundTripElement;

    @FindBy(name = "totalManualPassenger")
    private WebElement numberOfPassengersElement;

    @FindBy(id = "madult")
    private WebElement numberOfAdultsElement;

    @FindBy(id = "sumManualPassenger")
    private WebElement numberOfPassengersConfirmationButton;

    public void changeToFlightsBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsSelectorElement));
        flightsSelectorElement.click();
    }

    public void selectRoundTrip() {
        WebElement roundTripSelector = roundTripElement.findElement(By.xpath("./..//ins"));
        roundTripSelector.click();
    }

    public void enterFlightDetails(String departureAirport, String arrivalAirport, String departureDate, String arrivalDate, int numberOfPassengers) {
        enterDepartureAirport(departureAirport);
        enterArrivalAirport(arrivalAirport);
        enterDepartureTime(departureDate);
        enterArrivalTime(arrivalDate);
        enterNumberOfPassengers(numberOfPassengers);
    }

    private void enterDepartureAirport(String airportName) {
        wait.until(ExpectedConditions.elementToBeClickable(locationFromClickable));
        locationFromClickable.click();
        searchForAirport(airportName);
    }

    private void enterArrivalAirport(String airportName) {
        wait.until(ExpectedConditions.elementToBeClickable(locationToClickable));
        locationToClickable.click();
        searchForAirport(airportName);
    }

    private void searchForAirport(String airportName) {
        wait.until(ExpectedConditions.elementToBeClickable(locationSelectParent));
        WebElement locationSelect = locationSelectParent.findElement(By.cssSelector("input.select2-input"));
        locationSelect.sendKeys(airportName);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.select2-match")));
        List<WebElement> availableAirportsList = driver.findElements(By.cssSelector("span.select2-match"));
        availableAirportsList.get(0).click();
    }

    private void enterDepartureTime(String departureTime) {
        enterTime(departureDateElement, departureTime);
    }

    private void enterArrivalTime(String arrivalTime) {
        enterTime(arrivalDateElement, arrivalTime);
    }

    private void enterTime(WebElement dateElement, String time) {
        wait.until(ExpectedConditions.elementToBeClickable(dateElement));
        dateElement.click();
        dateElement.clear();
        dateElement.sendKeys(time);
        dateElement.click();
    }

    private void enterNumberOfPassengers(int numberOfPassengers) {
        Assert.assertTrue(numberOfPassengers < 4);
        wait.until(ExpectedConditions.elementToBeClickable(numberOfPassengersElement));
        numberOfPassengersElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(numberOfAdultsElement));
        List<WebElement> numberOfAdultsList = numberOfAdultsElement.findElements(By.xpath(".//option"));
        numberOfAdultsList.get(numberOfPassengers - 1).click();
        wait.until(ExpectedConditions.elementToBeClickable(numberOfPassengersConfirmationButton));
        numberOfPassengersConfirmationButton.click();
    }

    public void captureSearchDetailsScreenShot() throws IOException {
        WebElement elementToCapture = driver.findElement(By.cssSelector("div.col-md-12"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        String fileName = "01_flightsSearchDetails";
        captureElementScreenshot(elementToCapture, fileName);
    }

    public void searchForFlights(){
        wait.until(ExpectedConditions.elementToBeClickable((flightsSelectPanel.findElement(By.cssSelector("div.search-button"))).findElement(By.xpath("./button"))));
        WebElement searchButtonParent = flightsSelectPanel.findElement(By.cssSelector("div.search-button"));
        WebElement searchButton = searchButtonParent.findElement(By.xpath("./button"));
        searchButton.submit();
    }

}
