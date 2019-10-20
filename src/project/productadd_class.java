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
public class productadd_class {
 line con = new line();
 
  public int product( String product_name, int quantity, Object price){
        int x = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
            String query = "insert into addproduct values (null,?, ?, ?)";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
           
            
            pstmt.setString(1, product_name);
            pstmt.setInt(2, quantity);
            pstmt.setObject(3, price);
            
             x = pstmt.executeUpdate();
             
                     
            
            
        } catch (ClassNotFoundException ex) { 
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     }
        
        return x;
    }
    public int checkprod(String prod_name){
       int x = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
            String query = "Select prod_name from addproduct where prod_name = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, prod_name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                x = 1;
            }else{
                x = 0;
            }
                    
        } catch (SQLException ex) { 
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     }
        return x;
    }
      public int edit(Object id, String prod_name, Object price){
       int y = 0;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
           String query = "update addproduct set prod_name = ?, price = ? where id = ?;";
           PreparedStatement pstmt = conn.prepareStatement(query);
           pstmt.setString(1, prod_name);
           float nprice = Float.parseFloat(price.toString());
           pstmt.setFloat(2, nprice);
           String nid = (String) id;
           pstmt.setString(3, nid);
           
           pstmt.executeUpdate();
           
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(productadd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productadd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return y;
   }

}
