package pageObjects.newtours;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseTest;
import testBase.DriverFactory;

public class FlightDetailsPage extends BaseTest{

    private WebDriver driver;
    private WebDriverWait wait;
    
    By passengers = By.name("passCount");
    By submitBtn = By.name("findFlights");



    public FlightDetailsPage(){
    	this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
    }

    public void selectPassengers(String noOfPassengers){
        this.wait.until(ExpectedConditions.elementToBeClickable(passengers));
        Select select = new Select(DriverFactory.getInstance().getDriver().findElement(passengers));
        select.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage(){
       
        click_custom(DriverFactory.getInstance().getDriver().findElement(this.submitBtn), "submitBtn");
    }


}
