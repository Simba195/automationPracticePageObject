package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomUser;

public class RegisterPage extends BasePage {


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "passwd")
    WebElement passwd;


    @FindBy(id = "days")
    WebElement days;
    Select day = new Select(days);

    @FindBy(id = "months")
    WebElement months;
    Select month = new Select(months);

    @FindBy(id = "years")
    WebElement years;
    Select year = new Select(years);

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement states;
    Select state = new Select(states);

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    WebElement submitButton;

    @FindBy(css = ".alert >ol")
    WebElement failAlert;


    public void registerUser(RandomUser user) {
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        passwd.sendKeys((user.email));
        day.selectByValue("" + user.dayOfBirth + "");
        month.selectByValue("" + user.monthOfBirth + "");
        year.selectByValue("" + user.yearOfBirth + "");
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys("" + user.zipCode);
        state.selectByVisibleText(user.state);
        phone_mobile.sendKeys(" " + user.mobile);
        submitButton.click();


    }

    public void registerUserWithoutCustomerFirstName(RandomUser user) {
        customerLastName.sendKeys(user.lastName);
        passwd.sendKeys((user.email));
        day.selectByValue("" + user.dayOfBirth + "");
        month.selectByValue("" + user.monthOfBirth + "");
        year.selectByValue("" + user.yearOfBirth + "");
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys("" + user.zipCode);
        state.selectByVisibleText(user.state);
        phone_mobile.sendKeys(" " + user.mobile);
        submitButton.click();

    }

    public String getErrorMessage() {
        return failAlert.getText();
    }

    public void registerUserWithoutCustomerLastName(RandomUser user) {
        customerFirstName.sendKeys(user.firstName);
        passwd.sendKeys((user.email));
        day.selectByValue("" + user.dayOfBirth + "");
        month.selectByValue("" + user.monthOfBirth + "");
        year.selectByValue("" + user.yearOfBirth + "");
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys("" + user.zipCode);
        state.selectByVisibleText(user.state);
        phone_mobile.sendKeys(" " + user.mobile);
        submitButton.click();
    }
}