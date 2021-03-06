/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import purchase.order.system.Public.FrameDrag;

/**
 *
 * @author User
 */
public class Additem extends javax.swing.JFrame {

    /**
     * Creates new form AdditemFrame
     */
    private HashMap<Integer, Double> items;
    private PurchaseRequsition pr;
    private PurchaseRequsitionModel prm;
    private PurchaseRequisitionController prc;
    private DefaultTableModel tableRequestedItems;
    private FrameDrag frameDragListener;

    private ResultSet rs = null;

    public Additem() {
        initComponents();
        frameDragListener = new FrameDrag(this);
        frameDragListener.mouseDrag();

        items = new HashMap<>();
        this.pr = pr;
        prm = new PurchaseRequsitionModel();
        prc = new PurchaseRequisitionController();
        tableRequestedItems = (DefaultTableModel) tblRequestedItems.getModel();

        itemTableLoad();
        setColumnWidth();
        tblRequestedItems.setSelectionMode(NORMAL);
    }

    public Additem(PurchaseRequsition pr) {
        initComponents();
        frameDragListener = new FrameDrag(this);
        frameDragListener.mouseDrag();

        items = new HashMap<>();
        this.pr = pr;
        prm = new PurchaseRequsitionModel();
        prc = new PurchaseRequisitionController();
        tableRequestedItems = (DefaultTableModel) tblRequestedItems.getModel();

        itemTableLoad();
        setColumnWidth();
        tblRequestedItems.setSelectionMode(NORMAL);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtItem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableItems = new javax.swing.JTable();
        btnAddList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnRemoveList = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRequestedItems = new javax.swing.JTable();
        btnAddItems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(95, 53, 174));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("ADD  ITEMS");

