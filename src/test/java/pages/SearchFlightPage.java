package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlightPage extends BasePage {
    @FindBy(xpath = "//button[@autom='booknow']")
    public WebElement bookNowInSearchFlight;

    @FindBy(xpath = "//span[text()='Basic Fare']//ancestor::div[contains(@class,'fare-box')]//button")
    public WebElement clickBasicFare;

    public SearchFlightPage () {
        PageFactory.initElements (driver, this);
    }

    public void clickOnBookNowButton () {
        bookNowInSearchFlight.click ();
    }

    public ReviewYourBookingPage selectBasicFare () {
        try {
            Thread.sleep (1000);
        } catch (Exception exception) {
            System.out.println ("Not found after 1 Second");
        }
        clickBasicFare.click ();
        return new ReviewYourBookingPage ();
    }
}
