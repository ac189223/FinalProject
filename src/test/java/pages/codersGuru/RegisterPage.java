//package pages.codersGuru;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class RegisterPage extends PageObject{
//
//    public RegisterPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(id = "person")
//    WebElement privatPersonMarkerElement;
//
//    @FindBy(id = "fos_user_registration_form_email")
//    WebElement emailForRegisterElement;
//
//    @FindBy(id = "fos_user_registration_form_name")
//    WebElement nameForRegisterElement;
//
//    @FindBy(id = "fos_user_registration_form_lastname")
//    WebElement lastNameForRegisterElement;
//
//    @FindBy(id = "fos_user_registration_form_plainPassword_first")
//    WebElement passwordForRegisterElement;
//
//    @FindBy(id = "fos_user_registration_form_plainPassword_second")
//    WebElement passwordConfForRegisterElement;
//
//    @FindBy(id = "form_city")
//    WebElement cityForRegisterElement;
//
//    @FindBy(id = "form_postal_code")
//    WebElement postalCodeForRegisterElement;
//
//    @FindBy(id = "form_street")
//    WebElement streetNameForRegisterElement;
//
//    @FindBy(id = "form_number")
//    WebElement streetNumberForRegisterElement;
//
//    @FindBy(className = "login-checkbox")
//    WebElement confirmationCheckboxParent;
//
//    @FindBy(id = "register-submit-btn")
//    WebElement registerButton;
//
//    void markPrivatPerson(WebDriver driver) {
//        if (!privatPersonMarkerElement.isSelected()) {
//            privatPersonMarkerElement.click();
//        }
//    }
//
//    void enterDataAndCreateAccount(String email, String name, String lastName, String password, String passwordConfirmation, String city, String postalCode, String streetName, String streetNumber, WebDriver driver) {
//        fillInField(emailForRegisterElement, email);
//        fillInField(nameForRegisterElement, name);
//        fillInField(lastNameForRegisterElement, lastName);
//        fillInField(passwordForRegisterElement, password);
//        fillInField(passwordConfForRegisterElement, passwordConfirmation);
//        fillInField(cityForRegisterElement, city);
//        fillInField(postalCodeForRegisterElement, postalCode);
//        fillInField(streetNameForRegisterElement, streetName);
//        fillInField(streetNumberForRegisterElement, streetNumber);
//        confirmation(confirmationCheckboxParent);
//        registerButton.click();
//        waitForLoading(driver);
//    }
//
//    private void confirmation(WebElement parentElement) {
//        WebElement confirmationCheckbox = parentElement.findElement(By.xpath("./input"));
//        confirmationCheckbox.click();
//    }
//
//
//}
