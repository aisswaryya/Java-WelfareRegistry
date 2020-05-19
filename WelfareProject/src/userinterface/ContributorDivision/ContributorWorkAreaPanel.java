/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ContributorDivision;

import com.mongodb.DB; 
import com.mongodb.MongoClient; 
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import Business.WelfareDepartment.BeneficiaryDirectory;
import Business.WelfareDepartment.ContributionDirectory;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.Font;
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sindhu
 */
public class ContributorWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form ContributorWorkAreaPanel
     */
 
  
    JPanel userProcessContainer;
    ContributionDirectory contDetails;
    BeneficiaryDirectory benDetails;
    String updateStatus=null;
    String cont_id=null;
     enum status{
      Assigned,
      Available,
      NA
    }
   
  
    public ContributorWorkAreaPanel(JPanel userProcessContainer) {
       initComponents();
        this.userProcessContainer = userProcessContainer;
        contDetails = new ContributionDirectory();
        benDetails=new  BeneficiaryDirectory();
        contTable.getTableHeader().setFont(new Font("TImes New Roman",Font.BOLD,18));
        contTable.setRowHeight(30);
        contTable.setRowMargin(10);
        populateTable();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        contTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        contName = new javax.swing.JTextField();
        endLabel = new javax.swing.JLabel();
        endowmentItem = new javax.swing.JComboBox<>();
        foodLabel = new javax.swing.JLabel();
        contField = new javax.swing.JTextField();
        addContBtn = new javax.swing.JButton();
        assignBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        contEmail = new javax.swing.JTextField();
        imgLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Add Contribution Details");
        add(jLabel1);
        jLabel1.setBounds(630, 140, 250, 28);

        contTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        contTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cont Id", "Contributor Name", "Endwoment Type", "Contribution", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(contTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(390, 190, 690, 120);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Contributor Name :");
        add(jLabel2);
        jLabel2.setBounds(510, 340, 160, 22);

        contName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        contName.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        add(contName);
        contName.setBounds(680, 340, 140, 30);

        endLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        endLabel.setText("Endowment Type :");
        add(endLabel);
        endLabel.setBounds(520, 450, 150, 22);

        endowmentItem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        endowmentItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fund", "Food", "Employment" }));
        endowmentItem.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        endowmentItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endowmentItemActionPerformed(evt);
            }
        });
        add(endowmentItem);
        endowmentItem.setBounds(680, 450, 140, 30);

        foodLabel.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        foodLabel.setText("      Contribution :");
        add(foodLabel);
        foodLabel.setBounds(520, 500, 150, 22);

        contField.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        contField.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        add(contField);
        contField.setBounds(680, 500, 140, 30);

        addContBtn.setBackground(new java.awt.Color(153, 102, 0));
        addContBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        addContBtn.setText("Add");
        addContBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContBtnActionPerformed(evt);
            }
        });
        add(addContBtn);
        addContBtn.setBounds(500, 600, 65, 40);

        assignBtn.setBackground(new java.awt.Color(153, 102, 0));
        assignBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        assignBtn.setText("Assign to a benificiary");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });
        add(assignBtn);
        assignBtn.setBounds(710, 600, 220, 40);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Contributor Email:");
        add(jLabel5);
        jLabel5.setBounds(515, 390, 149, 22);

        contEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        contEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 153)));
        add(contEmail);
        contEmail.setBounds(680, 392, 140, 30);

        imgLabel.setBackground(new java.awt.Color(255, 255, 255));
        add(imgLabel);
        imgLabel.setBounds(10, -40, 2480, 990);
    }// </editor-fold>//GEN-END:initComponents

    private void addContBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) contTable.getModel();
        String cont_name = contName.getText();
        String cont_email = contEmail.getText();
        String cont_type = endowmentItem.getSelectedItem().toString();
        String contribution = contField.getText();
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("ContributorDetails");
        int count = (int)userCollection.count();
        BasicDBObject bO = new BasicDBObject();
        bO.put("_id", "C00"+count);
	bO.put("Name", cont_name);
        bO.put("Email", cont_email);
        bO.put("Type", cont_type);
        bO.put("Contribution", contribution);
        bO.put("Status",status.Available.toString());
        userCollection.insert(bO);
        JOptionPane.showMessageDialog(null, "Contribution Details Added Successfully");
        populateTable();
    }//GEN-LAST:event_addContBtnActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)contTable.getModel();
        int selectedRow = contTable.getSelectedRow();
        String ben_id =null;
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("BeneficiaryDetails");
        BasicDBObject queryObj = new BasicDBObject();

        if(selectedRow <0 ){
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning!",JOptionPane.WARNING_MESSAGE);
        }
        else{
            String assType = (String) contTable.getValueAt(selectedRow,2);
            String availability = (String) contTable.getValueAt(selectedRow,4);
            if(availability.equals(status.NA)){
                JOptionPane.showMessageDialog(null,"This resource is not available to assign.Please select available resources", "Error",JOptionPane.ERROR_MESSAGE);
            }else{
                cont_id = contTable.getValueAt(selectedRow,0).toString();
                ben_id = getFirstBeneficiary(assType);
                queryObj.put("_id", ben_id);
                if(ben_id==null){
                    JOptionPane.showMessageDialog(null,"No more Beneficiary seeking for help from this enterprise", "Error",JOptionPane.ERROR_MESSAGE);
                    assignBtn.setEnabled(false);
                }else{
                    if(assignBtn.isEnabled()==false){
                        assignBtn.setEnabled(true);
                    }
                    BasicDBObject newObj = new BasicDBObject();
                    newObj.put("$set", new BasicDBObject().append("Status", status.Assigned.toString()));
                    userCollection.update(queryObj, newObj);
                    updateStatus = status.NA.toString();
                    updateStatus(updateStatus,cont_id);
                    populateTable();
                   JOptionPane.showMessageDialog(null, "Assigned required assistance to next available beneficiary", "Success",JOptionPane.PLAIN_MESSAGE);

                }
            }

        }
        
        
    }//GEN-LAST:event_assignBtnActionPerformed
    private String getFirstBeneficiary(String assType){
        String ben_id=null;
         TreeMap<String,String> benList = new TreeMap<String,String>();
         for(BeneficiaryDirectory ben:benDetails.getDetails()){
             if(ben.getAss_type().equals(assType)){
                benList.put(ben.getBen_id(),ben.getBen_status());
             }                           
        }
                          
         ArrayList<String> keyList = new ArrayList<String>(benList.keySet());
         if(keyList.size()>0){
            ben_id = keyList.get(0);
         }
        return ben_id;
    }
    private void endowmentItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endowmentItemActionPerformed
        // TODO add your handling code here:
        String endType = endowmentItem.getSelectedItem().toString();
        if(endType.equals("Food")){
            foodLabel.setVisible(false);
            contField.setVisible(false);
        }else{
            foodLabel.setVisible(true);
            contField.setVisible(true);
        }
    }//GEN-LAST:event_endowmentItemActionPerformed
    private void updateStatus(String updateStatus,String cont_id){
        MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("ContributorDetails"); 
        BasicDBObject queryObj = new BasicDBObject();
        queryObj.put("_id", cont_id);
         BasicDBObject newObj = new BasicDBObject();
         newObj.put("$set", new BasicDBObject().append("Status", updateStatus));
         userCollection.update(queryObj, newObj);
    }
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) contTable.getModel(); 
         MongoClient mongoClient = new MongoClient("localhost", 27017); 
        DB db = mongoClient.getDB("TestDB");
        DBCollection userCollection = db.getCollection("ContributorDetails");
        DBCursor cursor = null;
        cursor = userCollection.find();
        model.setRowCount(0);
        while(cursor.hasNext()){
            Object[] row = new Object[model.getColumnCount()];
            DBObject obj = cursor.next();
            row[0] = obj.get("_id");
            row[1] = obj.get("Name");
            row[2] = obj.get("Type");
            row[3] = obj.get("Contribution");
            row[4] = obj.get("Status");
            model.addRow(row);
        }
       
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addContBtn;
    private javax.swing.JButton assignBtn;
    private javax.swing.JTextField contEmail;
    private javax.swing.JTextField contField;
    private javax.swing.JTextField contName;
    private javax.swing.JTable contTable;
    private javax.swing.JLabel endLabel;
    private javax.swing.JComboBox<String> endowmentItem;
    private javax.swing.JLabel foodLabel;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
