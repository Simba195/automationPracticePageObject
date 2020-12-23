package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    @FindBy(id = "search_query_top")
    WebElement searchBox;

    @FindBy(css = ".sf-menu>li>a")
    List<WebElement> productCategories;

    @FindBy(css = ".shopping_cart .ajax_cart_quantity")
    WebElement cartQuantity;

    @FindBy(css = ".login")
    WebElement signInButton;

    @FindBy(css = ".logout")
    WebElement signOutButton;

    @FindBy(xpath = "//a[@title=\"Women\"]")
    WebElement womenCategory;

    @FindBy(xpath = "//a[@title=\"Tops\"]")
    WebElement topsCategory;

    @FindBy(xpath = "(//a[@title = \"Dresses\"])[2]")
    WebElement dressesCategory;

    @FindBy(xpath = "(//a[@title=\"Casual Dresses\"])[2]")
    WebElement casualDressesCategory;

    @FindBy(css = ".shopping_cart > a")
    WebElement cart;


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


    public void signOut() {
        signOutButton.click();

    }

    public String getSignInButton() {
        return signInButton.getText();

    }

    public void moveToWomenCategory() {
        Actions builder = new Actions(driver);
        builder.moveToElement(womenCategory).build().perform();
        wait.until(ExpectedConditions.visibilityOf(topsCategory));

    }

    public String getSubCategoryTopsName() {
        return topsCategory.getText();
    }

    public void moveToDressesCategory() {
        Actions builder = new Actions(driver);
        builder.moveToElement(dressesCategory).build().perform();
        wait.until(ExpectedConditions.visibilityOf(casualDressesCategory));
    }

    public String getSubCategoryCasualDressessName() {
        return casualDressesCategory.getText();

    }

    public void goToCart() {
        cart.click();

    }
}