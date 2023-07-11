package JDBCPractice;

// Create database connection
import java.sql.*;

class CreateConnectionJDBC {
    public static void main(String args[]) {
        try{
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create the connection
            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "Qazwsx@1";

            Connection con = DriverManager.getConnection(url, username,password);

            if(con.isClosed()){
                System.out.println("Connection is Closed");
            }else{
                System.out.println("Connection Established");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
