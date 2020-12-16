package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {



    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    public void openPage () {
        driver.get(BASE_URL + "index.php");
    }
}
