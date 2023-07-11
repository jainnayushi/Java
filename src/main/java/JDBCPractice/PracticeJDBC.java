package JDBCPractice;

import JDBCPractice.ConnectionProvider;

import java.io.*;
import java.sql.*;

class PracticeJDBC{
    public static void main(String args[]) {
        try{
            // 2. Create the connection
            Connection c = ConnectionProvider.getConnection();
            // 3. Fire Query
            String q = "insert into table1(tName, tCity) values (?,?)";

            // 4. Create a PreparedStatement
            PreparedStatement pstmt = c.prepareStatement(q); // Pass q here

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
            c.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}