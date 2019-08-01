package pages.codersGuru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends PageObject{
    private int defaultTimeout = 60;
    public WebDriverWait wait = new WebDriverWait(driver,defaultTimeout);

    public RegisterPage(WebDriver driver) { super(driver); }

    @FindBy(id = "person")
    private WebElement privatePersonMarkerElement;

    @FindBy(id = "fos_user_registration_form_email")
    private WebElement emailForRegisterElement;

    @FindBy(id = "fos_user_registration_form_name")
    private WebElement nameForRegisterElement;

    @FindBy(id = "fos_user_registration_form_lastname")
    private WebElement lastNameForRegisterElement;

    @FindBy(id = "fos_user_registration_form_plainPassword_first")
    private WebElement passwordForRegisterElement;

    @FindBy(id = "fos_user_registration_form_plainPassword_second")
    private WebElement passwordConfForRegisterElement;

    @FindBy(id = "form_city")
    private WebElement cityForRegisterElement;

    @FindBy(id = "form_postal_code")
    private WebElement postalCodeForRegisterElement;

    @FindBy(id = "form_street")
    private WebElement streetNameForRegisterElement;

    @FindBy(id = "form_number")
    private WebElement streetNumberForRegisterElement;

    @FindBy(className = "login-checkbox")
    private WebElement confirmationCheckboxParent;

    @FindBy(id = "register-submit-btn")
    private WebElement registerButton;

    public void markPrivatePerson() {
        if (!privatePersonMarkerElement.isSelected()) {
            privatePersonMarkerElement.click();
        }
    }

    public void enterUserData(String email, String name, String lastName, String password, String passwordConfirmation, String city, String postalCode, String streetName, String streetNumber) {
        fillInField(emailForRegisterElement, email);
        fillInField(nameForRegisterElement, name);
        fillInField(lastNameForRegisterElement, lastName);
        fillInField(passwordForRegisterElement, password);
        fillInField(passwordConfForRegisterElement, passwordConfirmation);
        fillInField(cityForRegisterElement, city);
        fillInField(postalCodeForRegisterElement, postalCode);
        fillInField(streetNameForRegisterElement, streetName);
        fillInField(streetNumberForRegisterElement, streetNumber);
    }

    private void fillInField(WebElement fieldName, String inputText) {
        wait.until(ExpectedConditions.elementToBeClickable(fieldName));
        fieldName.click();
        fieldName.clear();
        fieldName.sendKeys(inputText);
    }

    public void confirmRegulations() {
        WebElement confirmationCheckbox = confirmationCheckboxParent.findElement(By.xpath("./input"));
        wait.until(ExpectedConditions.elementToBeClickable(confirmationCheckbox));
        confirmationCheckbox.click();
    }

    public void createAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
}
