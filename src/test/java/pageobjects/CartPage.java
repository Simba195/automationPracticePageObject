package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(css = ".standard-checkout")
    WebElement proceedButton;

    @FindBy(xpath = "//button[@name=\"processAddress\"]")
    WebElement proceedButton2;

    @FindBy(css = ".checker")
    WebElement termsBox;

    @FindBy(xpath = "//button[@name=\"processCarrier\"]")
    WebElement proceedButton3;

    @FindBy(css = ".bankwire")
    WebElement bankPayment;

    @FindBy(xpath = "//p/button[@type = \"submit\"]")
    WebElement confirmOrderButton;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void placeAnOrder() {
        proceedButton.click();
        proceedButton2.click();
        termsBox.click();
        proceedButton3.click();
        bankPayment.click();
        confirmOrderButton.click();

    }
    public void proceedToCheckout() {
        proceedButton.click();
    }
    public void continuePlacingAnOrderFromAddressPage(){
        proceedButton2.click();
        termsBox.click();
        proceedButton3.click();
        bankPayment.click();
        confirmOrderButton.click();
    }
}
