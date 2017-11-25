/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.ProcurementStaff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import purchase.order.system.Public.DBConn;

/**
 *
 * @author User
 */
public class PurchaseOrderController {
    
    public ResultSet getPurchaseOrderDetails() {

        ResultSet rs = null;
        try {
            String sql = "select concat('PCH00',PurchaseReference) as 'PCH REFERENCE',OrderAmount as 'GROSS TOTAL',DeliveryAddress as 'DEL.ADDRESS' from purchaseorder where OrderStatus=? ";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1, "Pending");
            

            rs = pst.executeQuery();

            return rs;

        } catch (SQLException e) {

            System.out.println(e);
            return rs;
        } catch (Exception e) {

            System.out.println(e);
            return rs;
        }

    }

    public boolean addPurchaseOrder(PurchaseOrderModel pom,CreatePurchaseOrder cp) {

        String sql = "insert into purchaseorder(RequisitionNo,SupplierId,OrderAmount,OrderStatus,DiscountAmnt,OtherDeductions,OtherAdditions,DeliveryAddress) values (?,?,?,?,?,?,?,?)";
        try {

            PreparedStatement pst = DBConn.myConn().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pst.setInt(1, pom.getRequisitionNo());
            pst.setInt(2, pom.getSupplierId());

            pst.setDouble(3, pom.getOrderAmount());
            pst.setString(4, pom.getOrderStatus());
            pst.setDouble(5, pom.getDiscount());
            pst.setDouble(6, pom.getDeductions());
            pst.setDouble(7, pom.getAdditions());
            pst.setString(8, pom.getDeliveryAddress());
            pst.executeUpdate();
            
            ResultSet rs=pst.getGeneratedKeys();
            int purchaseId;
            if (rs.next()) {
                    purchaseId = rs.getInt(1);
                    cp.setPurchaseReference(purchaseId);
                }

         //   JOptionPane.showMessageDialog(null, "Successfully Created");
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Order");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Order");
            System.out.println(ex);

            return false;
        }
    }
    public int getRequisitionNo(int purchaseReference) {

        ResultSet rs = null;
        int requisitionNo=0;
        try {
            String sql = "select RequisitionNo from purchaseorder where PurchaseReference=? ";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, purchaseReference);
            rs = pst.executeQuery();
            if(rs.next()){
                requisitionNo=rs.getInt("RequisitionNo");
            }
            

            return requisitionNo;

        } catch (SQLException e) {

            System.out.println(e);
            return requisitionNo;
        } catch (Exception e) {

            System.out.println(e);
            return requisitionNo;
        }

    }

    public ResultSet getSupplierNameAndId() {

        ResultSet rs = null;
        try {
            String sql = "select supplierId,supplierName from supplier where supplierApproval=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setBoolean(1, true);
            rs = pst.executeQuery();

            return rs;

        } catch (SQLException e) {

            System.out.println(e);
            return rs;
        } catch (Exception e) {

            System.out.println(e);
            return rs;
        }

    }
    
    public ResultSet getSupplierDetails(int supplierId) {

        ResultSet rs = null;
        try {
            String sql = "select * from supplier where supplierId=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, supplierId);
            rs = pst.executeQuery();

            return rs;

        } catch (SQLException e) {

            System.out.println(e);
            return rs;
        } catch (Exception e) {

            System.out.println(e);
            return rs;
        }

    }

    public ResultSet getSiteDetails(int requisitionNo) {

        String user = null;
        ResultSet rs = null;
        try {
            user = getRequisitionerUser(requisitionNo);
            String sql = "select * from site where siteManager=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1, user);
            rs = pst.executeQuery();

            return rs;

        } catch (SQLException e) {

            System.out.println(e);
            return rs;
        } catch (Exception e) {

            System.out.println(e);
            return rs;
        }

    }

    public String getRequisitionerUser(int requisitionNo) {

        
        ResultSet rs = null;
        try {
            String sql = "select Requisitioner from purchaserequisition where RequisitionNo=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, requisitionNo);

            rs = pst.executeQuery();

            if (rs.next()) {

                return rs.getString("Requisitioner");
            }

            return null;

        } catch (SQLException e) {

            System.out.println(e);
            return null;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }

    }
    
    public String getRequisitionerAddress(String requisitioner){
        
        ResultSet rs = null;
        try {
            String sql = "select SiteAddress from site where siteManager=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1, requisitioner);

            rs = pst.executeQuery();

            if (rs.next()) {

                return rs.getString("SiteAddress");
            }

            return null;

        } catch (SQLException e) {

            System.out.println(e);
            return null;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }
    
    public boolean UpdatePurchaseOrderStatus(String Status,int purchaseNo) {

        
        ResultSet rs = null;
       
       
        String sql = "update purchaseorder set OrderStatus=? where PurchaseReference=?  ";
        try {
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
                      
                pst.setString(1, Status);
                pst.setInt(2, purchaseNo);             
                pst.executeUpdate();
                                       

            return true;

        } catch (SQLException ex) {
            
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            
            System.out.println(ex);

            return false;
        }
    }

}
