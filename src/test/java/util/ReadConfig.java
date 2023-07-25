package util;

import com.may23.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig extends BaseTest {

    FileInputStream fis;
    Properties properties = new Properties();

    public ReadConfig() {

        try {
            fis = new FileInputStream("src/test/resources/properties/config.properties");
            properties.load(fis);
        } catch (Exception e){
            Log.error("exception occured");
            Log.error(e.getMessage());
        }
    }


    public String getTestSite(){
       String testsite=properties.getProperty("testsite");
       return testsite ;
    }

    public String getFname(){
        String firstname=properties.getProperty("firstname");
        return firstname ;
    }

    public String getLname(){
        String lastName=properties.getProperty("lastName");
        return lastName ;
    }

    public String getEmailorPhone(){
        String emailorPhone=properties.getProperty("emailorPhone");
        return emailorPhone ;
    }

    public String getUname(){
        String uname=properties.getProperty("uname");
        return uname ;
    }

    public String getPass(){
        String passowrd=properties.getProperty("passowrd");
        return passowrd ;
    }

    public String getuPass(){
        String upass=properties.getProperty("upass");
        return upass ;
    }


}
