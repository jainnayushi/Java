// Updating data of Table in database
import java.sql.*;
import java.io.*; 

class UpdateJDBC {
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
            String q = "update table1 set tName=?, tCity=? where tId=?";
            
            // 4. Create a PreparedStatement
            PreparedStatement pstmt = con.prepareStatement(q); // Pass q here

            // Take Input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter New Name : ");
            String name = br.readLine();
            System.out.println("Enter New City : ");
            String city = br.readLine();
            System.out.println("Enter Id : ");
            int id = Integer.parseInt(br.readLine());

            // Set values to query
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);


            pstmt.executeUpdate(); 

            System.out.println("Values updated in the Table...");
            
            // 5. Close the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

