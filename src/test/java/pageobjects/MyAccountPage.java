package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }
    @FindBy(css = ".page-heading")
    WebElement myAccount;

    public String checkIfMyAccountVisible() {
        return myAccount.getText();
    }
}
