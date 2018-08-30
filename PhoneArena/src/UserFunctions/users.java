package UserFunctions;


public class users {
    //private int userID;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNum;
    //private int createTime;
    //...constructors, getters, and setters
    //public int getID(){return userID;}
    public String getUN(){ return username; }
    public String getPW(){ return password; }
    public String getFN(){ return firstname; }
    public String getLN(){ return lastname; }
    public String getEM(){ return email; }
    public String getPN(){ return phoneNum; }
    //public int getCT(){ return createTime; }
    //public void setID(int id){ userID =id; }
    public void setUN(String un){ username = un; }
    public void setPW(String pw){ password = pw; }
    public void setFN(String fn){ firstname = fn; }
    public void setLN(String ln){ lastname = ln; }
    public void setEM(String em){ email = em; }
    public void setPN(String pn){ phoneNum = pn; }
    //public void setCT(int ct){ createTime = ct; }
}