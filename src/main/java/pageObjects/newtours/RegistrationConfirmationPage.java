package pageObjects.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseTest;
import testBase.DriverFactory;

public class RegistrationConfirmationPage extends BaseTest{

    
    private WebDriverWait wait;


    
    By signinLink = By.partialLinkText("sign-in");
    By flightsLink = By.linkText("Flights");

    public RegistrationConfirmationPage(){
        
        this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
        
    }

    public void goToFlightDetailsPage(){
        this.wait.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(this.signinLink)));
        
        click_custom(DriverFactory.getInstance().getDriver().findElement(this.flightsLink), "Flightlink");
    }

}
