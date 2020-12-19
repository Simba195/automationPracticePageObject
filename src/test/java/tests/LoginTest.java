package tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class LoginTest extends BaseTest {

    @Test
    void shouldBeAbleToLoginWitchCorrectEmailAndPassword() {

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.loginUser();

        MyAccountPage myAccount = new MyAccountPage(driver, wait);
        Assertions.assertEquals("MY ACCOUNT", myAccount.checkIfMyAccountVisible());

    }

    @Test
    void shouldNotBeAbleToLoginWithWrongPassword() {

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.loginUserWithWrongPassword();
        Assertions.assertEquals("Authentication failed.", loginPage.getErrorMessage());

    }

    @Test
    void shouldNotBeAbleToLoginWithWrongEmail() {

        LoginPage loginPage = nav.goToLoginPage();
        loginPage.loginUserWithWrongemail();
        Assertions.assertEquals("Authentication failed.", loginPage.getErrorMessage());

    }

    @Test
    void shouldBeAbleToLogOut() throws InterruptedException {
        MyAccountPage myaccount = nav.goToMyAccountPage();
        myaccount.signOut();

        LoginPage loginPage = new LoginPage(driver, wait);
        Assertions.assertEquals("Sign in", loginPage.getSignInButton());
        Thread.sleep(3000);


    }
}
