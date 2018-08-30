package PhoneFunctions;

import PhoneFunctions.*;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.JdbcRowSetImpl;

public class phoneBean {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_phone1";
    static final String DB_USER = "root";
    static final String DB_PASS = "applesauce";
    public JdbcRowSet rowSet = null;
    
    public phoneBean() {
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            rowSet.setCommand("SELECT * FROM phone");
            rowSet.execute();
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public phone create(phone p) {
        try {
            rowSet.moveToInsertRow();
            //rowSet.updateInt("personId", p.getID());
            rowSet.updateString("make", p.getMK());
            rowSet.updateString("model", p.getMD());
            rowSet.updateString("price", p.getPR());
            rowSet.updateString("ram", p.getRM());
            rowSet.updateString("screen", p.getSC());
            rowSet.updateString("mem", p.getMM());
            rowSet.updateString("avgRating", p.getAR());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try {rowSet.rollback(); p = null;}
            catch (SQLException e){}
            ex.printStackTrace();
        }
        return p;
    }
    public phone update(phone p) {
        try {
            //rowSet.updateInt("personId", p.getID());
            rowSet.updateString("make", p.getMK());
            rowSet.updateString("model", p.getMD());
            rowSet.updateString("price", p.getPR());
            rowSet.updateString("ram", p.getRM());
            rowSet.updateString("screen", p.getSC());
            rowSet.updateString("mem", p.getMM());
            rowSet.updateString("avgRating", p.getAR());
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
    public phone moveFirst() {
        phone p = new phone();
        try {
            rowSet.first();
            //p.setID(rowSet.getInt("personId"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setPR(rowSet.getString("price"));
            p.setRM(rowSet.getString("ram"));
            p.setSC(rowSet.getString("screen"));
            p.setMM(rowSet.getString("mem"));
            p.setAR(rowSet.getString("avgRating"));
        } catch (SQLException ex) {ex.printStackTrace();}
        return p;
    }
    public phone moveLast() {
        phone p = new phone();
        try {
            rowSet.last();
            //p.setID(rowSet.getInt("personId"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setPR(rowSet.getString("price"));
            p.setRM(rowSet.getString("ram"));
            p.setSC(rowSet.getString("screen"));
            p.setMM(rowSet.getString("mem"));
            p.setAR(rowSet.getString("avgRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public phone moveNext() {
        phone p = new phone();
        try {
            if (rowSet.next() == false)
                rowSet.previous();
            //p.setID(rowSet.getInt("personId"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setPR(rowSet.getString("price"));
            p.setRM(rowSet.getString("ram"));
            p.setSC(rowSet.getString("screen"));
            p.setMM(rowSet.getString("mem"));
            p.setAR(rowSet.getString("avgRating"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public phone movePrevious() {
        phone p = new phone();
        try {
            if (rowSet.previous() == false)
                rowSet.next();
            //p.setID(rowSet.getInt("personId"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setPR(rowSet.getString("price"));
            p.setRM(rowSet.getString("ram"));
            p.setSC(rowSet.getString("screen"));
            p.setMM(rowSet.getString("mem"));
            p.setAR(rowSet.getString("avgRating"));
            //p.setCT(rowSet.getInt("creatTime"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public phone getCurrent() {
        phone p = new phone();
        try {
            rowSet.moveToCurrentRow();
            //p.setID(rowSet.getInt("personId"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setPR(rowSet.getString("price"));
            p.setRM(rowSet.getString("ram"));
            p.setSC(rowSet.getString("screen"));
            p.setMM(rowSet.getString("mem"));
            p.setAR(rowSet.getString("avgRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public phone searchPhone(phone p) {
        boolean found = false;
        try {
            rowSet.first();
            if (((rowSet.getString("model")).equals(p.getMD()) == true)){
                found = true;
                p.setMK(rowSet.getString("make"));
                p.setMD(rowSet.getString("model"));
                p.setPR(rowSet.getString("price"));
                p.setRM(rowSet.getString("ram"));
                p.setSC(rowSet.getString("screen"));
                p.setMM(rowSet.getString("mem"));
                p.setAR(rowSet.getString("avgRating"));
            }
            do{
                if (((rowSet.getString("model")).equals(p.getMD()) == true) /* ||
                        (rowSet.getString("model").equals(p.getMD()) == true) ||
                        (rowSet.getString("price").equals(p.getMM()) == true) ||
                        (rowSet.getString("ram").equals(p.getPR()) == true) ||
                        (rowSet.getString("screen").equals(p.getRM()) == true) ||
                        (rowSet.getString("mem").equals(p.getSC()) == true)*/){
                    found = true;
                    rowSet.moveToCurrentRow();
                    p.setMK(rowSet.getString("make"));
                    p.setMD(rowSet.getString("model"));
                    p.setPR(rowSet.getString("price"));
                    p.setRM(rowSet.getString("ram"));
                    p.setSC(rowSet.getString("screen"));
                    p.setMM(rowSet.getString("mem"));
                    p.setAR(rowSet.getString("avgRating"));
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
