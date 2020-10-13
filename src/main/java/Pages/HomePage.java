package Pages;

import Helper.CreditsGenerator;
import Helper.FileReader;

import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage{

    private static final By registrationButton = By.xpath("//*[@id='registation_button']");
    private static final By formRegistrationButton = By.xpath("//*[@class='c-registration__button button button_light submit_registration']");

    private static final By regionSelector = By.xpath("//*[@class='c-registration__field c-registration__field--region']");
    private static final By regionSelectorItem = By.xpath("//*[@class='c-registration__field c-registration__field--region']//li[1]");
    private static final By citySelector = By.xpath("//*[@class='c-registration__field c-registration__field--city']");
    private static final By citySelectorItem = By.xpath("//*[@class='c-registration__field c-registration__field--city']//li[3]");

    private static final By emailInput = By.xpath("//*[@id='popup_registratio_email']");
    private static final By nameInput = By.xpath("//*[@id='popup_registratio_name']");
    private static final By surnameInput = By.xpath("//*[@id='popup_registratio_surname']");
    private static final By passwordInput = By.xpath("//*[@id='popup_registratio_password']");
    private static final By repeatPasswordInput = By.xpath("//*[@id='popup_registratio_password_again']");

    private static final By registrationDialog = By.xpath("//*[@id='reg_info_modal']");
    private static final By inputField = By.xpath("//*[@id='userLoginFast']");
    private static final By passwordField = By.xpath("//*[@id='userPasswordFast']");
    private static final By logInButton = By.xpath("//*[@id='userPasswordFastBtn']");
    private static final By myAccount = By.xpath("//*[@class='wrap_lk ']/a[1]");
    private static final By popUpCloser = By.xpath("//*[@id='accountActivation']/div[1]");

    private static final By countryElement = By.xpath("//*[@class='c-registration__block c-registration__block--country']");
    private static final By regionElement = By.xpath("//*[@class='c-registration__block c-registration__block--region']");
    private static final By cityElement = By.xpath("//*[@class='c-registration__block c-registration__block--city']");


    private static String EMAIL;
    private static String PASSWORD;
    private static String NAME;
    private static String SURNAME;
    private static String COUNTRY;
    private static String REGION;
    private static String CITY;

    public HomePage() throws IOException {
        EMAIL = CreditsGenerator.generateEmail();
        PASSWORD = CreditsGenerator.generatePassword();
        NAME = FileReader.getValue("NAME");
        SURNAME = FileReader.getValue("SURNAME");
    }

    public void openRegistrationForm() {
        clickElement(registrationButton);
    }

    public void fillFormInputs(){
        clickElement(regionSelector);
        clickElement(regionSelectorItem);
        clickElement(citySelector);
        clickElement(citySelectorItem);

        COUNTRY = $(countryElement).getText();
        REGION = $(regionElement).getText();
        CITY = $(cityElement).getText();

        $(emailInput).sendKeys(EMAIL);
        $(nameInput).sendKeys(NAME);
        $(surnameInput).sendKeys(SURNAME);
        $(passwordInput).sendKeys(PASSWORD);
        $(repeatPasswordInput).sendKeys(PASSWORD);
    }



    public void registration(){
        clickElement(formRegistrationButton);
    }

    public void waitCaptcha() {
       while(true){
            try{
                if($(registrationDialog).isDisplayed()){
                    Selenide.sleep(1000);
                    return;
                }
            }catch(ElementNotFound ex){
                Selenide.sleep(1000);
            }
        }
    }

    public String getID(){
        return $(inputField).getValue();
    }

    public String getPasswordFieldValue(){
        return $(passwordField).getValue();
    }

    public void clickLogIn(){
        clickElement(logInButton);
        clickElement(myAccount);
    }

    public void closePopUp(){
        clickElement(popUpCloser);
    }

    public String getEMAIL(){
        return EMAIL;
    }

    public String getPASSWORD(){
        return PASSWORD;
    }

    public String getNAME(){
        return NAME;
    }

    public String getSURNAME(){
        return SURNAME;
    }

    public String getCOUNTRY(){
        return COUNTRY;
    }

    public String getREGION(){
        return REGION;
    }

    public String getCITY(){
        return CITY;
    }

}
