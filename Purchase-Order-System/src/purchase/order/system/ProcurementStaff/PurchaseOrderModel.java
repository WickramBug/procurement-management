/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.ProcurementStaff;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import purchase.order.system.Public.DBConn;

/**
 *
 * @author User
 */
public class PurchaseOrderModel {
    
    private int PurchaseReference;
    private int RequisitionNo;
    private int SupplierId;
    private double OrderAmount;
    private String OrderStatus;
    private double deductions;
    private double discount;
    private double additions;
    private String deliveryAddress;

    public int getPurchaseReference() {
        return PurchaseReference;
    }

    public void setPurchaseReference(int PurchaseReference) {
        this.PurchaseReference = PurchaseReference;
    }

    public int getRequisitionNo() {
        return RequisitionNo;
    }

    public void setRequisitionNo(int RequisitionNo) {
        this.RequisitionNo = RequisitionNo;
    }

    

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(int SupplierId) {
        this.SupplierId = SupplierId;
    }

    
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAdditions() {
        return additions;
    }

    public void setAdditions(double additions) {
        this.additions = additions;
    }

    
    public double getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(double OrderAmount) {
        this.OrderAmount = OrderAmount;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }
    
    public String getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }
         
}
