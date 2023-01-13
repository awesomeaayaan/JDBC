
package sqlconnection;

import java.sql.*;
import java.util.Scanner;

public class Sqlconnection {
    public static void main(String[] args) {
        
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your Name:");
//        String Name= scanner.nextLine();
//        System.out.println("Enter your District:");
//        String District = scanner.nextLine();
//        System.out.println("Enter your age:");
//        int Age = scanner.nextInt();
        String url = "jdbc:sqlserver://localhost:1433;databaseName=StudentJava;user=sa;password=aayaan;encrypt=true;trustServerCertificate=true";
        String username = "sa";
        String password = "aayaan";
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        Connection connection = DriverManager.getConnection(url,username,password);
        
        Statement statement = connection.createStatement();
//        //insert into the database
         int rows = statement.executeUpdate("insert into student(Name,District,Age) values('Rabi','bhaktapur',22)");
    System.out.println("Rows inserted = "+ rows);
    
    
     //update employee record
  rows= statement.executeUpdate("Update student set Age=24 where name='"
          + "hari'");
  System.out.println("Rows updated = "+ rows);
        //delete student record
         rows = statement.executeUpdate("delete from student where name = 'Gita'");
  System.out.println("Rows deleted = "+ rows);
        //read student record
        ResultSet resultSet = statement.executeQuery("select*from student where district='ktm'");
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) +" "+resultSet.getString(2)+" "+resultSet.getString(3) +" "+resultSet.getInt(4));
        }
        connection.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
