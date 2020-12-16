package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(css = ".sf-menu>li>a")
    List<WebElement> productCategories;

    @FindBy(css = ".shopping_cart .ajax_cart_quantity")
    WebElement cartQuantity;

    @FindBy(css = ".header_user_info")
    WebElement signInButton;

    WebDriver driver;
    WebDriverWait wait;

    static final String BASE_URL = "http://automationpractice.com/";

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);

    }

    public void goToProductCategoryByIndex(int productCategoryIndex) {
        productCategories.get(productCategoryIndex).click();

    }

    public int getCartSize() {
        return Integer.parseInt(cartQuantity.getText());

    }

    public void goToLoginPageBySignInButton() {
        signInButton.click();
    }


}
