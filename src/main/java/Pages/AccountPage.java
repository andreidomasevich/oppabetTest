package Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage{
    private static final By email = By.xpath("//*[contains(text(),'E-mail')]/following::div[1]/div[1]/span");
    private static final By name = By.xpath("//*[contains(text(),'First name')]/following::div[1]/div[1]/span");
    private static final By surname = By.xpath("//*[contains(text(),'Surname')]/following::div[1]/div[1]/span");
    private static final By country = By.xpath("//*[contains(text(),'Country')]/following::div[1]/div[1]/span");
    private static final By region = By.xpath("//*[contains(text(),'Region')]/following::div[1]/div[1]/span");
    private static final By city = By.xpath("//*[contains(text(),'City')]/following::div[1]/div[1]/span");

    public String getEmail(){
        return $(email).getText();
    }

    public String getSurname(){
        return $(surname).getText();
    }

    public String getName(){
        return $(name).getText();
    }

    public String getRegion(){
        return $(region).getText();
    }

    public String getCountry(){
        return $(country).getText();
    }

    public String getCity(){
        return $(city).getText();
    }

}
