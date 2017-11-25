/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase.order.system.SiteManager;

import com.sun.xml.internal.txw2.output.ResultFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import purchase.order.system.Public.ButtonRenderer;

/**
 *
 * @author User
 */
public class PurchaseRequsition extends javax.swing.JInternalFrame {

    /**
     * Creates new form PurchaseRequsition
     */
    private DefaultTableModel table;
    private PurchaseRequsitionModel prm;
    private PurchaseRequisitionController prc;
    private HashMap<Integer, Double> requisitionMap;
    private String user;
    private int reqNo;
    private SiteManagerHome home;
    private String status;
    private Set<Integer> keySet;
    private Iterator<Integer> keySetIterator;
    private ResultSet rs;
    ResultSet requisition;
    ResultSet requisitionItems;
    ResultSet itemsDetails;

    public PurchaseRequsition() {
        initComponents();    
    }

    public PurchaseRequsition(String user, SiteManagerHome home) {
        initComponents();
        this.status="Add";
        this.user = user;
        this.home = home;
        table = (DefaultTableModel) tableRequsition.getModel();
        prm = new PurchaseRequsitionModel();
        prc = new PurchaseRequisitionController();
        requisitionMap = new HashMap<>();
        
        setDateLabelText();
        tableRequsition.getColumn("Remove").setCellRenderer(new ButtonRenderer("Remove"));
        setTableHeaderColor();
        
    }
    
    /**
     * This method is used set the current date to a label.
     */
    public void setDateLabelText() {

        Date d = new Date();
        String date = d.toString();
        String ar[] = date.split(" ");
        String newdate = ar[5] + "/" + ar[1] + "/" + ar[2];
        lblDate.setText(newdate);
    }

    /**
     * This method is used to check whether an item is already added in a requisition.
     */
    public boolean checkItemExist(HashMap<Integer, Double> hs) {

        boolean isItemExist = false;
        keySet = hs.keySet();
        keySetIterator = keySet.iterator();
        int key;
        while (keySetIterator.hasNext()) {

            key = keySetIterator.next();

            try {
                if (requisitionMap.containsKey(key)) {
                   
                    JOptionPane.showMessageDialog(null, key + " " + "is already added as Items");
                    isItemExist = true;
                }

            } catch (Exception ex) {

                System.out.println(ex);
            }

        }
        return isItemExist;
    }
    
    /**
     * This method is used to fill the table with the selected items.
     */
    public void setItems(HashMap<Integer, Double> hs) {

        keySet = hs.keySet();
        keySetIterator = keySet.iterator();
        int key;
        double quantity, price = 0.0, unitTotal = 0.0, totalAmnt = 0;
        while (keySetIterator.hasNext()) {

            key = keySetIterator.next();

            try {

                rs = prc.getItem(key);
                quantity = hs.get(key);
                requisitionMap.put(key, quantity);
                while (rs.next()) {
                    price = rs.getDouble("UNIT PRICE");
                    unitTotal = quantity * price;
                    totalAmnt += unitTotal;
                    lblTotal.setText(Double.toString(totalAmnt));
                    table.addRow(new Object[]{"ITM"+key, rs.getString("DESCRIPTION"), quantity, Double.toString(price), Double.toString(unitTotal)});

                }
            } catch (SQLException ex) {

                System.out.println(ex);

            } catch (Exception ex) {

                System.out.println(ex);
            }

        }
        
        calcTotal();
    }

    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * This method is used to change column colour.
     */
    private void setTableHeaderColor() {

        JTableHeader th = tableRequsition.getTableHeader();

        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc1 = tcm.getColumn(0);
        TableColumn tc2 = tcm.getColumn(1);
        TableColumn tc3 = tcm.getColumn(2);
        TableColumn tc4 = tcm.getColumn(3);
        TableColumn tc5 = tcm.getColumn(4);
        TableColumn tc6 = tcm.getColumn(5);

        tc1.setHeaderRenderer(new headerCellRenderer());
        tc2.setHeaderRenderer(new headerCellRenderer());
        tc3.setHeaderRenderer(new headerCellRenderer());
        tc4.setHeaderRenderer(new headerCellRenderer());
        tc5.setHeaderRenderer(new headerCellRenderer());
        tc6.setHeaderRenderer(new headerCellRenderer());
    }

