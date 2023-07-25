package pages;

import com.may23.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BaseTest {

    public CreateAccountPage(WebDriver ldriver){
        driver= ldriver;
        PageFactory.initElements(ldriver, this);
    }



    @FindBy(name="firstname")
    WebElement fname;

    @FindBy(name="lastname")
    WebElement lname;

    @FindBy(name="reg_email__")
    WebElement emailOrPhone;

    @FindBy(name="reg_passwd__")
    WebElement newPassword;

    @FindBy(name="websubmit")
    WebElement SignUp;

    @FindBy(id="birthday_month")
    WebElement selectMonth;


    public void createAccount(String f_name, String l_name, String emailorphone, String pass){
        fname.sendKeys(f_name);
        lname.sendKeys(l_name);
        emailOrPhone.sendKeys(emailorphone);
        newPassword.sendKeys(pass);
        //select DOB
        //select Gender
        //SignUp.click();

    }



}
