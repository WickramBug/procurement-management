/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JOptionPane;
import purchase.order.system.Public.DBConn;


public class PurchaseRequisitionController {

    /**
     * This method is used to get all the Item details of given ItemId.
     */
    public ResultSet getItem(int itemId) {

        ResultSet rs = null;
        try {
            String sql = "select concat('ITM',itemId) as 'ITEM ID',description as 'DESCRIPTION',agreedPrice as 'UNIT PRICE' from item where itemId=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, itemId);
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
    
     /**
     * This method is used to get all the Non Restricted Item details.
     */
    public ResultSet getItemDetails() {

        ResultSet rs = null;
        try {
            String sql = "select concat('ITM',itemId) as 'ITEM ID',category as 'CATEGORY',description as 'DESCRIPTION',agreedPrice as 'UNIT PRICE' from item where restrictedStatus=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setBoolean(1, false);
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
    /**
     * This method is used to filter items by category .
     */
    
    public ResultSet getItemDetailsByCategory(String category) {

        ResultSet rs = null;
        try {
            String sql = "select concat('ITM',itemId) as 'ITEM ID',category as 'CATEGORY',description as 'DESCRIPTION',agreedPrice as 'UNIT PRICE' from item where category like '%"+category+"%' and restrictedStatus=? ";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setBoolean(1, false);
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
    /**
     * This method is used to get all Applied(Not saved) requsitions by a particular user.
     */
    public ResultSet getRequisitionDetails(String Requsitioner) {

        ResultSet rs = null;
        try {
            String sql = "select concat('REQ00',RequisitionNo) as 'REQ.NO',AppliedDate as 'APPLIED DATE',RequiredDate as 'REQ.DATE',RequisitionStatus as 'STATUS' from purchaserequisition where Requisitioner=? and RequisitionStatus !=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1, Requsitioner);
            pst.setString(2, "Saved");

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
    
    /**
     * This method is used to get all requsitions that were saved by a particular user.
     */
    public ResultSet getSavedRequisitionDetails(String Requsitioner) {

        ResultSet rs = null;
        try {
            String sql = "select concat('REQ00',RequisitionNo) as 'REQ.NO',AppliedDate as 'APPLIED DATE',RequiredDate as 'REQ.DATE' from purchaserequisition where Requisitioner=? and RequisitionStatus=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setString(1, Requsitioner);
            pst.setString(2, "Saved");

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
    
    /**
     * This method is used to filter all requsitions where status is pending.
     */
    public ResultSet getPendingRequisitionDetails() {

        ResultSet rs = null;
        try {
            String sql = "select concat('REQ00',RequisitionNo) as 'REQ.NO',AppliedDate as 'APPLIED DATE',RequiredDate as 'REQ.DATE',Requisitioner as 'REQUISITIONER' from purchaserequisition where  RequisitionStatus=?";
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
    
    /**
     * This method is used to get details of a requsitionNo.
     */
    public ResultSet getSingleRequisitionDetail(int reqNo) {

        ResultSet rs = null;
        try {
            String sql = "select concat('REQ00',RequisitionNo) as 'REQ.NO',AppliedDate as 'APPLIED DATE',RequiredDate as 'REQ.DATE',Comment as 'COMMENT',RequisitionStatus as 'STATUS',TotalAmnt as 'TOTAL' from purchaserequisition where RequisitionNo=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, reqNo);

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
 
    /**
     * This method is used to get all the items belong to particular requisition.
     */
    public ResultSet getRequisitionItems(int reqNo) {

        ResultSet rs = null;
        try {
            String sql = "select * from requisitionitems where RequisitionNo=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, reqNo);

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
    
    /**
     * This method is used to Insert or create a requisition.
     */
    public boolean addPurchaseRequisition(PurchaseRequsitionModel prm) {

        String sql = "insert into purchaserequisition(AppliedDate,RequiredDate,Comment,RequisitionStatus,Requisitioner,TotalAmnt) values (?,?,?,?,?,?)";
        
        try {
            
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            java.sql.Date apply = new java.sql.Date(prm.getAppliedDate().getTime());
            java.sql.Date reqDate = new java.sql.Date(prm.getRequiredDate().getTime());
            System.out.println(apply + "    " + reqDate);

            pst.setDate(1, (java.sql.Date) apply);
            pst.setDate(2, (java.sql.Date) reqDate);
            pst.setString(3, prm.getComments());
            pst.setString(4, prm.getRequisitionStatus());
            pst.setString(5, prm.getRequisitioner());
            pst.setDouble(6, prm.getTotalAmount());

            pst.executeUpdate();
            
            ResultSet rs=pst.getGeneratedKeys();
            int requisitionId;
            if (rs.next()) {
                    requisitionId = rs.getInt(1);
                    prm.setRequisitionNo(requisitionId);
                }

        //    JOptionPane.showMessageDialog(null, "Successfully Added");
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }
    
    /**
     * This method is used to update a saved requisition.
     */
    public boolean updatePurchaseRequisition(PurchaseRequsitionModel prm) {

      String sql = "update purchaserequisition set AppliedDate=?,RequiredDate=?,Comment=?,RequisitionStatus=?,TotalAmnt=? where RequisitionNo=?";
       
        try {

            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
                      
            java.sql.Date apply = new java.sql.Date(prm.getAppliedDate().getTime());
            java.sql.Date reqDate = new java.sql.Date(prm.getRequiredDate().getTime());
            
            pst.setDate(1, (java.sql.Date) apply);
            pst.setDate(2, (java.sql.Date) reqDate);
            pst.setString(3, prm.getComments());
            pst.setString(4, prm.getRequisitionStatus());
            pst.setDouble(5, prm.getTotalAmount());
            pst.setInt(6, prm.getRequisitionNo());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully Added");
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }
    /**
     * This method is used to add all the items of a given requisition .
     */
    public boolean addRequisitionItems(PurchaseRequsitionModel prm) {

        // int executeUpdate = 0;
        int key;
        Set<Integer> keySet = prm.getItemWithQuantity().keySet();
        Iterator<Integer> keySetIterator = keySet.iterator();

        String sql = "insert into requisitionitems(RequisitionNo,ItemId,FinalPrice,OrderQuantity,Status) values (?,?,?,?,?)";
        try {

            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);

            while (keySetIterator.hasNext()) {

                key = keySetIterator.next();

                pst.setInt(1, prm.getRequisitionNo());
                pst.setInt(2, key);
                pst.setDouble(3, getItemPrice(key));
                pst.setDouble(4, prm.getItemWithQuantity().get(key));
                pst.setString(5, "Pending");
                pst.executeUpdate();
            }

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }
    
    /**
     * This method is used to add a single requisition item.
     */
    public boolean addSingleRequisitionItems(int itemId,PurchaseRequsitionModel prm) {

        String sql = "insert into requisitionitems(RequisitionNo,ItemId,FinalPrice,OrderQuantity,Status) values (?,?,?,?,?)";
        try {

            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);

            pst.setInt(1, prm.getRequisitionNo());
            pst.setInt(2, itemId);
            pst.setDouble(3, getItemPrice(itemId));
            pst.setDouble(4, prm.getItemWithQuantity().get(itemId));
            pst.setString(5, "Pending");
            pst.executeUpdate();

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }

    public double getItemPrice(int itemId) {

        double itemprice = 0;
        ResultSet rs;
        try {
            String sql = "select agreedPrice from item where itemId=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, itemId);

            rs = pst.executeQuery();
           
            if (rs.next()) {
               
                itemprice = rs.getDouble("agreedPrice");
            }
            return itemprice;

        } catch (SQLException e) {

            System.out.println(e);
            return itemprice;
        } catch (Exception e) {

            System.out.println(e);
            return itemprice;
        }

    }

    public boolean deleteRequisition(int requisitionNo) {

        try {

            String deleteStaff = "delete from purchaserequisition where RequisitionNo= ?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(deleteStaff);
            pst.setInt(1, requisitionNo);

            pst.execute();
            deleteRequisitionItems(requisitionNo);
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean UpdateRequisitionItems(PurchaseRequsitionModel prm) {

        // int executeUpdate = 0;
        ResultSet rs = null;
        int key;
        Set<Integer> keySet = prm.getItemWithQuantity().keySet();
        Iterator<Integer> keySetIterator = keySet.iterator();

        String sql1 = "select * from requisitionitems where RequisitionNo=? and ItemId=?";
        String sql2 = "update requisitionitems set FinalPrice=?,OrderQuantity=? where RequisitionNo=? and ItemId=? ";
        try {
            PreparedStatement pst1 = DBConn.myConn().prepareStatement(sql1);
            PreparedStatement pst2 = DBConn.myConn().prepareStatement(sql2);

            while (keySetIterator.hasNext()) {

                key = keySetIterator.next();

                pst1.setInt(1, prm.getRequisitionNo());
                pst1.setInt(2, key);
                rs = pst1.executeQuery();

                if (rs.next()) {

                    pst2.setInt(1, prm.getRequisitionNo());
                    pst2.setInt(2, key);
                    pst2.setDouble(3, getItemPrice(key));
                    pst2.setDouble(4, prm.getItemWithQuantity().get(key));
                    pst2.executeUpdate();
                } else {

                    addSingleRequisitionItems(key,prm);
                }

            }

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }
    
    public boolean UpdateRequisitionItemPrice(HashMap<Integer,Double> hs,int reqNo) {

        // int executeUpdate = 0;
        ResultSet rs = null;
        int key;
        Set<Integer> keySet = hs.keySet();
        Iterator<Integer> keySetIterator = keySet.iterator();

       
        String sql = "update requisitionitems set FinalPrice=? where RequisitionNo=? and ItemId=? ";
        try {
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            

            while (keySetIterator.hasNext()) {

                key = keySetIterator.next();

                pst.setDouble(1, hs.get(key));
                pst.setInt(2, reqNo);
                pst.setInt(3, key);               
                pst.executeUpdate();
              
                
            }

            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Adding Purchase Requisition");
            System.out.println(ex);

            return false;
        }
    }
    
    public void deleteSingleRequisitionItem(int requisitionNo,int itemId) {

        try {

            String sql = "delete from requisitionitems where RequisitionNo= ? and ItemId=?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, requisitionNo);
            pst.setInt(2, itemId);

            pst.execute();

        } catch (SQLException e) {

        } catch (Exception e) {

        }

    }

    public void deleteRequisitionItems(int requisitionNo) {

        try {

            String sql = "delete from requisitionitems where RequisitionNo= ?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, requisitionNo);

            pst.execute();

        } catch (SQLException e) {

        } catch (Exception e) {

        }

    }
    
    public boolean deleteDeliveredRequisition(int requisitionNo) {

        try {

            String sql = "delete from purchaseorder where RequisitionNo= ?";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            pst.setInt(1, requisitionNo);

            pst.execute();
            
            return true;
        } catch (SQLException e) {
            return false;
        } catch (Exception e) {
            return false;
        }

    }
    
    public boolean UpdateRequisitionStatus(String Status,int reqNo) {

        
        ResultSet rs = null;
       
       
        String sql = "update purchaserequisition set RequisitionStatus=? where RequisitionNo=?  ";
        try {
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
                      
                pst.setString(1, Status);
                pst.setInt(2, reqNo);             
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
