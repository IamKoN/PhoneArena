package UserFunctions;

import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.JdbcRowSetImpl;

public class usersBean {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_phone1";
    static final String DB_USER = "root";
    static final String DB_PASS = "applesauce";
    private JdbcRowSet rowSet = null;
    
    public usersBean() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM users");
            rowSet.execute();
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public users create(users p) {
        try {
            rowSet.moveToInsertRow();
            //rowSet.updateInt("personId", p.getID());
            rowSet.updateString("username", p.getUN());
            rowSet.updateString("password", p.getPW());
            rowSet.updateString("firstname", p.getFN());
            rowSet.updateString("lastname", p.getLN());
            rowSet.updateString("email", p.getEM());
            rowSet.updateString("phoneNum", p.getPN());
            //rowSet.updateInt("createTime", p.getCT());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {rowSet.rollback(); p = null;}
            catch (SQLException e){}
            ex.printStackTrace();
        }
        return p;
    }
    public users update(users p) {
        try {
            //rowSet.updateInt("personId", p.getID());
            rowSet.updateString("username", p.getUN());
            rowSet.updateString("password", p.getPW());
            rowSet.updateString("firstname", p.getFN());
            rowSet.updateString("lastname", p.getLN());
            rowSet.updateString("email", p.getEM());
            rowSet.updateString("phoneNum", p.getPN());
            //rowSet.updateInt("createTime", p.getCT());
            rowSet.updateRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try { rowSet.rollback(); }
            catch (SQLException e) { }
            ex.printStackTrace();
        }
        return p;
    }
    public void delete() {
        try {
            rowSet.moveToCurrentRow();
            rowSet.deleteRow();
        } catch (SQLException ex) {
            try { rowSet.rollback(); }
            catch (SQLException e) { }
            ex.printStackTrace();
        }
   }
    public users moveFirst() {
        users p = new users();
        try {
            rowSet.first();
            //p.setID(rowSet.getInt("personId"));
            p.setUN(rowSet.getString("username"));
            p.setPW(rowSet.getString("password"));
            p.setFN(rowSet.getString("firstname"));
            p.setLN(rowSet.getString("lastname"));
            p.setEM(rowSet.getString("email"));
            p.setPN(rowSet.getString("phoneNum"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) {ex.printStackTrace();}
        return p;
    }
    public users moveLast() {
        users p = new users();
        try {
            rowSet.last();
            //p.setID(rowSet.getInt("personId"));
            p.setUN(rowSet.getString("username"));
            p.setPW(rowSet.getString("password"));
            p.setFN(rowSet.getString("firstname"));
            p.setLN(rowSet.getString("lastname"));
            p.setEM(rowSet.getString("email"));
            p.setPN(rowSet.getString("phoneNum"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public users moveNext() {
        users p = new users();
        try {
            if (rowSet.next() == false)
                rowSet.previous();
            //p.setID(rowSet.getInt("personId"));
            p.setUN(rowSet.getString("username"));
            p.setPW(rowSet.getString("password"));
            p.setFN(rowSet.getString("firstname"));
            p.setLN(rowSet.getString("lastname"));
            p.setEM(rowSet.getString("email"));
            p.setPN(rowSet.getString("phoneNum"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public users movePrevious() {
        users p = new users();
        try {
            if (rowSet.previous() == false)
                rowSet.next();
            //p.setID(rowSet.getInt("personId"));
            p.setUN(rowSet.getString("username"));
            p.setPW(rowSet.getString("password"));
            p.setFN(rowSet.getString("firstname"));
            p.setLN(rowSet.getString("lastname"));
            p.setEM(rowSet.getString("email"));
            p.setPN(rowSet.getString("phoneNum"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public users getCurrent() {
        users p = new users();
        try {
            rowSet.moveToCurrentRow();
            //p.setID(rowSet.getInt("personId"));
            p.setUN(rowSet.getString("username"));
            p.setPW(rowSet.getString("password"));
            p.setFN(rowSet.getString("firstname"));
            p.setLN(rowSet.getString("lastame"));
            p.setEM(rowSet.getString("email"));
            p.setPN(rowSet.getString("phoneNum"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public users searchUser(users p) {
        boolean found = false;
        try {
            rowSet.first();
            if (((rowSet.getString("username")).equals(p.getUN()) == true)){
                found = true;
                p.setUN(rowSet.getString("username"));
                p.setPW(rowSet.getString("password"));
                p.setFN(rowSet.getString("firstname"));
                p.setLN(rowSet.getString("lastname"));
                p.setEM(rowSet.getString("email"));
                p.setPN(rowSet.getString("phoneNum"));
            }
            do{
                if (((rowSet.getString("username")).equals(p.getUN()) == true) /* ||
                        (rowSet.getString("password").equals(p.getPW()) == true) ||
                        (rowSet.getString("firstname").equals(p.getFN()) == true) ||
                        (rowSet.getString("lastname").equals(p.getLN()) == true) ||
                        (rowSet.getString("email").equals(p.getEM()) == true) ||
                        (rowSet.getString("phoneNum").equals(p.getPN()) == true)*/){
                    found = true;  
                    rowSet.moveToCurrentRow();
                    p.setUN(rowSet.getString("username"));
                    p.setPW(rowSet.getString("password"));
                    p.setFN(rowSet.getString("firstname"));
                    p.setLN(rowSet.getString("lastname"));
                    p.setEM(rowSet.getString("email"));
                    p.setPN(rowSet.getString("phoneNum"));
                    break;
                }
                if (rowSet.next() == false) {
                    rowSet.previous();
                    //p = null; break;
                }
            } while(rowSet.isLast() == false);
            if (found == false)
                p = null;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
}
