package JDBCPractice;
import java.sql.*;

public class ConnectionProvider{
    private static Connection con; //null

    public static Connection getConnection(){
        try {
            if (con == null) {
                // 1. Load the driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 2. Create the connection
                String url = "jdbc:mysql://localhost:3306/firstdb";
                String username = "root";
                String password = "Qazwsx@1";

                con = DriverManager.getConnection(url, username, password);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }

    }
