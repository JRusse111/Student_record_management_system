/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.connectionController;
import model.studentAccount;
import model.adminAccount;
import javax.swing.JOptionPane;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class loginController {
        
    public boolean studentLogin(String username, String password) {
        connectionController cc = new connectionController();
        //Fetch student account and records
        List<studentAccount> accounts = cc.fetchstudentaccount();

        for (studentAccount account : accounts) {
            if (account.getSchoolid().equals(username) && account.getLastname().equals(password)) {
                return true; //Successful login
            }
        }
        return false;
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
    public int handleLogin(String role, String username, String password) {
        connectionController conn = new connectionController();
        conn.DBconnect();
        
        if (username.isEmpty() || password.isEmpty()) {
            return 3;
        }
        
        // STUDENT
        if(role.equals("Student")) {
            if (studentLogin(username, password)) {
                JOptionPane.showMessageDialog(null, "Login Successful!");
                connectionController CC = new connectionController();
                CC.updateStudentsession(username, "T");
                return 1;
            }
        } 
        //ADMIN
        if(role.equals("Admin")){
            if (adminLogin(username, password)) {
                JOptionPane.showMessageDialog(null, "Admin Login Successful!");
                connectionController CC = new connectionController();
                CC.updateAdminsession(username, "T");
                return 2;
            }
        }
        return 0;
    }
}