    class headerCellRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, 0, 3);
            c.setBackground(new Color(47, 6, 152));
            c.setForeground(Color.white);

            return c;
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

        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblrequiredDate = new org.jdesktop.swingx.JXDatePicker();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSend = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRequsition = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblReqNo = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBorder(null);
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(780, 575));

        jPanel1.setPreferredSize(new java.awt.Dimension(777, 558));

        jPanel2.setBackground(new java.awt.Color(95, 53, 174));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("PURCHASE REQUSITION");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(302, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("TOTAL");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotal.setText("0.00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        txtComments.setColumns(20);
        txtComments.setRows(5);
        jScrollPane2.setViewportView(txtComments);

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Comments or Special Instructions");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(95, 53, 174));
        jLabel8.setText("PURCHASE REQUSITION");

        btnSend.setBackground(new java.awt.Color(248, 5, 5));
        btnSend.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSend.setText("APPLY");
        btnSend.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tableRequsition.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tableRequsition.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableRequsition.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM ID", "DESCRIPTION", "QTY", "UNIT PRICE", "TOTAL", "Remove"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableRequsition.setGridColor(new java.awt.Color(0, 0, 0));
        tableRequsition.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tableRequsition.setRowHeight(25);
        tableRequsition.setSelectionBackground(new java.awt.Color(95, 53, 174));
        tableRequsition.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRequsitionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRequsition);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(252, 4, 4));
        jButton1.setText("+ Add Items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("DATE");

        btnSave.setBackground(new java.awt.Color(248, 5, 5));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblReqNo.setBackground(new java.awt.Color(102, 102, 102));
        lblReqNo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblReqNo.setForeground(new java.awt.Color(95, 53, 174));

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblDate.setText("jLabel2");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("REQUIRED DATE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(184, 184, 184)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblrequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(lblReqNo, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblReqNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDate)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(lblrequiredDate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Additem ad = new Additem(this);
        ad.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableRequsitionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRequsitionMouseClicked
        // TODO add your handling code here:
        int row = tableRequsition.rowAtPoint(evt.getPoint());
        int col = tableRequsition.columnAtPoint(evt.getPoint());

        if (col == 5) {
            int response = JOptionPane.showConfirmDialog(null, "Do you really want to Delete the selected Item?");
            if (response == 0) {
                reduceTotal(Double.parseDouble(table.getValueAt(row, 4).toString()));
                 requisitionMap.remove(Integer.parseInt(table.getValueAt(row, 0).toString().substring(3)));
                if(this.status.equals("Update")){
                   
                    prc.deleteSingleRequisitionItem(Integer.parseInt(lblReqNo.getText().substring(5)),Integer.parseInt(table.getValueAt(row, 0).toString().substring(3)));
                }
                table.removeRow(row);
            }
        }
    }//GEN-LAST:event_tableRequsitionMouseClicked

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        calcTotal();
         ValidateRequisition vr=new ValidateRequisition();
         if(tableRequsition.getRowCount()<1){
             JOptionPane.showMessageDialog(null, "No Items to Add");
             return;
         }else if(lblrequiredDate.getDate()==null){
             JOptionPane.showMessageDialog(null, "Please Specify a Required date for the Order");
             return;
         }else if(!vr.validateRequiredDate(lblrequiredDate.getDate())){
             JOptionPane.showMessageDialog(null, "Please Specify a Required date for the Order");
             return;
         }else {
             setPurchaseModel("Pending", this.status);
         }
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        calcTotal();
        if(tableRequsition.getRowCount()<1){
             JOptionPane.showMessageDialog(null, "No Items to Add");
             return;
         }else if(lblrequiredDate.getDate()==null){
             JOptionPane.showMessageDialog(null, "Please Specify a Required date for the Order");
             return;
         }else{
             setPurchaseModel("Saved", this.status);
         }
    }//GEN-LAST:event_btnSaveActionPerformed
   
    /**
     * This method is used to create a purchase model and assign values to its fields.
     */
    private void setPurchaseModel(String status, String updateStatus) {

        prm.setAppliedDate(new Date());
     //   prm.setRequisitionNo("REQ003");
        prm.setRequiredDate(lblrequiredDate.getDate());
        prm.setComments(txtComments.getText());
        prm.setRequisitioner(this.user);
        prm.setRequisitionStatus(status);
        prm.setItemWithQuantity(requisitionMap);
        prm.setTotalAmount(Double.parseDouble(lblTotal.getText()));
        if (updateStatus.equals("Add")) {
            System.out.println("Going to Add");
            addRequisition();

        } else {
            System.out.println("Going to Update");
            updateRequisition();
            this.status = "Add";
        }

    }

    /**
     * This method is used to add a purchase requisition.
     */
    private void addRequisition() {

        if ((prc.addPurchaseRequisition(prm)) && (prc.addRequisitionItems(prm))) {

            this.hide();
         //   home.pr = new PurchaseRequsition();
            home.resetPurchaseRequisition();
            if (prm.getRequisitionStatus().equals("Pending")) {

                home.vr.requsitionTableLoad();
                home.viewRequsitions();

            } else {
                home.vs.savedRequsitionTableLoad();
                home.viewSavedRequsitions();
            }

        }
    }

    /**
     * This method is used to update a saved purchase requisitioin.
     */
    private void updateRequisition() {
        
        prm.setRequisitionNo(Integer.parseInt(lblReqNo.getText().substring(5)));
        if ((prc.updatePurchaseRequisition(prm)) && (prc.UpdateRequisitionItems(prm))) {

            this.hide();
          //  home.pr = new PurchaseRequsition();
            home.resetPurchaseRequisition();
            if (prm.getRequisitionStatus().equals("Pending")) {

                home.vr.requsitionTableLoad();
                home.vs.savedRequsitionTableLoad();
                home.viewRequsitions();

            } else {
                home.vr.requsitionTableLoad();
                home.vs.savedRequsitionTableLoad();
                home.viewSavedRequsitions();
            }

        }

    }
    /**
     * This method is used set the details of a selected requisition in a form.
     */
    public void setRequisitionData(int reqNo) {
        
        lblReqNo.setText("REQ00"+reqNo);
        prm=new PurchaseRequsitionModel();
        prm.setRequisitionNo(reqNo);
        prc = new PurchaseRequisitionController();
        requisition = prc.getSingleRequisitionDetail(reqNo);

        try {
            if (requisition.next()) {
                //     lblReqNo.setText(reqNo);
                lblDate.setText(requisition.getString("APPLIED DATE"));
                lblrequiredDate.setDate(setRequiredDate(requisition.getString("REQ.DATE")));
                txtComments.setText(requisition.getString("COMMENT"));
                lblTotal.setText(Double.toString(requisition.getDouble("TOTAL")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ViewSingleRequisition.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            System.out.println(ex);
            Logger.getLogger(ViewSingleRequisition.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void calcTotal(){
        
        
        double total=0;
        
        for(int i=0;i<tableRequsition.getRowCount();i++){
            
            total+=Double.parseDouble(tableRequsition.getValueAt(i, 4).toString());
            
        }
        lblTotal.setText(Double.toString(total));
    }
    
    private Date setRequiredDate(String date){
        
        SimpleDateFormat df = new SimpleDateFormat("EEEE dd/MM/yyyy");
        Date date1 = null;

        try {
            date1 = df.parse(df.format(date));
            
        }catch(Exception ex){
                
        }
        return date1;
    }
    /**
     * This method is used to fill the table with Item details.
     */
    public void FillTable(int reqNo) {

        prc = new PurchaseRequisitionController();
        requisitionItems = prc.getRequisitionItems(reqNo);

        int itemId;
        double quantity, price = 0.0, unitTotal = 0.0, totalAmnt = 0;

        try {

            while (requisitionItems.next()) {

                itemId = requisitionItems.getInt("ItemId");
                itemsDetails = prc.getItem(itemId);
                quantity = requisitionItems.getDouble("OrderQuantity");

                if (itemsDetails.next()) {
                    requisitionMap.put(itemId, quantity);
                    price = itemsDetails.getDouble("UNIT PRICE");
                    table.addRow(new Object[]{itemsDetails.getString("ITEM ID"), itemsDetails.getString("DESCRIPTION"), quantity, price, (price * quantity)});
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex);
            
        } catch (Exception ex) {

            System.out.println(ex);

        }

    }

    private void reduceTotal(double amount) {

        double total = Double.parseDouble(lblTotal.getText());
        lblTotal.setText(Double.toString(total - amount));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblReqNo;
    private javax.swing.JLabel lblTotal;
    private org.jdesktop.swingx.JXDatePicker lblrequiredDate;
    private javax.swing.JTable tableRequsition;
    private javax.swing.JTextArea txtComments;
    // End of variables declaration//GEN-END:variables
}
