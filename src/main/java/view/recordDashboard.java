/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.recordDashboardController;
import model.connectionController;
import control.errorMessages;
/**
 * //CHECK UPDATE BUTTON IF ALREADY EXIST
 * @author LordD
 */
public class recordDashboard extends javax.swing.JFrame {
    // TODO :: DO THE MAX(sectionid) where courseid
    /**
     * Creates new form adminDashboard
     */
    public recordDashboard() {
        initComponents();
        recordDashboardController adminDController = new recordDashboardController();
        connectionController conn = new connectionController();
        // CONNECT TO DATABASE
        conn.DBconnect();
        
        adminDController.updateRecordTable(recordTable);
        adminDController.updateCoursebox(courseCBox);
//        updateSectionbox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        Background = new javax.swing.JPanel();
        recordScrollTable = new javax.swing.JScrollPane();
        recordTable = new javax.swing.JTable();
        DetailPanel = new javax.swing.JPanel();
        addBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        updateBTN = new javax.swing.JButton();
        clearBTN = new javax.swing.JButton();
        sectionCBox = new javax.swing.JComboBox<>();
        idTField = new javax.swing.JTextField();
        firstnameTField = new javax.swing.JTextField();
        courseCBox = new javax.swing.JComboBox<>();
        insertNameLabel = new javax.swing.JLabel();
        insertIdLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        lastnameTField = new javax.swing.JTextField();
        lastnameLabel = new javax.swing.JLabel();
        studentRecordTitle = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        leftBTN = new javax.swing.JButton();
        rightBTN = new javax.swing.JButton();
        selectionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(49, 79, 186));

        recordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "STUDENT ID", "FIRSTNAME", "LASTNAME", "SECTION", "COURSE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        recordTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recordTableMouseClicked(evt);
            }
        });
        recordScrollTable.setViewportView(recordTable);

        DetailPanel.setBackground(new java.awt.Color(49, 79, 186));
        DetailPanel.setForeground(new java.awt.Color(255, 255, 255));

        addBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBTN.setText("ADD");
        addBTN.setMaximumSize(new java.awt.Dimension(75, 23));
        addBTN.setMinimumSize(new java.awt.Dimension(75, 23));
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        deleteBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBTN.setText("DELETE");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        updateBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        updateBTN.setText("UPDATE");
        updateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTNActionPerformed(evt);
            }
        });

        clearBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearBTN.setText("CLEAR");
        clearBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearForm(evt);
            }
        });

        sectionCBox.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N

        courseCBox.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        courseCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCBoxActionPerformed(evt);
            }
        });

        insertNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        insertNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertNameLabel.setText("Insert First Name:");

        insertIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        insertIdLabel.setForeground(new java.awt.Color(255, 255, 255));
        insertIdLabel.setText("Insert ID:");

        sectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        sectionLabel.setText("SECTION");

        courseLabel.setForeground(new java.awt.Color(255, 255, 255));
        courseLabel.setText("COURSE");

        lastnameTField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameTFieldActionPerformed(evt);
            }
        });

        lastnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lastnameLabel.setForeground(new java.awt.Color(255, 255, 255));
        lastnameLabel.setText("Insert Last Name:");

        studentRecordTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        studentRecordTitle.setForeground(new java.awt.Color(255, 255, 255));
        studentRecordTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentRecordTitle.setText("STUDENT RECORD");

        javax.swing.GroupLayout DetailPanelLayout = new javax.swing.GroupLayout(DetailPanel);
        DetailPanel.setLayout(DetailPanelLayout);
        DetailPanelLayout.setHorizontalGroup(
            DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DetailPanelLayout.createSequentialGroup()
                        .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DetailPanelLayout.createSequentialGroup()
                                .addComponent(sectionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(courseLabel)
                                .addGap(28, 28, 28))
                            .addComponent(lastnameTField)
                            .addComponent(idTField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstnameTField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DetailPanelLayout.createSequentialGroup()
                                .addComponent(sectionCBox, 0, 79, Short.MAX_VALUE)
                                .addGap(86, 86, 86)
                                .addComponent(courseCBox, 0, 79, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DetailPanelLayout.createSequentialGroup()
                                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lastnameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(insertIdLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(insertNameLabel, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(DetailPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clearBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))))
            .addGroup(DetailPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(studentRecordTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DetailPanelLayout.setVerticalGroup(
            DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentRecordTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstnameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastnameTField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionLabel)
                    .addComponent(courseLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectionCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBTN))
                .addGap(18, 18, 18)
                .addGroup(DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBTN)
                    .addComponent(clearBTN))
                .addGap(47, 47, 47))
        );

        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search:");

        leftBTN.setText("<");
        leftBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftBTNActionPerformed(evt);
            }
        });

        rightBTN.setText(">");
        rightBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightBTNActionPerformed(evt);
            }
        });

        selectionLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selectionLabel.setText("STUDENT RECORD");

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchBar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leftBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(recordScrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, BackgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leftBTN)
                            .addComponent(rightBTN)
                            .addComponent(selectionLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recordScrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(14, 14, 14)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        errorMessages ErrorMessage = new errorMessages();
        recordDashboardController adminDController = new recordDashboardController();
        if(isFormEmpty())
        {
            ErrorMessage.fillerrorMessage();
            return;
        }
        adminDController.deleteRecordfromtable(recordTable,ErrorMessage);
        
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void clearForm(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearForm
        clearForm();
    }//GEN-LAST:event_clearForm

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        recordDashboardController adminDController = new recordDashboardController();
        adminDController.addRecordtotable(idTField, firstnameTField, lastnameTField,recordTable,sectionCBox,courseCBox);
    }//GEN-LAST:event_addBTNActionPerformed

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        recordDashboardController adminDController = new recordDashboardController();
        adminDController.searchBarfunction(recordTable,searchBar);
    }//GEN-LAST:event_searchBarKeyReleased

    private void recordTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recordTableMouseClicked
        recordDashboardController adminDController = new recordDashboardController();
        adminDController.clickedTable(recordTable,  idTField, firstnameTField,  lastnameTField, courseCBox, sectionCBox);

    }//GEN-LAST:event_recordTableMouseClicked

    private void rightBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightBTNActionPerformed
        sectionDashboard sectiondashboard = new sectionDashboard();
        sectiondashboard.setVisible(true);
        sectiondashboard.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_rightBTNActionPerformed

    private void leftBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftBTNActionPerformed
        courseDashboard courseDashboard = new courseDashboard();
        courseDashboard.setVisible(true);
        courseDashboard.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_leftBTNActionPerformed

    private void updateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTNActionPerformed
        recordDashboardController adminDController = new recordDashboardController();
        adminDController.updateRecordintable(recordTable,idTField,firstnameTField,lastnameTField,sectionCBox,courseCBox);
    }//GEN-LAST:event_updateBTNActionPerformed

    private void courseCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseCBoxActionPerformed
        recordDashboardController adminDController = new recordDashboardController();
        adminDController.sectionListcourse(courseCBox,sectionCBox);
    }//GEN-LAST:event_courseCBoxActionPerformed

    private void lastnameTFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameTFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameTFieldActionPerformed
  
    private void clearForm()
    {
        idTField.setText("");
        firstnameTField.setText("");
        lastnameTField.setText("");
        sectionCBox.setSelectedIndex(0); 
        courseCBox.setSelectedIndex(0);
    }
    
    private boolean isFormEmpty()
    {
        return idTField.getText().equals("") || firstnameTField.getText().equals("") || lastnameTField.getText().equals("");
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel DetailPanel;
    private javax.swing.JButton addBTN;
    private javax.swing.JButton clearBTN;
    private javax.swing.JComboBox<String> courseCBox;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JTextField firstnameTField;
    private javax.swing.JTextField idTField;
    private javax.swing.JLabel insertIdLabel;
    private javax.swing.JLabel insertNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JTextField lastnameTField;
    private javax.swing.JButton leftBTN;
    private javax.swing.JScrollPane recordScrollTable;
    private javax.swing.JTable recordTable;
    private javax.swing.JButton rightBTN;
    private javax.swing.JTextField searchBar;
    private javax.swing.JComboBox<String> sectionCBox;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JLabel selectionLabel;
    private javax.swing.JLabel studentRecordTitle;
    private javax.swing.JButton updateBTN;
    // End of variables declaration//GEN-END:variables
}
