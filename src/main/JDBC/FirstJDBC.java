package JDBC;// This is 1st JDBC program
import java.sql.*;

class FirstJDBC{
    public static void main(String args[]) {
        try{
            // 2. Create the connection
            Connection c = ConnectionProvider.getConnection();

            if(c.isClosed()){
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