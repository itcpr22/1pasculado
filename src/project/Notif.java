/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class Notif {
 line con = new line();
 
        public void notification(){
     try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
         String query = "Select * from addproduct";
         String U_query = "Update addproduct set status=? where ID = ?";
         Statement stmt = conn.prepareCall(query);
         PreparedStatement pstmt = conn.prepareStatement(U_query);
         ResultSet rs = stmt.executeQuery(query);
         
         while(rs.next()){
             int qty = rs.getInt("qty");
             int stat = rs.getInt("status");
             String product = rs.getString("prod_name");
             String id = rs.getString("ID");
             
             if(qty < 5 && stat !=1){
                 pstmt.setInt(1, 1);
                 pstmt.setString(2, id);
                 pstmt.executeUpdate();
                 showNotification(product);
             }else if(qty >= 5 && stat == 1){
                  pstmt.setInt(1, 2);
                  pstmt.setString(2, id);
                  pstmt.executeUpdate();
         }
         
         
         }
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(Notif.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(Notif.class.getName()).log(Level.SEVERE, null, ex);
     } catch (AWTException ex) {
         Logger.getLogger(Notif.class.getName()).log(Level.SEVERE, null, ex);
     }
            
            
}
        void showNotification(String product) throws AWTException{
            SystemTray ST = SystemTray.getSystemTray();
            Image img = Toolkit.getDefaultToolkit().createImage("project.img/warning.png");
            
            TrayIcon TI = new TrayIcon(img,"");
            TI.setImageAutoSize(true);
            ST.add(TI);
            TI.displayMessage("LOW QUANTITY", product+" is low on quantity", TrayIcon.MessageType.WARNING);
            
        }
        public void getprod(String id, JTable table){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
                String query = "Select * from addproduct where ID= ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                
                pstmt.setString(1, id);
                ResultSet rs = pstmt.executeQuery();
                
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                
                while(rs.next()){
                    int qty = 1;
                    float subtotal = qty * rs.getFloat("price");
                    model.addRow(new Object[]{rs.getString("ID"),qty,  rs.getString("prod_name"), rs.getString("price"), subtotal});
                }
            } catch (ClassNotFoundException ex) {
         Logger.getLogger(Notif.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(Notif.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
          public int minusqty(Object id,int quantity){
          int x = 0;
          try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection(con.url, con.user, con.pass);
              String query = "Update addproduct set qty = qty - ? where id = ?;";
              PreparedStatement pstmt = conn.prepareStatement(query);
              
              pstmt.setInt(1, quantity);
              pstmt.setObject(2, id);
              
              x = pstmt.executeUpdate();
              System.out.println(pstmt);
          } catch (ClassNotFoundException ex) {
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     } catch (SQLException ex) {
         Logger.getLogger(productadd_class.class.getName()).log(Level.SEVERE, null, ex);
     }
          return x;
      }
}
