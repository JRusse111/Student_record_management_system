/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.studentRecord;
import model.studentCourse;
import model.studentSection;
import model.studentAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author LordD
 * TODO CREATE ANOTHER CLASS FOR THE FETCH AND INSERT 
 */
public class connectionController {
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3306/recordmanagementsystem";
  
    public void DBconnect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print(e + "Driver Cannot be found");
        }
        // CONNECT TO DATABASE
        try{
            Connection con = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.err.println("Error Accured: " + e);
        }
    }
    
    public Connection SQLconnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    
    //GET THING IN THE TABLE
    public List<studentRecord> fetchrecordtable(String status){
        List<studentRecord> studentRecordList = new ArrayList<>();
        String query = """
            SELECT sr.schoolid, sr.firstname, sr.lastname, ss.section, sc.course
            FROM studentrecord sr
            JOIN studentsection ss ON sr.section = ss.id
            JOIN studentcourse sc ON sr.course = sc.id
            WHERE sr.status = ?;
        """;

        try (Connection con = SQLconnection();
            PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, status); // Set the status parameter

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    studentRecord record = new studentRecord();
                    record.setSchoolid(resultSet.getString("schoolid"));
                    record.setFirstname(resultSet.getString("firstname"));
                    record.setLastname(resultSet.getString("lastname"));
                    record.setCourse(resultSet.getString("course"));
                    record.setSection(resultSet.getString("section"));
                    studentRecordList.add(record);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving records from table: " + e.getMessage());
        }
        return studentRecordList;
    }
    //getcourse
    public List<studentCourse> fetchstudentcourse(){
        List<studentCourse> courses = new ArrayList();
        String query = """
            SELECT *
            FROM studentcourse
        """;
        try (Connection con = SQLconnection();
            PreparedStatement preparedStatement = con.prepareStatement(query)) {
            
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    studentCourse course = new studentCourse();
                    course.setId(resultSet.getInt("id"));
                    course.setCourse(resultSet.getString("course"));
                    courses.add(course);
                }
            }
        }catch(SQLException e){
            System.err.println("Error retrieving course from table:" + e);
        }
        
        return courses;
    }
    public List<studentSection> fetchstudentsection(){
        List<studentSection> sections = new ArrayList();
        String query = """
            SELECT *
            FROM studentsection
        """;
        try (Connection con = SQLconnection();
            PreparedStatement preparedStatement = con.prepareStatement(query)) {
            
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    studentSection section = new studentSection();
                    section.setId(resultSet.getInt("id"));
                    section.setSection(resultSet.getString("section"));
                    sections.add(section);
                }
            }
        }catch(SQLException e){
            System.err.println("Error retrieving section from table:" + e);
        }
        
        return sections;
    }
    
    // GET STUDENT ACCOUNT
    public List<studentAccount> fetchstudentaccount(){
        List<studentAccount> studentAccounts = new ArrayList<>();
        String query = """
            SELECT *
            FROM studentAccount;              
        """;
    
        try (Connection con = SQLconnection();
         PreparedStatement preparedStatement = con.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()){
        
            while(resultSet.next()){
                studentAccount account = new studentAccount();
                account.setId(resultSet.getInt("id"));
                account.setSchoolid(resultSet.getString("schoolid"));
                account.setLastname(resultSet.getString("lastname"));
                studentAccounts.add(account);
            }
        } catch(SQLException e){
            System.err.println("Error retrieving student accounts: " + e.getMessage());
    }
    return studentAccounts;
    }
    
    //INSERT INTO TABLE
    
    public void insertIntoTable(String schoolId, String firstName, String lastName, int section, int course) {
        String queryToRecord = """
            INSERT INTO studentrecord
            VALUES (DEFAULT, ?, ?, ?, ?, ?, DEFAULT)
        """;
        String queryToAccount = """
            INSERT INTO studentaccount
            VALUES (DEFAULT, ?, ?, DEFAULT)
        """;
        try (Connection con = SQLconnection()) {

            try (PreparedStatement preparedStatementRecord = con.prepareStatement(queryToRecord)) {
                preparedStatementRecord.setString(1, schoolId);
                preparedStatementRecord.setString(2, firstName);
                preparedStatementRecord.setString(3, lastName);
                preparedStatementRecord.setInt(4, section + 1);
                preparedStatementRecord.setInt(5, course + 1);
                preparedStatementRecord.executeUpdate();
            }

            try (PreparedStatement preparedStatementAccount = con.prepareStatement(queryToAccount)) {
                preparedStatementAccount.setString(1, schoolId);
                preparedStatementAccount.setString(2, lastName);
                preparedStatementAccount.executeUpdate();
            }

        } catch (SQLException e) {
            System.err.println("Error during inserting: " + e);
        }
    }
    //DELETE FROM TABLE
    public void removeFromtable(String studentId)
    {
        String query = """
            UPDATE studentrecord
            SET status = 'F'
            WHERE schoolid = ?                       
        """;
        try (Connection con = SQLconnection()) {

            try (PreparedStatement preparedStatementRecord = con.prepareStatement(query)) {
                preparedStatementRecord.setString(1, studentId);
                preparedStatementRecord.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error during inserting: " + e);
        }
    }
}
