/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.src;
import com.control.connectionController;
import com.view.adminDashboard;
/**
 *
 * @author LordD
 */
public class Student_record_management_system {
    static connectionController con = new connectionController();
    static adminDashboard dashboard = new adminDashboard();
    public static void main(String[] args) {
        con.connect();
        dashboard.setVisible(true);
    }
}
