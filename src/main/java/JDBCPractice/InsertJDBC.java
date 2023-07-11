// Insert data into table using PreparedStatement
import java.sql.*;

class InsertJDBC {
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
            String q = "insert into table1(tName, tCity) values (?,?)";
            
            // 4. Create a PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(q); // Pass q here

            // Set values to query
            pstmt.setString(1, "Ayushi");
            pstmt.setString(2, "Pune");

            pstmt.executeUpdate(); // No need to pass q

            System.out.println("Values inserted into Table...");
            // 5. Close the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

// Values inserted into Table...