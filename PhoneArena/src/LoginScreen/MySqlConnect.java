package LoginScreen;
import java.sql.*;
import javax.swing.*;

public class MySqlConnect {
    Connection conn=null;
    public static Connection ConnectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms_phone1","root","applesauce");
            JOptionPane.showMessageDialog(null,"Connected to database");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}