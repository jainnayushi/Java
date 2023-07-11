// Select Query Statement Interface
import java.sql.*;

class SelectJDBC {
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
            String q = "select * from table1";
            
            // 4. Create a PreparedStatement
            Statement stmt = con.createStatement(); 

            // ResultSet has data in the form of table
            ResultSet set = stmt.executeQuery(q);
            while(set.next()){ // return true if there is next row
                int id = set.getInt(1);
                String name = set.getString(2);
                String city = set.getString(3);
                System.out.println(id+" : "+name+" : "+city);
            }

            // 5. Close the connection
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

