package testcases;

import com.may23.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.Log;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "logindata")
    public void loginTest(String uname, String password) throws InterruptedException {
       LoginPage lp=new LoginPage(driver);
       lp.doLogin(uname, password);

    }

    // data-driven test:

    // apache poi jar/ maven dependency
    // spreadsheet/source file
    // class file for reading data
    // @DataProvider annotation




    @DataProvider(name="logindata")
    public String[][] getData(){

       String loginData[][]= {
            {"abc@yahoo.com","pqr!234"},
            {"xyz@gmail.com","kjh5k454"},
            {"wxy@hotmail.com","ghkhgf!"}
        };
       return loginData;
    }


}
