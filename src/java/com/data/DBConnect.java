package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author smikayilov
 */
public class DBConnect {
    public DBConnect(){
        connect();
    }
protected Connection c;
protected PreparedStatement ps;
protected ResultSet rs;
public void connect(){
    try {
            Class.forName("org.postgresql.Driver");
        c=DriverManager.getConnection("jdbc:postgresql://localhost:5432/myapp", "postgres", "");
    } catch (SQLException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public void close(){
    if (c!=null) {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (ps!=null) {
        try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    if (rs!=null) {
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
