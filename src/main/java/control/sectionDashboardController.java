/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.connectionController;
import model.studentCourse;
import model.studentSection;
/**
 * // TODO : FIX DUPLICATE CODE IF YOU HAVE TIME 
 * @author LordD
 * TODO :  //UDPATE BUTTON IF EXIST
 * 
 */
public class sectionDashboardController {
    
    public void addSectiontotable(javax.swing.JTextField sectionTField, javax.swing.JComboBox<String> courseCBox,
            javax.swing.JTable sectionTable
    )
    {
        boolean exist = false;
        errorMessages ErrorMessage = new errorMessages(); 
        connectionController CC = new connectionController();
        int sectionMax = CC.getmaxSectionnumber(getIndexCourse(courseCBox));
        List<studentSection> sections = CC.fetchstudentsection("T");
        //PAGOD
        for (studentSection section : sections) {
//            System.out.println(section.getCourseid()+"="+getIndexCourse(courseCBox) +"||"+
//                    section.getSectionname()+"="+sectionTField.getText());
            if (section.getCourseid() == getIndexCourse(courseCBox)
                    && section.getSectionname().equals(sectionTField.getText())) {
                exist = true;
                break;
            }
        }
        
        if(exist)
        {
            ErrorMessage.existerrorMessage();
        }
        else{
//            System.out.println(getIndexCourse(courseCBox)+"|"+ sectionMax+"|"+ sectionTField.getText());
            CC.insertIntosectiontable(getIndexCourse(courseCBox), sectionMax, sectionTField.getText());
            updateSectiontable(sectionTable);
        }
    }
    public void updateSectiontable(javax.swing.JTable sectionTable, javax.swing.JTextField sectionTField, javax.swing.JLabel sectionId,
                             javax.swing.JComboBox<String> courseCBox
    )
    {
        // CHECK IF ALREADY EXIST
        connectionController CC = new connectionController();
        int selectedRow = sectionTable.getSelectedRow();

        if(selectedRow != -1)
        {
            int sectionid =Integer.parseInt(sectionId.getText());
            int courseid = getIndexCourse(courseCBox);
            String sectionName = sectionTField.getText();
            
            CC.updateStudentsection(courseid,sectionid, sectionName); // checker
        }
        updateSectiontable(sectionTable);
    }
    
    public void clickedTable(javax.swing.JTable recordTable, javax.swing.JTextField sectionTField, javax.swing.JLabel sectionNum,
                             javax.swing.JComboBox<String> courseCBox,javax.swing.JLabel sectionId
    )
    {
        int selectedRow = recordTable.getSelectedRow();
        if(selectedRow != -1){
            sectionId.setText(Integer.toString((int) recordTable.getValueAt(selectedRow, 0)));
            String selectedCourse = (String) recordTable.getValueAt(selectedRow, 1);
            String sectionNumber = Integer.toString((int) recordTable.getValueAt(selectedRow, 2));
            sectionTField.setText((String) recordTable.getValueAt(selectedRow,3));
            
            sectionNum.setText(sectionNumber);
            for (int i = 0; i < courseCBox.getItemCount(); i++) {
                if (courseCBox.getItemAt(i).equals(selectedCourse)) {
                    courseCBox.setSelectedIndex(i);
                    break;
                }
            }
        }
    }
    public void searchBar(javax.swing.JTextField searchBar, javax.swing.JTable sectionTable)
    {
        DefaultTableModel dTable = (DefaultTableModel) sectionTable.getModel();
        String text = searchBar.getText();
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(dTable);
        sectionTable.setRowSorter(sorter);

        if (text.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }
    
    
    
    
    //================
    public int getIndexCourse(javax.swing.JComboBox<String> courseCBox)
    {
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        String courseBox = courseCBox.getItemAt(courseCBox.getSelectedIndex());
//        System.out.println("get index course: " + courseBox);
        for(studentCourse course: courses)
        {
            if(course.getCoursename().equals(courseBox))
            {
                return course.getId();
            }
        }
        return -1;
    }
    
    public void updateSectiontable(javax.swing.JTable sectionTable)
    {
        DefaultTableModel dTable = (DefaultTableModel) sectionTable.getModel();
        dTable.setRowCount(0);
        connectionController CC = new connectionController();

        List<studentSection> sections = CC.fetchstudentsection("T");
        for(studentSection section : sections)
        {
            int id = section.getId();
            String courseid = section.getCoursename();
            int sectionNum = section.getSectionnumber();
            String sectionname = section.getSectionname();
            dTable.addRow(new Object[] {id,courseid, sectionNum,sectionname});
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
    
}
