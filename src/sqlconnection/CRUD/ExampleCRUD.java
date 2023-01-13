
package sqlconnection.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ExampleCRUD {
     public static void main(String[] args) throws SQLException {

    String url ="jdbc:sqlserver://localhost:1433;databaseName=StudentJava;user=sa;password=aayaan;encrypt=true;trustServerCertificate=true"; //update connection string
    
    String user = "sa";//add your db user id here
    String password = "aayaan";//add your db password here
    
    Connection conn = DriverManager.getConnection(url, user, password);
    System.out.println("Successfully connected");
    
    //insert employee record into database
    Statement stmt = conn.createStatement();
    int rows = stmt.executeUpdate("insert into employee(age,name) values(15,'Sita')");
    System.out.println("Rows inserted = "+ rows);
    
    //update employee record
  rows= stmt.executeUpdate("Update employee set age=31 where name='James'");
  System.out.println("Rows updated = "+ rows);
//    
    //read employee records
    ResultSet rs = stmt.executeQuery("Select * from employee");
    while(rs.next()){
      System.out.println("Emp Id : " + rs.getInt("id") + ", Name : " + rs.getString("name") + ", Age : " + rs.getInt("age"));
    }
    
    //delete employee record
  rows = stmt.executeUpdate("delete from employee where name = 'James'");
  System.out.println("Rows deleted = "+ rows);
  }
  


    
}
