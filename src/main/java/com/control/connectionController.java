/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.control;
import com.model.databaseCon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author LordD
 */
public class connectionController {
    final databaseCon DBConnection = new databaseCon();
    private Connection con;
// CONNECT THE DATABASE TO THE CONTROLLER
  
    public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print(e + "Driver Cannot be found");
        }
        // CONNECT TO DATABASE
        try{
            con = DriverManager.getConnection(DBConnection.getUrl(),DBConnection.getUser(), DBConnection.getPass());
            
            if(!databaseExist(DBConnection, con))
            {
                System.out.println("Creating Database and Table");
                createDatabase(DBConnection);
            }
            con.setCatalog(DBConnection.getDbname());
            createTables(DBConnection);
        }catch(SQLException e){
            System.out.println("Erorr Accured: " + e);
        }
        
    }
    
    private static boolean databaseExist(databaseCon DBConnection, Connection con)
    throws SQLException
    {
        // CHECK IF DATABASE EXIST
        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCheckDB()))
        {
            preparedStatement.setString(1, DBConnection.getDbname());
            try(ResultSet resultSet = preparedStatement.executeQuery())
            {
                return resultSet.next();
            }
        }
    }
    
    public void createDatabase(databaseCon DBConnection)
    throws SQLException{
        String query = "Create Database " + DBConnection.getDbname();
        //CREATE DATABASE 
        System.out.println(query);
        try(PreparedStatement preparedStatement = con.prepareStatement(query))
        {
            preparedStatement.executeUpdate();
        }
    }
    
    public void createTables(databaseCon DBConnection)
    throws SQLException{
        //CREATE ADMIN ACCOUNT TABLE
        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCreateAdminAccountTable()))
        {
            preparedStatement.executeUpdate();
        }
        //CREATE DEPARTMENT COURSE TABLE
        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCreateDepartmentCourseTable()))
        {
            preparedStatement.executeUpdate();
        }
        //CREATE DEPARTMENT SECTON TABLE
        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCreateDepartmentSectionTable()))
        {
            preparedStatement.executeUpdate();
        }
        //CREATE STUDENT ACCOUNT TABLE
//        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCreateStudentAccountTable()))
//        {
//            preparedStatement.executeUpdate();
//        }
        //CREATE STUDENT RECORD TABLE
        try(PreparedStatement preparedStatement = con.prepareStatement(DBConnection.getCreateStudentRecordTable()))
        {
            preparedStatement.executeUpdate();
        }
    }
}
