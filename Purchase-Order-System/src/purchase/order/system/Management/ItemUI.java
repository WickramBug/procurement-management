/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.Management;

import purchase.order.system.*;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;
import purchase.order.system.Public.DBConn;

/**
 *
 * @author User
 */
public class ItemUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form PurchaseRequsition
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public ItemUI() {
        initComponents();
        lblitemid.setText("");
        cmbsearchbyicategory.setSelectedIndex(0);
        txtareadescription.setText("");
        txtagreedprice.setText("");
        cmbrestrictedstatus.setSelectedIndex(0);

        txtsearchbyid.setText("");
        cmbsearchbyicategory.setSelectedIndex(0);

        conn = DBConn.myConn();
        tableload();
       
    }
    
     public boolean tableload() {

        try {
            String sql = "select concat('ITM',itemId) as 'Item ID',category as 'Category',description as 'Description',agreedPrice as 'Agreed Price',restrictedStatus as 'Restricted Status' from item";
            PreparedStatement pst = DBConn.myConn().prepareStatement(sql);
            rs = pst.executeQuery();
            tblitem.setModel(DbUtils.resultSetToTableModel(rs));
            //printStackTrace();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbrestrictedstatus = new javax.swing.JComboBox<>();
        btnclear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btninsert = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtsearchbyid = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btnfilterid1 = new javax.swing.JButton();
        lblitemid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbicategory = new javax.swing.JComboBox<>();
        cmbsearchbyicategory = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareadescription = new javax.swing.JTextArea();
        btnfiltercategory = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblitem = new javax.swing.JTable();
        txtagreedprice = new javax.swing.JTextField();

        setBorder(null);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(780, 575));

        jPanel4.setBackground(new java.awt.Color(95, 53, 174));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setBackground(new java.awt.Color(23, 2, 74));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(23, 2, 74));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel10MousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("ITEMS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 609, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        cmbrestrictedstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false" }));

        btnclear.setText("Clear All");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        jLabel11.setText("Restricted Status");

        btninsert.setText("+ Add Items");
        btninsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninsertMouseClicked(evt);
            }
        });
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });

        jLabel4.setText("Agreed Price");

        btnupdate.setText(" Update Items");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jLabel1.setText("Item ID");

        jLabel6.setText("Search By ID");

        jButton1.setText("< Back to Home");

        jLabel2.setText("Category");

        txtsearchbyid.setText("jTextField1");

        jLabel3.setText("Description");

        btnfilterid1.setText("Filter By ID");
        btnfilterid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterid1ActionPerformed(evt);
            }
        });

        lblitemid.setText("jLabel5");

        jLabel5.setText("Search By Category");

        cmbicategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --", "clay", "rocks", "sand", "bricks", "wood", "concrete blocks", "copper pipe", "other" }));

        cmbsearchbyicategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- select --", "clay", "rocks", "sand", "bricks", "wood", "concrete blocks", "copper pipe", "other" }));

        txtareadescription.setColumns(20);
        txtareadescription.setRows(5);
        jScrollPane1.setViewportView(txtareadescription);

        btnfiltercategory.setText("Filter By Category");
        btnfiltercategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltercategoryActionPerformed(evt);
            }
        });

        tblitem.setBackground(new java.awt.Color(153, 153, 153));
        tblitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblitem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblitemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblitem);

        txtagreedprice.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1)
                        .addGap(74, 74, 74)
                        .addComponent(lblitemid, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbicategory, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btninsert, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel4)
                        .addGap(49, 49, 49)
                        .addComponent(txtagreedprice, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel11)
                        .addGap(27, 27, 27)
                        .addComponent(cmbrestrictedstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel6)
                        .addGap(58, 58, 58)
                        .addComponent(txtsearchbyid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnfilterid1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(24, 24, 24)
                        .addComponent(cmbsearchbyicategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnfiltercategory, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(204, 204, 204)
                        .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblitemid))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbicategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btninsert, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtagreedprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11))
                    .addComponent(cmbrestrictedstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtsearchbyid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfilterid1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cmbsearchbyicategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfiltercategory)
                    .addComponent(btnclear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel10MousePressed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // TODO add your handling code here:
        txtsearchbyid.setText("");
        cmbsearchbyicategory.setSelectedIndex(0);
        tableload();
    }//GEN-LAST:event_btnclearActionPerformed

    private void btninsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninsertMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btninsertMouseClicked

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        // TODO add your handling code here:
        String category = cmbicategory.getSelectedItem().toString();
        String description = txtareadescription.getText();
        String agreedprice = txtagreedprice.getText();
        String restrictedStatus = cmbrestrictedstatus.getSelectedItem().toString();