        jLabel9.setBackground(new java.awt.Color(23, 2, 74));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(23, 2, 74));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 523, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 341));

        txtItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtItemKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtItemKeyTyped(evt);
            }
        });

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(500, 400));

        tableItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tableItems.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "CATEGORY", "DESCRIPTION", "UNIT PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableItems.setGridColor(new java.awt.Color(0, 0, 0));
        tableItems.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableItems.setPreferredSize(new java.awt.Dimension(550, 175));
        tableItems.setRowHeight(25);
        tableItems.setSelectionBackground(new java.awt.Color(95, 53, 174));
        jScrollPane2.setViewportView(tableItems);

        btnAddList.setBackground(new java.awt.Color(95, 53, 174));
        btnAddList.setText("Add To List");
        btnAddList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddListActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel1.setText("CATEGORY");

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("SEARCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnAddList))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRemoveList.setBackground(new java.awt.Color(95, 53, 174));
        btnRemoveList.setText("Remove From List");
        btnRemoveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveListActionPerformed(evt);
            }
        });

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblRequestedItems.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tblRequestedItems.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblRequestedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblRequestedItems.setGridColor(new java.awt.Color(0, 0, 0));
        tblRequestedItems.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblRequestedItems.setRowHeight(25);
        tblRequestedItems.setSelectionBackground(new java.awt.Color(95, 53, 174));
        jScrollPane3.setViewportView(tblRequestedItems);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnRemoveList))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveList)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAddItems.setBackground(new java.awt.Color(248, 5, 5));
        btnAddItems.setText("Add Items");
        btnAddItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddItems)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddItems)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setColumnWidth() {

        tableItems.getColumnModel().getColumn(0).setPreferredWidth(20);
        tableItems.getColumnModel().getColumn(1).setPreferredWidth(100);
        tableItems.getColumnModel().getColumn(2).setPreferredWidth(185);
        tableItems.getColumnModel().getColumn(3).setPreferredWidth(25);
    }
    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel9MousePressed

    private void btnAddListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddListActionPerformed
        // TODO add your handling code here:

        getSelectedRows();
    }//GEN-LAST:event_btnAddListActionPerformed

    private void btnRemoveListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveListActionPerformed
        // TODO add your handling code here:
        removeSelectedRows();

    }//GEN-LAST:event_btnRemoveListActionPerformed

    private void btnAddItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemsActionPerformed
        // TODO add your handling code here:
        //  System.out.println(jTable2.getValueAt(i, 1).toString().length());
        if (addItems()) {
            if (!this.pr.checkItemExist(items)) {
                this.pr.setItems(items);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnAddItemsActionPerformed

    private void searchItems(){
        
        try{                  
            rs=prc.getItemDetailsByCategory(txtItem.getText());                          
            tableItems.setModel(DbUtils.resultSetToTableModel(rs));                               
        }
        catch(NumberFormatException | HeadlessException ex){
            
            System.out.println(ex);
            
        }        
        catch(Exception ex){
            
            System.out.println(ex);
            
        }
        
    }
    private void txtItemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemKeyTyped
        // TODO add your handling code here:
         searchItems();
    }//GEN-LAST:event_txtItemKeyTyped

    private void txtItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtItemKeyPressed
    
    /**
     * This method is used to fill the table with all the Non Restricted Item details.
     */
    private void itemTableLoad() {

        rs = prc.getItemDetails();
        tableItems.setModel(DbUtils.resultSetToTableModel(rs));

    }

    /**
     * This method is used to add selected items to the requisition.
     */
    private boolean addItems() {

        double quantity;
        int id = 0;
        for (int i = 0; i < tblRequestedItems.getRowCount(); i++) {

            try {
                id = Integer.parseInt(tblRequestedItems.getValueAt(i, 0).toString().substring(3));
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                return false;
            }

            if (tblRequestedItems.getValueAt(i, 1).toString().trim().length() > 0) {
                try {

                    quantity = Double.parseDouble(tblRequestedItems.getValueAt(i, 1).toString());
                    items.put(id, quantity);

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(null, " Please Insert a valid quantity for Item" + id);
                    items.clear();
                    return false;
                } catch (NullPointerException ex) {

                    JOptionPane.showMessageDialog(null, " Please Insert a quantity for Item" + id);
                    items.clear();
                    return false;
                }
            } else {
                //  System.out.println(jTable2.getValueAt(i, 1).toString().trim().length());
                JOptionPane.showMessageDialog(null, " Please Insert a quantity for Item" + id);
                items.clear();
                return false;
            }
        }

        return true;
    }

    /**
     * This method is used to get add selected items to the item required table.
     */
    private void getSelectedRows() {
        int id;
        if (tableItems.getRowCount() > 0) {
            if (tableItems.getSelectedRowCount() > 0) {
                int selectedRow[] = tableItems.getSelectedRows();
                for (int i : selectedRow) {
                    try {
                        id = Integer.parseInt(tableItems.getValueAt(i, 0).toString().substring(3));
                    } catch (NumberFormatException ex) {
                        System.out.println(ex);
                            return;
                    }
                    if (addtoHashMap(id)) {
                        tableRequestedItems.addRow(new Object[]{"ITM"+id, " "});
                    }
                }
            }

        }
    }

    public boolean isNumber(String str) {

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {

            return false;
        }

    }

    private void removeSelectedRows() {

        if (tblRequestedItems.getRowCount() > 0) {

            int response = JOptionPane.showConfirmDialog(null, "Do you really want to Remove the selected Items?");
            if (response == 0) {
                int selectedRow = tblRequestedItems.getSelectedRow();

                try {
                    items.remove(Integer.parseInt(tblRequestedItems.getValueAt(selectedRow, 0).toString().substring(3)));
                } catch (NumberFormatException ex) {
                    System.out.println(ex);
                    return;
                }
                tableRequestedItems.removeRow(selectedRow);

            }

        }
    }
    /**
     * This method is used to add the itemID and quantity in to a HashMap.
     */
    private boolean addtoHashMap(int id) {

        if (items.containsKey(id)) {
            JOptionPane.showMessageDialog(null, id + " " + " Is already Added");
            return false;
        } else {
            items.put(id, Double.NaN);
            return true;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Additem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Additem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Additem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Additem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Additem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItems;
    private javax.swing.JButton btnAddList;
    private javax.swing.JButton btnRemoveList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableItems;
    private javax.swing.JTable tblRequestedItems;
    private javax.swing.JTextField txtItem;
    // End of variables declaration//GEN-END:variables
}
