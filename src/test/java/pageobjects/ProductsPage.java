package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {

    @FindBy(css = ".product_list .product-container")
    List<WebElement> productsContainers;

    @FindBy(css = ".ajax_add_to_cart_button")
    List<WebElement> addToCartButtons;

    @FindBy(css = ".continue")
    WebElement continueShoppingButton;

       public ProductsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void moveMouseToProductContainer(int productIndex) {
        Actions builder = new Actions(driver);
        builder.moveToElement(productsContainers.get(productIndex)).build().perform();
    }

    public void addProductToTheCart(int productIndex) {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(productIndex)));
        addToCartButtons.get(productIndex).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();

    }


    public void addRandomProductToCart() {
        Random random = new Random();
        int productIndex = random.nextInt(productsContainers.size());
        moveMouseToProductContainer(productIndex);
        addProductToTheCart(productIndex);
    }


}
