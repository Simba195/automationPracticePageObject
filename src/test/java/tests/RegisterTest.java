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
        Assertions.assertEquals("MY ACCOUNT", accountPage.checkIfMyAccountVisible());

    }

    @Test
    void shouldNotRegisterNewUserWhenFirstNameIsNotProvided() {
        RandomUser user = new RandomUser();
        System.out.println(user);

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.goToRegisterForm(user.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUserWithoutCustomerFirstName(user);

        Assertions.assertEquals("firstname is required.", registerPage.getErrorMessage());

    }

    @Test
    void shouldNotRegisterNewUserWhenLastNameIsNotProvided() {
        RandomUser user = new RandomUser();
        System.out.println(user);

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.goToRegisterForm(user.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUserWithoutCustomerLastName(user);

        Assertions.assertEquals("lastname is required.", registerPage.getErrorMessage());

    }

    @Test
    void shouldInformThatEmailIsAlreadyRegisteredIfEnteredEmailHasBeenUsedBefore() {

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.goToRegisterForm("TestPractice@gmail.com");

        Assertions.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", loginPage.getEmailBoxError());


    }
}
