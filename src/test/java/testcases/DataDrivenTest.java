package testcases;

import com.may23.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import util.ExcelReader;
import util.Log;

import java.io.IOException;

public class DataDrivenTest extends BaseTest {

    @Test(dataProvider = "ddt")
    public void ddt(String username, String password) throws InterruptedException {
      //  Log.info(username +" "+password);
      LoginPage lp=new LoginPage(driver);
        lp.doLogin(username, password);
    }




    @DataProvider(name="ddt")
    public String[][] getddt() throws Exception {

        String path = "/Users/rihad/idea-project/batchMay2023Automation/src/test/resources/excel/loginDDT.xlsx";

        int rownum=ExcelReader.getRowCount(path,"Sheet1");
        int colcount=ExcelReader.getColCount(path,"Sheet1",1);
          String  loginadata[][] = new String[rownum][colcount];
        for (int i=1; i<=rownum;i++){
            for(int j=0; j< colcount; j++){
                loginadata [i-1][j] = ExcelReader.getCellData(path, "Sheet1", i,j);
            }
        }

        return loginadata;


    }

}

/*
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >

<suite name="Suite" parallel="tests">

    <test name="createAcc">
        <parameter name="browser" value="firefox"></parameter>
        <classes>
            <class name="testcases.CreateAccountTest"/>
        </classes>

    </test>


    <test name="doLogin">
        <parameter name="browser" value="chrome"></parameter>
        <classes>
            <class name="testcases.LoginTest"/>
        </classes>
    </test>

</suite>

 */