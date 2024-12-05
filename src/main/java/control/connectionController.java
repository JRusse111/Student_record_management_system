/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import model.studentRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author LordD
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
            System.out.println("Erorr Accured: " + e);
        }
    }
    
    public Connection SQLconnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
    //get account
    public List<studentRecord> fetchrecordtable(String status){
        List<studentRecord> studentRecordList = new ArrayList<>();
        String query = """
            SELECT sr.schoolid, sr.firstname, sr.lastname, ss.course, sc.section
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
}
