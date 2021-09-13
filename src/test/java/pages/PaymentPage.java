package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//h2[@class='grad']")
    WebElement titleOfPage;

    public PaymentPage () {
        PageFactory.initElements (driver, this);
    }

    public String getPaymentPageTitle () {
        return titleOfPage.getText ();
    }
}
