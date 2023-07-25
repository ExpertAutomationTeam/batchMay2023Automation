package pages;

import com.may23.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import util.Log;

public class LoginPage extends BaseTest {


    SoftAssert softassert = new SoftAssert();

    public LoginPage(WebDriver ldriver){
        driver= ldriver;
        PageFactory.initElements(ldriver, this);
    }


    @FindBy(id="email")
    WebElement email;

    @FindBy(id="pass")
    WebElement password;

    @FindBy(name="login")
    WebElement login;

    @FindBy(xpath="//*[text()='Create new account']")
    WebElement createNewAccount;

    @FindBy(xpath = "//*[text()='Forgot password?']")
    WebElement forgotPass;



    public CreateAccountPage gotoCreateNewAcccPage(){
        createNewAccount.click();
        return new CreateAccountPage(driver);
    }

    public UserPage doLogin(String useremail, String userpass) throws InterruptedException {
        email.sendKeys(useremail);
        Log.info("user enters email :" + useremail);
        password.sendKeys(userpass);
        Log.info("user enters password :" + userpass);
        driver.navigate().refresh();
        Thread.sleep(5000);
        softassert.assertEquals(driver.getTitle(),"Facebook - log in or sign up");
        Log.warn(" Soft assertion is complete");
        softassert.assertAll();

        //click
        Log.info(" assertion is complete");
        return new UserPage(driver);
    }



/*
log4j2

two main components:

Loggers : captures all the log records and pass them to appenders

Appenders : records the log event and append them into a destination file/location

log levels:

FATAL
ERROR
WARN
INFO
DEBUG
ALL

 */

}
