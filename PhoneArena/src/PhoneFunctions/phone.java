package PhoneFunctions;

import PhoneFunctions.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class phone {
    //private int userID;
    private String make;
    private String model;
    private String price;
    private String ram;
    private String screen;
    private String mem;
    private String AvgR;
    //private int createTime;
    //...constructors, getters, and setters
    //public int getID(){return userID;}
    public String getMK(){ return make; }
    public String getMD(){ return model; }
    public String getMM(){ return price; }
    public String getPR(){ return ram; }
    public String getRM(){ return screen; }
    public String getSC(){ return mem; }
    public String getAR(){ return AvgR; }
    //public int getCT(){ return createTime; }
    //public void setID(int id){ userID =id; }
    public void setMK(String MK){ make = MK; }  
    public void setMD(String MD){ model = MD; }
    public void setMM(String MM){ price = MM; }
    public void setPR(String PR){ ram = PR; }
    public void setRM(String RM){ screen = RM; }
    public void setSC(String SC){ mem = SC; }
    public void setAR(String AR){ AvgR = AR; }
    //public void setCT(int ct){ createTime = ct; }
}