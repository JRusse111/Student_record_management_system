/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.connectionController;
import model.studentRecord;

/**
 *
 * @author LordD
 */
public class studentDashboardController {
    
    public void getStudentinformation(String studentid,javax.swing.JLabel lblName,javax.swing.JLabel lblSchoolid,
            javax.swing.JLabel lblCourse, javax.swing.JLabel lblSection
    )
    {
        connectionController CC = new connectionController();
        studentRecord studentInfo = CC.getSpecificstudent(studentid);
        lblName.setText("WELCOME : " + studentInfo.getFirstname());
        lblSchoolid.setText("SCHOOL ID : " + studentInfo.getSchoolid());
        lblCourse.setText("COURSE : " + studentInfo.getCourse());
        lblSection.setText("SECTION : " + studentInfo.getSection());
    }
}
