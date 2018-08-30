/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginScreen;

import RatingFunctions.rating;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.JdbcRowSetImpl;

public class UserRatingBean {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbms_phone1";
    static final String DB_USER = "root";
    static final String DB_PASS = "applesauce";
    private JdbcRowSet rowSet = null;
    String N;

    public UserRatingBean(String N) {
        this.N = N;
        try {
            Class.forName(JDBC_DRIVER);
            rowSet = new JdbcRowSetImpl();
            rowSet.setUrl(DB_URL);
            rowSet.setUsername(DB_USER);
            rowSet.setPassword(DB_PASS);
            //rowSet.setCommand("SELECT * FROM rating WHERE username = " + N);
            rowSet.setCommand("SELECT * FROM rating");
            rowSet.execute();
           
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    public rating create(rating p) {
        try {
            rowSet.moveToInsertRow();
            rowSet.updateString("username", p.getUN());
            rowSet.updateString("id", p.getID());
            rowSet.updateString("make", p.getMK());
            rowSet.updateString("model", p.getMD());
            rowSet.updateString("userRating", p.getUR());
            rowSet.insertRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try { rowSet.rollback(); p = null; }
            catch (SQLException e) {}
            ex.printStackTrace();
        }
        return p;
    }
    public rating update(rating p) {
        try {
            rowSet.updateString("username", p.getUN());
            rowSet.updateString("id", p.getID());
            rowSet.updateString("make", p.getMK());
            rowSet.updateString("model", p.getMD());
            rowSet.updateString("userRating", p.getUR());
            rowSet.updateRow();
            rowSet.moveToCurrentRow();
        } catch (SQLException ex) {
            try { rowSet.rollback(); } 
            catch (SQLException e) {}
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
            catch (SQLException e) {}
            ex.printStackTrace();
        }
    }
    public rating moveFirst() {
        rating p = new rating();
        try {
            rowSet.first();
            p.setUN(rowSet.getString("username"));
            p.setID(rowSet.getString("id"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setUR(rowSet.getString("userRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public rating moveLast() {
        rating p = new rating();
        try {
            rowSet.last();
            p.setUN(rowSet.getString("username"));
            p.setID(rowSet.getString("id"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setUR(rowSet.getString("userRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public rating moveNext() {
        rating p = new rating();
        try {
            if (rowSet.next() == false) { rowSet.previous(); }
            p.setUN(rowSet.getString("username"));
            p.setID(rowSet.getString("id"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setUR(rowSet.getString("userRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public rating movePrevious() {
        rating p = new rating();
        try {
            if (rowSet.previous() == false) { rowSet.next(); }
            p.setUN(rowSet.getString("username"));
            p.setID(rowSet.getString("id"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setUR(rowSet.getString("userRating"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
    public rating getCurrent() {
        rating p = new rating();
        try {
            rowSet.moveToCurrentRow();
            p.setUN(rowSet.getString("username"));
            p.setID(rowSet.getString("id"));
            p.setMK(rowSet.getString("make"));
            p.setMD(rowSet.getString("model"));
            p.setUR(rowSet.getString("userRating"));
        } catch (SQLException ex) { ex.printStackTrace();}
        return p;
    }
    public rating searchRating(rating p) {
        boolean found = false;
        try {
            rowSet.first();
            if (((rowSet.getString("model")).equals(p.getMD()) == true)){
                found = true;
                p.setID(rowSet.getString("id"));
                p.setUN(rowSet.getString("username"));
                p.setMK(rowSet.getString("make"));
                p.setMD(rowSet.getString("model"));
                p.setUR(rowSet.getString("userRating"));
            }
            do {
                if (((rowSet.getString("model")).equals(p.getMD()) == true)) {
                    found = true;
                    rowSet.moveToCurrentRow();
                    p.setID(rowSet.getString("id"));
                    p.setUN(rowSet.getString("username"));
                    p.setMK(rowSet.getString("make"));
                    p.setMD(rowSet.getString("model"));
                    p.setUR(rowSet.getString("userRating"));
                    break;
                }
                if (rowSet.next() == false) {
                    rowSet.previous();
                    //p = null; break;
                }
            } while (rowSet.isLast() == false);
            if (found == false)
                p = null;
        } catch (SQLException ex) { ex.printStackTrace(); }
        return p;
    }
}

