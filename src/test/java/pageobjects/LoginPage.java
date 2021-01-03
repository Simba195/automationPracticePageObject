package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    @FindBy(id = "email_create")
    WebElement emailForm;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "passwd")
    WebElement userPass;

    @FindBy(id = "SubmitLogin")
    WebElement sumbitButton;

    @FindBy(css = ".alert >ol")
    WebElement alert;

    @FindBy(id = "create_account_error")
    WebElement emailBoxError;


    public void goToRegisterForm(String email) {
        emailForm.sendKeys(email);
        emailForm.sendKeys(Keys.ENTER);
    }

    public void loginUser(String email, String password) {
        userEmail.sendKeys(email);
        userPass.sendKeys(password);
        sumbitButton.click();
    }

    public String getErrorMessage() {
        return alert.getText();
    }

    public String getEmailBoxError() {
        wait.until(ExpectedConditions.visibilityOfAllElements(emailBoxError));
        return emailBoxError.getText();
    }
}