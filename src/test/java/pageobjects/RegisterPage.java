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

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "phone_mobile")
    WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    WebElement submitButton;


    public void registerUser(RandomUser user) {
        customerFirstName.sendKeys(user.firstName);
        customerLastName.sendKeys(user.lastName);
        passwd.sendKeys((user.email));
        Select days = new Select(this.days);
        days.selectByValue("" + user.dayOfBirth + "");
        Select months = new Select(this.months);
        months.selectByValue("" + user.monthOfBirth+ "");
        Select years = new Select(this.years);
        years.selectByValue("" + user.yearOfBirth + "");
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys("" + user.zipCode);
        Select state = new Select(this.state);
        state.selectByVisibleText(user.state);
        phone_mobile.sendKeys(" " + user.mobile);
        submitButton.click();


    }

}