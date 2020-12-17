package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;
import pageobjects.RegisterPage;
import utils.RandomUser;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterNewUserWhenAllMandatoryDataIsProvided() {
        RandomUser user = new RandomUser();
        System.out.println(user);

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.goToRegisterForm(user.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(user);

        MyAccountPage accountPage = new MyAccountPage(driver, wait);
        Assertions.assertEquals("My Account", accountPage.checkIfMyAccountVisible());

    }
}
