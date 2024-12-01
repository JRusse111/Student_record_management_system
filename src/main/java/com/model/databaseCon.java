/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author LordD
 */
public class databaseCon {
    // Required To Connect in database
    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbname = "recordmanagementsystem";

    public String getUser(){return user;}
    public String getPass(){return pass;}
    public String getUrl() {return url;}
    public String getDbname() {return dbname;}
    public void setUser(String user){this.user = user;}
    public void setPass(String pass){this.pass = pass;}
    public void setUrl(String url) {this.url = url;}
    public void setDbname(String dbName){this.dbname = dbName;}
    
    // SQL QUERIES
    public String getCreateDB(){ return "CREATE DATABASE " + getDbname();}
    public String getCheckDB(){return "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = ?";}
    public String getCreateAdminAccountTable(){ return "CREATE TABLE IF NOT EXISTS adminaccount (id INT AUTO_INCREMENT PRIMARY KEY, firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL)";}
    public String getCreateDepartmentSectionTable(){return "CREATE TABLE IF NOT EXISTS studentsection (id INT AUTO_INCREMENT PRIMARY KEY, course VARCHAR(255))";}
    public String getCreateDepartmentCourseTable(){return "CREATE TABLE IF NOT EXISTS studentcourse (id INT AUTO_INCREMENT PRIMARY KEY, section VARCHAR(255))";}
    public String getCreateStudentRecordTable(){return "CREATE TABLE IF NOT EXISTS studentrecord (id INT AUTO_INCREMENT PRIMARY KEY, schoolid VARCHAR(255) NOT NULL, name VARCHAR(255) NOT NULL, section VARCHAR(255) NOT NULL,course VARCHAR(255) NOT NULL)";}
    public String getCreateStudentAccountTable(){return "CREATE TABLE IF NOT EXISTS studentaccount (id INT AUTO_INCREMENT PRIMARY KEY, schoolid VARCHAR(255) NOT NULL, section VARCHAR(255) NOT NULL,course VARCHAR(255) NOT NULL)";}
//    public String getCreateStudentShowTable(){return "CREATE TABLE IF NOT EXISTS studentaccount (name int NOT NULL, )";}  CREATE A PROPER SHOW TABlE
}
