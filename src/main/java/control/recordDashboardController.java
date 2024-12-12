/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import control.errorMessages;


import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.connectionController;
import model.studentCourse;
import model.studentRecord;
import model.studentSection;

/**
 * //CHECK UPDATE BUTTON IF ALREADY EXIST
 * @author LordD
 */
public class recordDashboardController {
    
    // BUTTON FUNCTIONS
    public void deleteRecordfromtable(javax.swing.JTable recordTable, errorMessages ErrorMessage)
    {
        connectionController CC = new connectionController();
        int selectedRow = recordTable.getSelectedRow();
        if(selectedRow != -1 && 0 == ErrorMessage.deleteconformation()){
            String studentId = (String) recordTable.getValueAt(selectedRow,1);
            CC.removeFromrecordtable(studentId);
        }
        updateRecordTable(recordTable);
    }
    public void addRecordtotable(javax.swing.JTextField idTField, javax.swing.JTextField firstnameTField, javax.swing.JTextField lastnameTField,
                                javax.swing.JTable recordTable,javax.swing.JComboBox<String> sectionCBox,javax.swing.JComboBox<String> courseCBox
    )
    {
        errorMessages ErrorMessage = new errorMessages();
        
        connectionController CC = new connectionController();
        List<studentRecord> records = CC.fetchrecordtable("T");
        boolean exists = false;

        for (studentRecord record : records) {
            if (record.getSchoolid().equals(idTField.getText())) {
                exists = true;
                break;
            }
        }
        
        if (exists) {
//            System.out.println("ERROR");
            ErrorMessage.existerrorMessage();
        } else {
            if(0 == ErrorMessage.confirmationMessage()){
                CC.insertIntorecordtotable(
                        idTField.getText(), 
                        firstnameTField.getText(), 
                        lastnameTField.getText(),
                        getIndexSection(sectionCBox), 
                        getIndexCourse(courseCBox)
                );
//                System.out.println(idTField.getText()+ " | "+
//                        firstnameTField.getText()+ " | "+
//                        lastnameTField.getText()+ " |Section"+
//                        getIndexSection()+ " |Course" +
//                        getIndexCourse());
            }
        }
        updateRecordTable(recordTable);
    }
    public void updateRecordintable(javax.swing.JTable recordTable, javax.swing.JTextField idTField, javax.swing.JTextField firstnameTField, javax.swing.JTextField lastnameTField,
                                    javax.swing.JComboBox<String> sectionCBox,javax.swing.JComboBox<String> courseCBox
    )
    {
        //CHECK UPDATE BUTTON IF ALREADY EXIST
        connectionController CC = new connectionController();
        int selectedRow = recordTable.getSelectedRow();
        if(selectedRow != -1){
            int id = (int) recordTable.getValueAt(selectedRow,0);
            String schoolid = idTField.getText();
            String firstname = firstnameTField.getText();
            String lastname = lastnameTField.getText();
            CC.updateStudentrecordtable(id,schoolid, firstname , lastname, getIndexSection(sectionCBox), getIndexCourse(courseCBox));
//            System.out.println(id + " | " + schoolid + " | " + firstname + "|" + lastname + "|section:" + getIndexSection() +"|course:"+ getIndexCourse());
        }
        updateRecordTable(recordTable);
    }
    public void searchBarfunction(javax.swing.JTable recordTable, javax.swing.JTextField searchBar)
    {
        DefaultTableModel dTable = (DefaultTableModel) recordTable.getModel();
        String text = searchBar.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(dTable);
        recordTable.setRowSorter(sorter);
        
        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    public void clickedTable(javax.swing.JTable recordTable, javax.swing.JTextField idTField, 
                             javax.swing.JTextField firstnameTField, javax.swing.JTextField lastnameTField,
                             javax.swing.JComboBox<String> courseCBox,javax.swing.JComboBox<String> sectionCBox
                            )
    {
        int selectedRow = recordTable.getSelectedRow();
        if(selectedRow != -1){
            
            idTField.setText((String) recordTable.getValueAt(selectedRow,1));
            firstnameTField.setText((String) recordTable.getValueAt(selectedRow,2));
            lastnameTField.setText((String) recordTable.getValueAt(selectedRow, 3));
            String selectedSection = (String) recordTable.getValueAt(selectedRow, 4);
            String selectedCourse = (String) recordTable.getValueAt(selectedRow, 5);
            for (int i = 0; i < courseCBox.getItemCount(); i++) {
                if (courseCBox.getItemAt(i).equals(selectedCourse)) {
                    courseCBox.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < sectionCBox.getItemCount(); i++) {
                //                System.out.println(sectionCBox.getItemAt(i) + " | " + selectedSection);
                if (sectionCBox.getItemAt(i).equals(selectedSection)) {
                    sectionCBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    
    public void updateRecordTable(javax.swing.JTable recordTable)
    {
        DefaultTableModel dTable = (DefaultTableModel) recordTable.getModel();
        dTable.setRowCount(0);
        connectionController CC = new connectionController();
        
        List<studentRecord> sRecord = CC.fetchrecordtable("T");
        for(studentRecord record : sRecord)
        {
            int id = record.getId();
            String schoolid = record.getSchoolid();
            String firstname = record.getFirstname();
            String lastname = record.getLastname();
            String section = record.getSection();
            String course = record.getCourse();

            dTable.addRow(new Object[] {id ,schoolid, firstname, lastname, section, course});
        }
    }
    
    public void sectionListcourse(javax.swing.JComboBox<String> courseCBox, javax.swing.JComboBox<String> sectionCBox)
    {
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        String itemCoursebox = courseCBox.getItemAt(courseCBox.getSelectedIndex());
        for(studentCourse course : courses)
        {
            if(course.getCoursename().equals(itemCoursebox))
            {
                System.out.println(course.getCoursename() + " | " + itemCoursebox);
                updateSectionbox(course.getId(),sectionCBox);
            }
        }

    }
    
    public void updateCoursebox(javax.swing.JComboBox<String> courseCBox)
    {
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        for(studentCourse course : courses)
        {
            courseCBox.addItem(course.getCoursename());
        }
    }
   
    public void updateSectionbox(int courseid, javax.swing.JComboBox<String> sectionCBox)
    {
        sectionCBox.removeAllItems();
        connectionController CC = new connectionController();
        List<studentSection> sections = CC.fetchstudentsection("T");
        for(studentSection section : sections)
        {
            if(courseid == section.getCourseid())
            {
                sectionCBox.addItem(section.getSectionname());
            }
        }
    }
    
    public int getIndexCourse(javax.swing.JComboBox<String> courseCBox)
    {
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        String courseBox = courseCBox.getItemAt(courseCBox.getSelectedIndex());
        System.out.println("get index course: " + courseBox);
        for(studentCourse course: courses)
        {
            if(course.getCoursename().equals(courseBox))
            {
                return course.getId();
            }
        }
        return -1;
    }
    public int getIndexSection(javax.swing.JComboBox<String> sectionCBox)
    {
        connectionController CC = new connectionController();
        List<studentSection> sections = CC.fetchstudentsection("T");
        String sectionBox = sectionCBox.getItemAt(sectionCBox.getSelectedIndex());
        System.out.println("get index section:" + sectionBox);
        for(studentSection section: sections)
        {
            if(section.getSectionname().equals(sectionBox))
            {
                return section.getSectionnumber();
            }
        }
        return -1;
    }
}