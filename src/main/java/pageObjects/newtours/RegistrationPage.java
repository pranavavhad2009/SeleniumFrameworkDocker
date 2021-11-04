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

public class RegistrationPage extends BaseTest{

    
    private WebDriverWait wait;
    
    By firstNameTxt = By.name("firstName");
    By lastNameTxt = By.name("lastName");
    By usernameTxt = By.name("email");
    By passwordTxt = By.name("password");
    By confirmPasswordTxt = By.name("confirmPassword");
    By submitBtn = By.name("register");
    
    public RegistrationPage(){
    	 this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
    }

    public void goTo(){
    	DriverFactory.getInstance().getDriver().get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.wait.until(ExpectedConditions.visibilityOf(DriverFactory.getInstance().getDriver().findElement(this.firstNameTxt)));
    }

    public void enterUserDetails(String firstName, String lastName){
    	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(this.firstNameTxt), "FirstNameField", firstName);
    	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(this.lastNameTxt), "LastNameField", firstName);
		/*
		 * this.firstNameTxt.sendKeys(firstName); this.lastNameTxt.sendKeys(lastName);
		 */
    }

    public void enterUserCredentials(String username, String password){
    	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(this.usernameTxt), "UserNameField", username);
    	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(this.passwordTxt), "PasswordField", password);
    	sendKeys_custom(DriverFactory.getInstance().getDriver().findElement(this.confirmPasswordTxt), "ConfirmPasswordField", password);
    	
		/*
		 * this.usernameTxt.sendKeys(username); this.passwordTxt.sendKeys(password);
		 * this.confirmPasswordTxt.sendKeys(password);
		 */
    }

    public void submit(){
        //this.submitBtn.click();
        
        click_custom(DriverFactory.getInstance().getDriver().findElement(this.submitBtn), "SubmitButton");
    }

}
