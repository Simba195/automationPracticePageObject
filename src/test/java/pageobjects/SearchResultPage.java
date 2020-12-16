package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".product_list .product-container")
    List<WebElement> productsNames;

    @FindBy(css = ".heading-counter")
    WebElement searchSummary;

    public SearchResultPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isProductWithNameVisible(String expectedProductName) {
        for (WebElement productName : productsNames) {
            if (productName.getText().toLowerCase().contains(expectedProductName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public String getSearchSummary() {
        return searchSummary.getText();
    }
}
