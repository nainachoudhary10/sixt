package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@title='Round Trip']")
    public WebElement roundTripButton;

    @FindBy(id = "BE_flight_origin_city")
    public WebElement searchOriginCity;

    @FindBy(xpath = "//li[@class='active ac_over']")
    public WebElement selectOriginCity;

    @FindBy(id = "BE_flight_arrival_city")
    public WebElement searchDestinationCity;

    @FindBy(xpath = "//li[@class='active ac_over']")
    public WebElement selectDestinationCity;

    @FindBy(id = "BE_flight_origin_date")
    public WebElement clickDatePicker;

    @FindBy(xpath = "//tbody[@class='BE_flight_origin_date']//td[@title='Tuesday, 28 September 2021']")
    public WebElement selectStartDate;

    @FindBy(id = "BE_flight_ret_cal")
    public WebElement clickReturnDatePicker;

    @FindBy(xpath = "//tbody[@class='BE_flight_arrival_date']//td[@title='Thursday, 30 September 2021']")
    public WebElement selectReturnDate;

    @FindBy(id = "BE_flight_flsearch_btn")
    public WebElement clickSearchFlight;

    public HomePage () {
        PageFactory.initElements (driver, this);
    }

    public void clickRoundTripButton () {
        roundTripButton.click ();
    }

    public void selectSourceOfTravel (String source) {
        searchOriginCity.click ();
        searchOriginCity.sendKeys (source);
        selectOriginCity.click ();
    }

    public void selectDestinationOfTravel (String destination) {
        searchDestinationCity.click ();
        searchDestinationCity.sendKeys (destination);
        selectDestinationCity.click ();
    }

    public void selectDepartureDate () {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until (ExpectedConditions.visibilityOf (clickDatePicker));
        clickDatePicker.click ();
        wait.until (ExpectedConditions.visibilityOf (selectStartDate));
        selectStartDate.click ();
    }

    public void selectReturnDate () {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until (ExpectedConditions.visibilityOf (clickReturnDatePicker));
        clickReturnDatePicker.click ();
        wait.until (ExpectedConditions.visibilityOf (selectReturnDate));
        selectReturnDate.click ();
    }

    public SearchFlightPage clickOnSearchFlightsButton () {
        WebDriverWait wait = new WebDriverWait (driver, 20);
        wait.until (ExpectedConditions.visibilityOf (clickSearchFlight));

        clickSearchFlight.click ();
        return new SearchFlightPage ();
    }

}
