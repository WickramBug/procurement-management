/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import purchase.order.system.Public.DBConn;

/**
 *
 * @author User
 */
public class PurchaseRequsitionModel {

    private int requisitionNo;
    private Date appliedDate;
    private Date requiredDate;
    private String comments;
    private String RequisitionStatus;
    private String Requisitioner;
    private double totalAmount;
    private HashMap<Integer, Double> itemWithQuantity = new HashMap<>();

    public int getRequisitionNo() {
        return requisitionNo;
    }

    public void setRequisitionNo(int requisitionNo) {
        this.requisitionNo = requisitionNo;
    }

    public String getRequisitionStatus() {
        return RequisitionStatus;
    }

    public void setRequisitionStatus(String RequisitionStatus) {
        this.RequisitionStatus = RequisitionStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRequisitioner() {
        return Requisitioner;
    }

    public void setRequisitioner(String Requisitioner) {
        this.Requisitioner = Requisitioner;
    }

   
    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public HashMap<Integer, Double> getItemWithQuantity() {
        return itemWithQuantity;
    }

    public void setItemWithQuantity(HashMap<Integer, Double> itemWithQuantity) {
        this.itemWithQuantity = itemWithQuantity;
    }

    public void addItem(int itemid, double quantity) {

        itemWithQuantity.put(itemid, quantity);
    }

    

}
