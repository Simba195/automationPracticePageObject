package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }
    @FindBy (id = "email_create")
    WebElement emailForm;

    public void goToRegisterForm (String email) {
        emailForm.sendKeys(email);
        emailForm.sendKeys(Keys.ENTER);
    }
}
