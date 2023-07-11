
// Insert data to table with Dynamic Input
import java.sql.*;
import java.io.*; 

class InsertFromInputJDBC {
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

            // Take Input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Name : ");
            String name = br.readLine();
            System.out.println("Enter City : ");
            String city = br.readLine();

            // Set values to query
            pstmt.setString(1, name);
            pstmt.setString(2, city);

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