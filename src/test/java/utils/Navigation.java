package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.ProductsPage;

public class Navigation {

    WebDriver driver;
    WebDriverWait wait;

    public Navigation(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public ProductsPage goToProductCategoryPage(int i) {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToProductCategoryByIndex(i);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        return productsPage;

    }

    public LoginPage goToLoginPage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.openPage();
        homePage.goToLoginPageBySignInButton();
        LoginPage loginpage = new LoginPage(driver, wait);
        return loginpage;

    }


}
