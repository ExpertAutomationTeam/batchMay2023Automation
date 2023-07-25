package pages;

import com.may23.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BaseTest {
    public UserPage(WebDriver ldriver) {
        driver= ldriver;
        PageFactory.initElements(ldriver, this);
    }
}
