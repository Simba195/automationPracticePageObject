package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class OrderTest extends BaseTest {

    @Test
    void shouldBeAbleToCompleteAnOrderWithOneProductWhileLoggedIn() throws InterruptedException {

        nav.goToMyAccountPage();

        HomePage homePage = nav.goToHomePage();
        homePage.addRandomProductFromHomepage();

        CartPage cartPage = nav.goToCartPage();
        cartPage.placeAnOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, wait);
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfirmation());

    }

    @Test
    void shouldBeAbleToCompleteAnOrderWithMultipleProductsWhileLoggedIn() throws InterruptedException {

        nav.goToMyAccountPage();

        HomePage homePage = nav.goToHomePage();
        homePage.addRandomProductFromHomepage();
        homePage.addRandomProductFromHomepage();
        homePage.addRandomProductFromHomepage();

        CartPage cartPage = nav.goToCartPage();
        cartPage.placeAnOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver, wait);
        Assertions.assertEquals("Your order on My Store is complete.", orderConfirmationPage.getOrderConfirmation());
    }
}



