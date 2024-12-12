/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.connectionController;
import model.studentCourse;

/**
 *
 * @author LordD
 */
public class courseDashboardController {
    
    public void clickedTable(javax.swing.JTable courseTable, javax.swing.JTextField courseNAME, javax.swing.JLabel courseID)
    {
        int selectedRow = courseTable.getSelectedRow();
        if(selectedRow != -1){
            String courseId = Integer.toString((int) courseTable.getValueAt(selectedRow,0));
            String courseName = (String) courseTable.getValueAt(selectedRow, 1);
            
            courseNAME.setText(courseName);
            courseID.setText(courseId);
        }
    }
    
    public void addCoursetotable(javax.swing.JTable courseTable,javax.swing.JTextField courseNAME)
    {
        boolean exist = false;
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        
        errorMessages ErrorMessage = new errorMessages(); 
        
        for(studentCourse course : courses)
        {
            if(course.getCoursename().equals(courseNAME.getText()))
            {
                exist = true;
            }
        }
        
        if(exist)
        {
            ErrorMessage.existerrorMessage();
            return;
        }
        else{
            CC.insertCoursetotable(courseNAME.getText());
            updateCoursetable(courseTable);
        }
        updateCoursetable(courseTable);
    }
    public void updateCoursetable(javax.swing.JTextField courseName,javax.swing.JLabel courseID, javax.swing.JTable courseTable)
    {
        //check if already exist
        boolean exist = false;
        errorMessages ErrorMessage = new errorMessages();
        connectionController CC = new connectionController();
        List<studentCourse> courses = CC.fetchstudentcourse("T");
        
        for(studentCourse course : courses)
        {
            if(course.getCoursename().equals(courseName.getText()))
            {
                exist = true;
            }
        }
        
        if(exist)
        {
            ErrorMessage.existerrorMessage();
        }
        else
        {
            CC.updateCoursetable(courseName.getText(),Integer.parseInt(courseID.getText()));
        }
        updateCoursetable(courseTable);
    }
    
    public void deleteCoursefromtable(javax.swing.JLabel courseID,javax.swing.JTable courseTable)
    {
        connectionController CC = new connectionController();
        
        int selectedRow = courseTable.getSelectedRow();
        if(selectedRow != -1){
            CC.removeFromcoursetable(Integer.parseInt(courseID.getText()));
        }
    }
    
    
    public void updateCoursetable(javax.swing.JTable courseTable)
    {
        DefaultTableModel dTable = (DefaultTableModel) courseTable.getModel();
        dTable.setRowCount(0);
        connectionController CC = new connectionController();

        List<studentCourse> courses = CC.fetchstudentcourse("T");
        for(studentCourse course : courses)
        {
            int id = course.getId();
            String scourse = course.getCoursename();
            dTable.addRow(new Object[] {id, scourse});
        }
    }
    
}
