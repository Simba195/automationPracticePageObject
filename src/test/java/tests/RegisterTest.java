package tests;

import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterNewUserWhenAllMandatoryDataIsProvided() {
        RandomUser user = new RandomUser();
        LoginPage loginPage = nav.goToLoginPage();
        loginPage.goToRegisterForm(user.email);
        RegisterPage registerPage = new RegisterPage(driver, wait);
        RegisterPage.registerUser(user);

    }
}
