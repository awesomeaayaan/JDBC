
package Aayaan.JDBC.RowSet.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class InsertExample {
    public static void main(String[] args) {
        // Get user input
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter your name: ");
    String name = scanner.nextLine();
     System.out.println("Enter your District");
     String district = scanner.nextLine();
    System.out.print("Enter your age: ");
    int age = scanner.nextInt();
    

    // JDBC code
    Connection connection = null;
    PreparedStatement statement = null;
    try {
      // Load the JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      // Open a connection
      connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=StudentJava;encrypt=true;trustServerCertificate=true", "sa", "aayaan");
       // Execute a query
      statement = connection.prepareStatement("INSERT INTO student (name, age,district) VALUES (?, ?,?)");
      statement.setString(1, name);
      statement.setInt(2, age);
      statement.setString(3,district);
      statement.executeUpdate();
      System.out.println("Data inserted successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Clean up
      if (statement != null) {
        try {
          statement.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
    

