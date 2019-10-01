/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class delete {
    line con = new line();
    
    public int deleted(String ID){
        int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(con.url,con.user,con.pass);
            String query = "delete from addproduct where id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, ID);
            
            x = pstmt.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }
}
