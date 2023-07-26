package util;

import com.may23.BaseTest;
import org.testng.annotations.Test;

import java.sql.*;

public class DBConnection extends BaseTest {


    @Test
    public void getConnection() throws SQLException {

        Connection connection =DriverManager.getConnection(readConfig.getdbURL(),"root","root");
       Statement statement = connection.createStatement();
       String query="select * from Customers";
       ResultSet resultSet =statement.executeQuery(query);

       while (resultSet.next()){
          String customerName= resultSet.getString("CustomerName");

          String contactName=resultSet.getString(3);
           Log.info("CustomerName :"+customerName + " - ContactName :"+ contactName );

       }




    }


}
