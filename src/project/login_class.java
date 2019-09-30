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
public class login_class {
    line con = new line();
    
    public int loginform(String username,String password){
      int x =0;
    
    try{
        Class.forName("com.mysql.jdbc.Driver");
         Connection conn = (Connection) DriverManager.getConnection(con.url,con.user,con.pass);
         String query = "Select * from tbl1 where username = ? and password = ?";
         PreparedStatement pstmt = conn.prepareStatement(query);
         pstmt.setString(1, username);
         pstmt.setString(2, password);
         
         
          ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                x = 1;
            }else{
                x = 0;
            }
    }   catch (ClassNotFoundException ex) { 
            Logger.getLogger(login_class.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login_class.class.getName()).log(Level.SEVERE, null, ex);
        }
    return x;
    }
    
    
}
