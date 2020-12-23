package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;
import utils.RandomUser;



public class OrderTest extends BaseTest {

    @Test
    void shouldBeAbleToCompleteAnOrderWithOneProductWhileLoggedIn() {

        HomePage homePage = nav.goToLoggedHomepage();
        homePage.addRandomProductFromHomepage();

        CartPage cartPage = nav.goToCartPage();
        cartPage.placeAnOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, wait);
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfirmation());

    }

    @Test
    void shouldBeAbleToCompleteAnOrderWithMultipleProductsWhileLoggedIn() {

        HomePage homePage = nav.goToLoggedHomepage();
        homePage.addRandomProductFromHomepage();
        homePage.addRandomProductFromHomepage();
        homePage.addRandomProductFromHomepage();

        CartPage cartPage = nav.goToCartPage();
        cartPage.placeAnOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, wait);
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfirmation());
    }

    @Test
    void shouldBeAbleToCompleteAnOrderByRegisteringANewAccountThroughTheProcessOfPlacingAnOrder() {
        RandomUser user  = new RandomUser();

        CartPage cartpage = nav.goToCartPageWithOneProduct();
        cartpage.proceedToCheckout();

        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.goToRegisterForm(user.email);

        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.registerUser(user);

        cartpage.continuePlacingAnOrderFromAddressPage();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, wait);
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfirmation());
    }
}



