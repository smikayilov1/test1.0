package com.data;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author smikayilov
 */
public class Dao extends DBConnect{
    public Dao(){
        super();
    }
    public void writer(Person p){
        try {
            ps=c.prepareStatement("insert into accounts(name,password,mail) values(?,?,?)");
            ps.setString(1,p.getName());
            ps.setString(2,p.getPassword());
            ps.setString(3,p.getEmail());
            ps.executeUpdate();         
         } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean select(String email,String password){
        boolean temp=false;
        try {
            ps=c.prepareStatement("select * from accounts where mail='"+email+"' and password='"+password+"'");
            rs=ps.executeQuery();
            if(rs.next()){
           temp=true;
            }
            else{
                temp=false;
            }
            System.out.println(temp);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temp;
    }
    public boolean check(String email){
            boolean temp=false;
        try {
            ps=c.prepareStatement("select * from accounts where mail='"+email+"'");
            rs=ps.executeQuery();
            if (rs.next()) {
                temp=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }
  public boolean changePassword(String mail,String newPass){
      boolean temp=false;
        try {
            ps=c.prepareStatement("update accounts  set password='"+newPass+"' where mail='"+mail+"'");
            int i=ps.executeUpdate();
            if (i>0) {
                temp=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      return temp;
  }
  public void storeRank(String name,int points){
        try {
            ps=c.prepareStatement("insert into ranking(name,points) values(?,?)");
            ps.setString(1, name);
            ps.setInt(2, points);
            int i=ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  public String selectName(String mail){
      String name="";
        try {
            ps=c.prepareStatement("select  name from accounts where mail='"+mail+"'");
            rs=ps.executeQuery();
            if (rs.next()) {
                name=rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
  }
}
