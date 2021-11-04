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

public class FindFlightPage extends BaseTest{

    
    private WebDriverWait wait;



    
    By firstSubmitBtn = By.name("reserveFlights");
    By secondSubmitBtn = By.name("buyFlights");
    
    public FindFlightPage(){
    	this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
    }

    public void submitFindFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(DriverFactory.getInstance().getDriver().findElement(this.firstSubmitBtn)));
        click_custom(DriverFactory.getInstance().getDriver().findElement(this.firstSubmitBtn), "firstSubmitBtn");
        
    }

    public void goToFlightConfirmationPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmitBtn));
        click_custom(DriverFactory.getInstance().getDriver().findElement(this.secondSubmitBtn), "secondSubmitBtn");

    }

}
