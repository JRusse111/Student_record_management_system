/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.connectionController;
import model.studentAccount;
import model.adminAccount;
import model.studentRecord;
import javax.swing.JOptionPane;
import view.loginPage;
import view.studentDashboard;
import view.adminDashboard;
import view.adminHomeDashboard;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class loginController {
        
      public studentRecord studentLogin(String username, String password) {
        connectionController cc = new connectionController();

        // Fetch student account and records
        List<studentAccount> accounts = cc.fetchstudentaccount();
        List<studentRecord> studentRecords = cc.fetchrecordtable("T"); 

        
        for (studentAccount account : accounts) {
            if (account.getSchoolid().equals(username) && account.getLastname().equals(password)) {
                for (studentRecord record : studentRecords) {
                    if (record.getSchoolid().equals(username)) {
                        return record; //Successful login
                    }
                }
            }
        }
        return null; // Login failed
    }
      
      public boolean adminLogin(String username, String password) {
        connectionController cc = new connectionController();

        // Fetch admin account
        List<adminAccount> admins = cc.fetchadminaccount();
        for (adminAccount admin : admins) {
            if (admin.getFirstname().equals(username) && admin.getLastname().equals(password)) {
                return true; //Successful login
            }
        }

        return false; //Login failed
    }
      
        //Method to handle login for Student and Admin
    public void handleLogin(String role, String username, String password, loginPage loginpage) {
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginpage, "Please enter your School ID or password.");
            return;
        }
        // STUDENT
        if (role.equals("Student")) {
            studentRecord loggedInStudent = studentLogin(username, password);
            if (loggedInStudent != null) {
                JOptionPane.showMessageDialog(loginpage, "Login Successful!");
                studentDashboard dashboard = new studentDashboard();
                //Set the student details at studentDashboard
                showStudentDashboard(dashboard, loggedInStudent);
                dashboard.setLocationRelativeTo(null);
                dashboard.setVisible(true);
                loginpage.dispose(); 
            } else {
                JOptionPane.showMessageDialog(loginpage, "Invalid credentials. Please try again.");
            }
        } 
        //ADMIN
        else {
            boolean isAdminLoggedIn = adminLogin(username, password);
            if (isAdminLoggedIn) {
                JOptionPane.showMessageDialog(loginpage, "Admin Login Successful!");
//                adminHomeDashboard adminhome = new adminHomeDashboard();
//                adminhome.setLocationRelativeTo(null);
//                adminhome.setVisible(true);
//                loginpage.dispose();
                adminDashboard admindashboard = new adminDashboard();
                admindashboard.setLocationRelativeTo(null);
                admindashboard.setVisible(true);
                loginpage.dispose(); 
            } else {
                JOptionPane.showMessageDialog(loginpage, "Invalid Admin credentials. Please try again.");
            }
        }
    }
    
      //Show Student Details at StudentDashboard
    public void showStudentDashboard(studentDashboard dashboard, studentRecord student) {
         dashboard.setStudentDetails(
        student.getFirstname() + " " + student.getLastname(),
        student.getSchoolid(),
        student.getCourse(),
        student.getSection()
    );
    }
}