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
    Select days;

    @FindBy(id = "months")
    Select months;

    @FindBy(id = "years")
    Select years;

    @FindBy(id = "address1")
    WebElement address1;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "id_state")
    Select state;

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
        days.selectByValue("20");
        months.selectByValue(" " + user.monthOfBirth);
        years.selectByValue(" " + user.yearOfBirth);
        address1.sendKeys(user.address1);
        city.sendKeys(user.city);
        postcode.sendKeys(" " + user.zipCode);
        state.selectByValue("1");
        phone_mobile.sendKeys(" " + user.mobile);
        submitButton.click();


    }

}