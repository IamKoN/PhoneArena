package LoginScreen;
import com.sun.rowset.JdbcRowSetImpl;
import java.sql.*;
import javax.sql.rowset.JdbcRowSet;
import javax.swing.*;

public class UsersConnecter {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_phone1";
    static final String DB_USER = "root";
    static final String DB_PASS = "applesauce";
    private JdbcRowSet rowSet = null;
    //Connection conn=null;
    public void ConnectDB(){
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM users");
            rowSet.execute();
            JOptionPane.showMessageDialog(null,"Connected to database");
            //return conn;
        } catch (Exception ex) { 
            ex.printStackTrace(); 
            JOptionPane.showMessageDialog(null,ex);
            //return null;
        }
    }
}