
package Aayaan.JDBC.RowSet;
import java.sql.*;
import javax.sql.rowset.*;


public class rowset {
    public static void main(String[] args)throws Exception {
        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
        JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        rowSet.setUrl("jdbc:sqlserver://localhost:1433;databaseName=StudentJava;user=sa;password=aayaan;encrypt=true;trustServerCertificate=true");
        rowSet.setUsername("sa");
        rowSet.setPassword("aayaan");
        rowSet.setCommand("SELECT * FROM student");
        rowSet.execute();
        rowSet.last();
        System.out.println("--Last Row__");
        System.out.println(rowSet.getInt("id")+","+rowSet.getString("Name")+","+rowSet.getString("District")+","+rowSet.getInt("Age"));
        
        rowSet.first();
        System.out.println("--first row---");
        System.out.println(rowSet.getInt("id")+","+","+rowSet.getString("Name")+","+rowSet.getString("District")+rowSet.getInt("Age"));
        
    }
}
