package testcases;

import com.may23.BaseTest;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;

public class CreateAccountTest extends BaseTest {

    @Test
    public void createAccTest(){
        LoginPage lp= new LoginPage(driver);
        CreateAccountPage cap = lp.gotoCreateNewAcccPage();
        cap.createAccount(readConfig.getFname(), readConfig.getLname(), readConfig.getEmailorPhone(), readConfig.getPass());

    }


}
