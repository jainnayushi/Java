// Create table from java program
import java.sql.*;

class FireQueryJDBC {
    public static void main(String args[]) {
        try{
            // 1. Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Create the connection
            String url = "jdbc:mysql://localhost:3306/firstdb";
            String username = "root";
            String password = "Qazwsx@1";

            Connection con = DriverManager.getConnection(url, username,password);
            // 3. Fire Query
            String q = "create table table1(tId int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";
            // 4. Create a statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table created in database...");
            // 5. Close the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Table created in database...