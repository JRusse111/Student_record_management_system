/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.src.control;
import com.src.model.databaseCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author LordD
 */
public class connectionController {
    databaseCon DBConnection = new databaseCon();
   // CONNECT THE DATABASE TO THE CONTROLLER
  
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print(e + "Driver Cannot be found");
        }
        
        try{
            Connection con = DriverManager.getConnection(DBConnection.getUrl(),DBConnection.getUser(), DBConnection.getPass());
        }catch(SQLException e){
            System.out.println("Erorr Accured: " + e);
            System.out.println("herllo");
        }
    }
}
