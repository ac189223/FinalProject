package pages.phpTravels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentFormPage extends PageObject {
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public PaymentFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "mb15")
    WebElement bookingTypeForm;

    @FindBy(id = "title")
    WebElement titlesParent;

    @FindBy(id = "name")
    WebElement nameElement;

    @FindBy(id = "surname")
    WebElement surnameElement;

    @FindBy(id = "email")
    WebElement emailElement;

    @FindBy(id = "phone")
    WebElement phoneElement;

    @FindBy(id = "birthday")
    WebElement birthdayElement;

    @FindBy(id = "cardno")
    WebElement idCardNumberElement;

    @FindBy(id = "expiration")
    WebElement idCardExpirationDateElement;

    @FindBy(id = "select2-drop")
    WebElement nationalityClickable;

    @FindBy(className = "select2-input")
    WebElement nationalitySearchable;

    @FindBy(className = "select2-highlighted")
    WebElement nationalitySearchResultElement;

    @FindBy(id = "cardtype")
    WebElement cardTypesParent;

    @FindBy(id = "card-number")
    WebElement cardNumberElement;

    @FindBy(id = "expiry-month")
    WebElement cardExpirationMonthsParent;

    @FindBy(id = "expiry-year")
    WebElement cardExpirationYearsParent;

    @FindBy(id = "cvv")
    WebElement cvvNumberElement;

    @FindBy(id = "confirmBooking")
    WebElement bookingConfirmationButton;

    public void chooseGuestBooking() {
        WebElement guestBookingButton = bookingTypeForm.findElement(By.linkText("GUEST BOOKING"));
        wait.until(ExpectedConditions.elementToBeClickable(guestBookingButton));
        guestBookingButton.click();
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
    }

    public void enterTravellerInfo(String title, String name, String surname, String email, String phone, String birthday, String idCardNumber, String idCardExpirationDate, String nationality) {
    }

    public void enterPaymentInformation(String cardType, String cardNumber, String cardExpirationMonth, String cardExpirationYear, String cvvNumber) {

    }

    public void confirmBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(bookingConfirmationButton));
        bookingConfirmationButton.click();
    }
}

