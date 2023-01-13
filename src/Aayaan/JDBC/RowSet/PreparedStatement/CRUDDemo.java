
package Aayaan.JDBC.RowSet.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class CRUDDemo {
     public static void main(String[] args) {
    // Get user input
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the name of the user you want to find: ");
    String name = scanner.nextLine();
    
    // JDBC code
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      // Load the JDBC driver
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      // Open a connection
      connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=User;encrypt=true;trustServerCertificate=true", "sa", "aayaan");
      
      // Read
      statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
      statement.setString(1, name);
      resultSet = statement.executeQuery();
      if (resultSet.next()) {
        int id = resultSet.getInt("id");
        int age = resultSet.getInt("age");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
      } else {
        System.out.println("User not found.");
      }
      
      // Update
      System.out.println("Enter the new age for this user: ");
      int newAge = scanner.nextInt();
      statement = connection.prepareStatement("UPDATE users SET age = ? WHERE name = ?");
      statement.setInt(1, newAge);
      statement.setString(2, name);
      statement.executeUpdate();
      System.out.println("User updated successfully.");
      
      // Create
      System.out.println("Enter the name of the new user: ");
      scanner.next();
      String newName = scanner.nextLine();
      System.out.println("Enter the age of the new user: ");
      int newUserAge = scanner.nextInt();
      statement = connection.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)");
      statement.setString(1, newName);
      statement.setInt(2, newUserAge);
      statement.executeUpdate();
      System.out.println("User created successfully.");
      
      // Delete
      System.out.println("Enter the name of the user you want to delete: ");
      scanner.next();
      String deleteName = scanner.nextLine();
      statement = connection.prepareStatement("DELETE FROM users WHERE name = ?");
      statement.setString(1, deleteName);
      statement.executeUpdate();
      System.out.println("User deleted successfully.");
    } catch (Exception e) {
      e.printStackTrace();
    }
    finally{
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
