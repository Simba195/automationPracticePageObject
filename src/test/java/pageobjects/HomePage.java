package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    @FindBy(css = ".homefeatured .product-image-container")
    List<WebElement> products;

    @FindBy(css = ".homefeatured  .ajax_add_to_cart_button")
    List<WebElement> addToCartButtons;

    @FindBy(css = ".continue")
    WebElement continueButton;

    @FindBy(xpath ="//a[@title='Proceed to checkout']")
    WebElement checkoutButon;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    public void openPage() {
        driver.get(BASE_URL + "index.php");
    }

    public void addProductFromHomepage(int productIndex) {
        Actions builder = new Actions(driver);
        builder.moveToElement(products.get(productIndex)).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(productIndex)));
        addToCartButtons.get(productIndex).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public void addRandomProductFromHomepage() {
        Random random = new Random();
        int productIndex = random.nextInt(products.size());
        addProductFromHomepage(productIndex);

    }

}
