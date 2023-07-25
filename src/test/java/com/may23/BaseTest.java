package com.may23;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import util.Log;
import util.ReadConfig;

import java.time.Duration;


public class BaseTest {
    public static WebDriver driver;
    public static ReadConfig readConfig = new ReadConfig();


    @Parameters("browser")
    @BeforeClass
    public  void setup(@Optional("chrome") String browser){
            if (browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
                Log.info("chrome launched");
            } else if (browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
                System.out.println("firefox launched");
            } else {
                driver = new EdgeDriver();
                System.out.println("MS Edge launched");
            }
        driver.get(readConfig.getTestSite());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
       Log.info(driver.getTitle());

        }



    @AfterClass
    public  void tearDown(){
        if (driver!=null)
        driver.quit();
       Log.info("browser quits");
    }




}
