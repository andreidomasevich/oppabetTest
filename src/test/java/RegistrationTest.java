import Pages.AccountPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrationTest extends BaseTest{

    HomePage homePage;
    AccountPage accountPage;

    RegistrationTest() throws IOException {
        homePage = new HomePage();
        accountPage = new AccountPage();
    }

    @BeforeTest
    public void setUp() {
        openHomePage();

    }

    @Test(priority = 1)
    public void checkRegistrationForm() {
        homePage.openRegistrationForm();
        homePage.fillFormInputs();
        homePage.registration();
        homePage.waitCaptcha();

    }

    @Test(priority = 2)
    public void checkDialogInputs() {
        Assert.assertFalse(homePage.getID().isBlank());
        Assert.assertEquals(homePage.getPasswordFieldValue(), homePage.getPASSWORD());
    }

    @Test(priority = 3)
    public void checkAccountInformation() {
        homePage.clickLogIn();
        homePage.closePopUp();

        Assert.assertEquals(accountPage.getEmail(), homePage.getEMAIL());
        Assert.assertEquals(accountPage.getSurname(), homePage.getSURNAME());
        Assert.assertEquals(accountPage.getName(), homePage.getNAME());
        Assert.assertEquals(accountPage.getCountry(), homePage.getCOUNTRY());
        Assert.assertEquals(accountPage.getCity(), homePage.getCITY());
        Assert.assertEquals(accountPage.getRegion(), homePage.getREGION());

    }
}
