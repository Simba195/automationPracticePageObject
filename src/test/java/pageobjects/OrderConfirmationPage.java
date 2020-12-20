package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage{

    @FindBy(css = ".cheque-indent")
    WebElement orderComplete;


    public OrderConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);


    }

    public String getOrderConfirmation() {
        return orderComplete.getText();

    }
}
