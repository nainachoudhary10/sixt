package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewYourBookingPage extends BasePage {
    @FindBy(id = "additionalContactMobile")
    public WebElement enterMobileNumber;

    @FindBy(id = "additionalContactEmail")
    public WebElement enterEmail;

    @FindBy(id = "travellerf0")
    public WebElement enterFirstName;

    @FindBy(id = "travellerl0")
    public WebElement enterLastName;

    @FindBy(id = "Adult_1_dob")
    public WebElement dob;

    @FindBy(id = "title0")
    public WebElement selectSalutation;

    @FindBy(xpath = "//button[@analytics='Current Selection|Continue']")
    public WebElement bookNow;

    @FindBy(xpath = "//input[@value='Risk My Travel']")
    public WebElement riskMyTravel;

    @FindBy(id = "bookingCounter")
    public WebElement bookingCounter;

    public ReviewYourBookingPage () {
        PageFactory.initElements (driver, this);
    }

    public void userCommunicationInformation (String email, String mobileNumber) {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until (ExpectedConditions.visibilityOf (bookingCounter));

        BasePage.scrollDown ("1000");

        wait.until (ExpectedConditions.visibilityOf (enterEmail));
        enterEmail.sendKeys (email);
        wait.until (ExpectedConditions.visibilityOf (enterMobileNumber));
        enterMobileNumber.sendKeys (mobileNumber);
    }

    public void userPersonalInformation (String salutation, String firstName, String lastName, String dateOfBirth) {
        Select title = new Select (selectSalutation);
        title.selectByVisibleText (salutation);

        enterFirstName.sendKeys (firstName);
        enterLastName.sendKeys (lastName);
        dob.sendKeys (dateOfBirth);
    }

    public PaymentPage clickOnProceedToPayment () {
        BasePage.scrollDown ("2000");

        bookNow.click ();
        riskMyTravel.click ();
        return new PaymentPage ();
    }
}
