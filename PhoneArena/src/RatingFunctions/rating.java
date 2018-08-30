package RatingFunctions;

import java.sql.*;
import javax.swing.JOptionPane;

public class rating {
    //private int userID;
    private String id;
    private String make;
    private String model;
    private String username;
    private String userRating;
    //private int createTime;
    //...constructors, getters, and setters
    //public int getID(){return userID;}
    public String getUN(){ return username; }
    public String getID(){ return id; }
    public String getMK(){ return make; }
    public String getMD(){ return model; }
    public String getUR(){ return userRating; }
    //public int getCT(){ return createTime; }
    //public void setID(int id){ userID =id; }
    public void setUN(String UN){ username = UN; }
    public void setID(String ID){ id = ID; }
    public void setMK(String MK){ make= MK; }
    public void setMD(String MD){ model = MD; }
    public void setUR(String UR){ userRating = UR; }
    //public void setCT(int ct){ createTime = ct; }
}