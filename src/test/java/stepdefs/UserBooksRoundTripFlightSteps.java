package stepdefs;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.PaymentPage;
import pages.ReviewYourBookingPage;
import pages.SearchFlightPage;

public class UserBooksRoundTripFlightSteps {
    BasePage basePage;
    HomePage homePage;
    SearchFlightPage searchFlightPage;
    ReviewYourBookingPage reviewYourBookingPage;
    PaymentPage paymentPage;

    @Given("the user is in homepage")
    public void the_user_is_in_homepage () {
        basePage = new BasePage ();
        homePage = basePage.navigateToHome ();
    }

    @Given("user clicks on round trip radio button")
    public void user_clicks_on_round_trip_radio_button () {
        homePage.clickRoundTripButton ();
    }

    @Given("user selects the source as {string}")
    public void user_selects_the_source (String source) {
        homePage.selectSourceOfTravel (source);
    }

    @Given("user selects the destination as {string}")
    public void user_selects_the_destination (String destination) {
        homePage.selectDestinationOfTravel (destination);
    }

    @Given("user selects the departure date")
    public void user_selects_the_departure_date () {
        homePage.selectDepartureDate ();
    }

    @Given("user selects the return date")
    public void user_selects_the_return_date () {
        homePage.selectReturnDate ();
    }

    @Given("user searches for the flight")
    public void user_searches_for_the_flight () {
        searchFlightPage = homePage.clickOnSearchFlightsButton ();
    }

    @Given("user selects the flight")
    public void user_selects_the_flight () {
        searchFlightPage.clickOnBookNowButton ();
    }

    @Given("user selects the basic fare")
    public void user_selects_the_basic_fare () {
        reviewYourBookingPage = searchFlightPage.selectBasicFare ();
    }

    @Given("user enters the personal details")
    public void user_enters_the_personal_details (DataTable userDetails) {
        reviewYourBookingPage.userCommunicationInformation (userDetails.cell (1, 4), userDetails.cell (1, 5));
        reviewYourBookingPage.userPersonalInformation (userDetails.cell (1, 0),
                userDetails.cell (1, 1), userDetails.cell (1, 2),
                userDetails.cell (1, 3));
    }

    @When("user goes for the payment")
    public void user_goes_for_the_payment () {
        paymentPage = reviewYourBookingPage.clickOnProceedToPayment ();
    }

    @Then("the title of the page should be {string}")
    public void theTitleOfThePageShouldBe (String titleOfThePage) {
        Assert.assertEquals (paymentPage.getPaymentPageTitle (), titleOfThePage);
    }

    @After
    public void quitBrowser () {
        basePage.closeBrowser ();
    }
}
