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

import java.util.List;

public class FlightConfirmationPage extends BaseTest{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    

 
    
    By flightConfirmationHeader = By.xpath("//font[contains(text(), 'Confirmation')]");
    By prices = By.xpath("//font[contains(text(), 'USD')]");
    By signOffLink = By.linkText("SIGN-OFF");

    public FlightConfirmationPage(){
    	this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
    }

    public String getPrice(){
       this.wait.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(this.flightConfirmationHeader)));
       System.out.println(DriverFactory.getInstance().getDriver().findElement(this.flightConfirmationHeader).getText());
       System.out.println(DriverFactory.getInstance().getDriver().findElements(this.prices).get(1).getText());
       String price = getText_custom(DriverFactory.getInstance().getDriver().findElements(this.prices).get(1),"prices");
       
       click_custom(DriverFactory.getInstance().getDriver().findElement(this.signOffLink), "signOffLink");
       return price;
    }

}
