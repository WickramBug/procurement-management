/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.Public;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class LoginController {
    
    
    
    
    public boolean checkUserExists(String user) {

        ResultSet rs = null;
        try {
            System.out.println("Came");
            String sql = "select * from user where UserName=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1,user );
            rs = pst.executeQuery();
            
            if(rs.next()){
            return true;
            }

        } catch (SQLException e) {

            System.out.println(e);
            return false;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
        return false;
    }
    
     public String getUserRole(String user) {
         System.out.println("Came");
        ResultSet rs = null;
        String role=null;
        try {
            String sql = "select Role from user where UserName=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1,user);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                role=rs.getString("Role");
            }

        } catch (SQLException e) {

            System.out.println(e);
            return role;
        } catch (Exception e) {

            System.out.println(e);
            return role;
        }
        return role;
    }
    
    
    
}
