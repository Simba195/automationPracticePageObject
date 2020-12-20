package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

public class NavigationTest extends BaseTest {

    @Test
    void subCategoriesShouldBeVisibleAfterMovingMouseOnCategoryWomen() {

        HomePage homepage = nav.goToHomePage();
        homepage.moveToWomenCategory();

        Assertions.assertEquals("TOPS", homepage.getSubCategoryTopsName());

    }

    @Test
    void subCategoriesShouldBeVisibleAfterMovingMouseOnCategoryDresses() {

        HomePage homepage = nav.goToHomePage();
        homepage.moveToDressesCategory();

        Assertions.assertEquals("Casual Dresses", homepage.getSubCategoryCasualDressessName());
    }
}

