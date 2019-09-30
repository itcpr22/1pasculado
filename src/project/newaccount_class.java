/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class newaccount_class {
    line con = new line();
    public int account(String username,String password, String firstname, String lastname){
        int x = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
            String query = "insert into tbl1 values(?,md5(?),?,?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstname);
            pstmt.setString(4, lastname);
            x =  pstmt.executeUpdate();
           
        } catch (ClassNotFoundException ex) { 
            Logger.getLogger(newaccount_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(newaccount_class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
  
    public int checkUsername(String username){
        int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =  DriverManager.getConnection(con.url, con.user, con.pass);
        
            String sql = "SELECT username FROM tbl1 WHERE username = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x = 1;
            }else{
                x = 0;
            }
            
              
       
    }   catch (ClassNotFoundException ex) {   
            Logger.getLogger(newaccount_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(newaccount_class.class.getName()).log(Level.SEVERE, null, ex);
        }
     return x;
    }
      public int cpass(String password, String confirmPassword){
        int x = 0;
        
        if(password.equals(confirmPassword)){
            x = 1;
        }else{
            x = 0;
        }
        return x;
      }
    
}