//        if (cmbicategory.getSelectedItem() == "-- select --" || txtareadescription.getText().equalsIgnoreCase("") || txtagreedprice.getText().equalsIgnoreCase("")) {
//            JOptionPane.showMessageDialog(null, "Please fill the required fields", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        if (cmbicategory.getSelectedItem() == "-- select --" || txtareadescription.getText().equalsIgnoreCase("") ) {
            JOptionPane.showMessageDialog(null, "Please fill the required fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //price validation-------------------------------------------------------------------------------
        
        double num = 0.00;
   
        try {
            num = Double.parseDouble(agreedprice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "price should be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        if (num < 50.00 || num > 100000.00) {
//            JOptionPane.showMessageDialog(null, "Price should be between Rs50.00 - Rs100000.00", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        //        //...............................................................
        ItemModel im = new ItemModel(category, description, agreedprice, restrictedStatus);
        boolean successStatus = im.insertItem();
        if (successStatus) {
            JOptionPane.showMessageDialog(this, "Item added Successfully");
            tableload();
            lblitemid.setText("");
            cmbicategory.setSelectedIndex(0);
            txtareadescription.setText("");
            txtagreedprice.setText("");
            cmbrestrictedstatus.setSelectedIndex(0);

        } else {
            JOptionPane.showMessageDialog(this, "Error in inserting to db");
        }
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

        if (x == 0) {
            String itemid = lblitemid.getText();
            String category = cmbicategory.getSelectedItem().toString();
            String description = txtareadescription.getText();
            String agreedprice = txtagreedprice.getText();
            String restrictedStatus = cmbrestrictedstatus.getSelectedItem().toString();

            //Required field validation
            if (cmbicategory.getSelectedItem() == "-- select --" || txtareadescription.getText().equalsIgnoreCase("") || txtagreedprice.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Please fill the required fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ItemModel im = new ItemModel(itemid, category, description, agreedprice, restrictedStatus);
            boolean successStatus = im.updateItem();
            if (successStatus) {
                JOptionPane.showMessageDialog(this, "Successfully updated");
                tableload();
                lblitemid.setText("");
                cmbicategory.setSelectedIndex(0);
                txtareadescription.setText("");
                txtagreedprice.setText("");
                cmbrestrictedstatus.setSelectedIndex(0);

            } else {
                JOptionPane.showMessageDialog(this, "Error in updating");

            }

        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnfilterid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterid1ActionPerformed
        // TODO add your handling code here:

        String searchByID = txtsearchbyid.getText();
        //Field Validation
        if (txtsearchbyid.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Field is Empty ! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String n = "Select concat('ITM',itemId) as 'Item ID' ,category,description,agreedPrice,restrictedStatus from item where itemId like '%" + searchByID + "%'";

        try {
            pst = conn.prepareStatement(n);
            rs = pst.executeQuery();
            tblitem.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnfilterid1ActionPerformed

    private void btnfiltercategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltercategoryActionPerformed
        // TODO add your handling code here:
        String searchByCategory = cmbsearchbyicategory.getSelectedItem().toString();

        //Field Validation
        if (cmbsearchbyicategory.getSelectedItem() == "-- select --") {
            JOptionPane.showMessageDialog(null, "Field is not selected ! ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String n = "Select concat('ITM',itemId) as 'Item ID',category,description,agreedPrice,restrictedStatus from item where category like '%" + searchByCategory + "%'";

        try {
            pst = conn.prepareStatement(n);
            rs = pst.executeQuery();
            tblitem.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnfiltercategoryActionPerformed

    private void tblitemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblitemMouseClicked
        // TODO add your handling code here:
        int item = tblitem.getSelectedRow();
        String itemid = tblitem.getValueAt(item, 0).toString();
        String category = tblitem.getValueAt(item, 1).toString();
        String description = tblitem.getValueAt(item, 2).toString();
        String agreedprice = tblitem.getValueAt(item, 3).toString();
        String restrictedStatus = tblitem.getValueAt(item, 4).toString();

        lblitemid.setText(itemid);
        cmbicategory.setSelectedItem(category);
        txtareadescription.setText(description);
        txtagreedprice.setText(agreedprice);
        cmbrestrictedstatus.setSelectedItem(restrictedStatus);
    }//GEN-LAST:event_tblitemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnfiltercategory;
    private javax.swing.JButton btnfilterid1;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cmbicategory;
    private javax.swing.JComboBox<String> cmbrestrictedstatus;
    private javax.swing.JComboBox<String> cmbsearchbyicategory;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblitemid;
    private javax.swing.JTable tblitem;
    private javax.swing.JTextField txtagreedprice;
    private javax.swing.JTextArea txtareadescription;
    private javax.swing.JTextField txtsearchbyid;
    // End of variables declaration//GEN-END:variables
}
