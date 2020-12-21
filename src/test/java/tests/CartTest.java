package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.ProductsPage;
import utils.Navigation;

public class CartTest extends BaseTest {


    @Test
    void shouldBeAbleToAddProductToTheCart() {

        ProductsPage productsPage = nav.goToProductCategoryPage(0);
        productsPage.addRandomProductToCart();
        Assertions.assertEquals(1, productsPage.getCartSize());

    }

    @Test
    void shouldBeAbleToAddMultipleProductsToTheCart() {

        ProductsPage productsPage = nav.goToProductCategoryPage(1);
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        Assertions.assertEquals(2, productsPage.getCartSize());
    }


}
