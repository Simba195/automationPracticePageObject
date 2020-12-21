package tests;

import jdk.jshell.spi.ExecutionControl;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;

public class SearchTest extends BaseTest {

    @Test
    void shouldReturnCorrectProductListWhenPositiveSearchPhraseIsUsed() {

        HomePage homePage = nav.goToHomePage();
        homePage.searchForProduct("dress");

        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        Assertions.assertTrue(searchResultPage.isProductWithNameVisible("dress"));
        Assertions.assertEquals("7 results have been found.", searchResultPage.getSearchSummary());
    }

    @Test
    void shouldProvideInformationAboutLackOfKeywordWhenNoSearchPhraseIsUsed() {

        HomePage homePage = nav.goToHomePage();
        homePage.searchForProduct("");

        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        Assertions.assertEquals("Please enter a search keyword", searchResultPage.getAlert());
        Assertions.assertEquals("0 results have been found.", searchResultPage.getSearchSummary());

    }

    @Test
    void shouldReturnInformationAboutNoProductsWhenSearchPhraseUsedCanNotBeFound() {
        HomePage homePage = nav.goToHomePage();
        homePage.searchForProduct("asd");

        SearchResultPage searchResultPage = new SearchResultPage(driver, wait);
        Assertions.assertEquals("No results were found for your search \"asd\"", searchResultPage.getAlert());
        Assertions.assertEquals("0 results have been found.", searchResultPage.getSearchSummary());
    }


}
