package pages.phpTravels;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.List;

public class PaymentFormPage extends PageObject {
    private int defaultTimeout = 60;
    private WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public PaymentFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "mb15")
    private WebElement bookingTypeForm;

    @FindBy(id = "title")
    private WebElement titlesParent;

    @FindBy(id = "name")
    private WebElement nameElement;

    @FindBy(id = "surname")
    private WebElement surnameElement;

    @FindBy(id = "phone")
    private WebElement phoneElement;

    @FindBy(id = "birthday")
    private WebElement birthdayElement;

    @FindBy(id = "cardno")
    private WebElement idCardNumberElement;

    @FindBy(id = "expiration")
    private WebElement idCardExpirationDateElement;

    @FindBy(id = "s2id_nationality")
    private WebElement nationalityClickable;

    @FindBy(className = "select2-input")
    private WebElement nationalitySearchable;

    @FindBy(className = "select2-highlighted")
    private WebElement nationalitySearchResultElement;

    @FindBy(id = "cardtype")
    private WebElement cardTypesParent;

    @FindBy(id = "card-number")
    private WebElement cardNumberElement;

    @FindBy(id = "expiry-month")
    private WebElement cardExpirationMonthsParent;

    @FindBy(id = "expiry-year")
    private WebElement cardExpirationYearsParent;

    @FindBy(id = "cvv")
    private WebElement cvvNumberElement;

    @FindBy(className = "icon-angle-down")
    private WebElement showFlightDetailsElement;

    @FindBy(id = "details")
    private WebElement flightDetailsSection;

     @FindBy(id = "cookyGotItBtn")
     private WebElement acceptCookiesButton;

    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
        acceptCookiesButton.click();
    }

    public void chooseGuestBooking() {
        WebElement guestBookingButton = bookingTypeForm.findElement(By.linkText("GUEST BOOKING"));
        wait.until(ExpectedConditions.elementToBeClickable(guestBookingButton));
        guestBookingButton.click();
    }

    public void enterTravellerInfo(String title, String name, String surname, String email, String phone, String birthday, String idCardNumber, String idCardExpirationDate, String nationality) {
        enterTravellerTitle(title);
        enterTravellerName(name);
        enterTravellerSurname(surname);
        enterTravellerEmail(email);
        enterTravellerPhone(phone);
        enterTravellerBirthday(birthday);
        enterTravellerIdCardNumber(idCardNumber);
        enterTravellerIdCardExpirationDate(idCardExpirationDate);
        enterTravellerNationality(nationality);
    }

    private void enterTravellerTitle(String title) {
        selectFromList(titlesParent, title);
    }

    private void enterTravellerName(String name) {
        enterIntoField(nameElement, name);
    }

    private void enterTravellerSurname(String surname) {
        enterIntoField(surnameElement, surname);
    }

    private void enterTravellerEmail(String email) {
        List<WebElement> emailElements = driver.findElements(By.id("email"));
        for (WebElement emailElement : emailElements) {
            if (emailElement.getAttribute("class").equals("form-control") && emailElement.isDisplayed()) {
                enterIntoField(emailElement, email);
                break;
            }
        }
    }

    private void enterTravellerPhone(String phone) {
        enterIntoField(phoneElement, phone);
    }

    private void enterTravellerBirthday(String birthday) {
        enterIntoField(birthdayElement, birthday);
    }

    private void enterTravellerIdCardNumber(String idCardNumber) {
        enterIntoField(idCardNumberElement, idCardNumber);
    }

    private void enterTravellerIdCardExpirationDate(String idCardExpirationDate) {
        enterIntoField(idCardExpirationDateElement, idCardExpirationDate);
    }

    private void enterTravellerNationality(String nationality) {
        Actions builder = new Actions(driver);
        builder.clickAndHold(nationalityClickable).perform();
        nationalitySearchable.click();
        nationalitySearchable.sendKeys(nationality);
        wait.until(ExpectedConditions.elementToBeClickable(nationalitySearchResultElement));
        nationalitySearchResultElement.click();
    }

    public void enterPaymentInformation(String cardType, String cardNumber, int cardExpirationMonth, String cardExpirationYear, String cvvNumber) {
        enterCardType(cardType);
        enterCardNumber(cardNumber);
        enterCardExpirationMonth(cardExpirationMonth);
        enterCardExpirationYear(cardExpirationYear);
        enterCvvNumber(cvvNumber);
    }

    private void enterCardType(String cardType) {
        selectFromList(cardTypesParent, cardType);
    }

    private void enterCardNumber(String cardNumber) {
        enterIntoField(cardNumberElement, cardNumber);
    }

    private void enterCardExpirationMonth(int cardExpirationMonth) {
        formSelectionList(cardExpirationMonthsParent).selectByIndex(cardExpirationMonth);
    }

    private void enterCardExpirationYear(String cardExpirationYear) {
        selectFromList(cardExpirationYearsParent, cardExpirationYear);
    }

    private void enterCvvNumber(String cvvNumber) {
        enterIntoField(cvvNumberElement, cvvNumber);
    }

    private void selectFromList(WebElement selectParent, String inputText) {
        formSelectionList(selectParent).selectByVisibleText(inputText);
    }

    private Select formSelectionList(WebElement selectParent) {
        List<WebElement> selectList = selectParent.findElements(By.xpath("./option"));
        wait.until(ExpectedConditions.visibilityOfAllElements(selectList));
        return new Select(driver.findElement(By.id(selectParent.getAttribute("id"))));
    }

    private void enterIntoField(WebElement element, String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }

    public void showFlightsDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(showFlightDetailsElement));
        showFlightDetailsElement.click();
    }

    public boolean flightDetailsVisible() {
        return flightDetailsSection.isDisplayed();
    }

    public void captureFlightOverlookScreenShot() throws IOException {
        WebElement elementToCapture = driver.findElement(By.cssSelector("div.panel-body"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        String fileName = "02_flightOverlook";
        captureElementScreenshot(elementToCapture, fileName);
    }

    public void captureFlightDetailsScreenShot() throws IOException {
        WebElement elementToCapture = driver.findElement(By.id("details"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        js.executeScript("window.scrollBy(0,20)");
        String fileName = "03_flightDetails";
        captureScreenshot(fileName);
    }

    public void captureTravellerInfoScreenShot() throws IOException {
        WebElement elementToCaptureParent = driver.findElement(By.name("ticketBookingForm"));
        WebElement elementToCapture = elementToCaptureParent.findElement(By.xpath("./div/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        String fileName = "04_travellerInfo";
        captureElementScreenshot(elementToCapture, fileName);
    }

    public void capturePaymentInformationScreenShot() throws IOException {
        WebElement elementToCaptureParent = driver.findElement(By.name("ticketBookingForm"));
        WebElement elementToCapture = elementToCaptureParent.findElement(By.xpath("./div/div[2]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToCapture);
        String fileName = "05_paymentInformation";
        captureElementScreenshot(elementToCapture, fileName);
    }
}

