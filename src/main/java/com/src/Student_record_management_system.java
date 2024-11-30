/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.src;
import com.src.control.connectionController;
/**
 *
 * @author LordD
 */
public class Student_record_management_system {
    static connectionController con = new connectionController();
    
    public static void main(String[] args) {
        con.connect();
    }
}
