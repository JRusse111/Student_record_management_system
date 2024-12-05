/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LordD
 */
public class studentRecord {
    private int id;

    private String schoolid;
    private String firstname;
    private String lastname;
    private String section;
    private String course;
    private char status;
    
    public void setId(int id) {
        this.id = id;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSection() {
        return section;
    }

    public String getCourse() {
        return course;
    }

    public char getStatus() {
        return status;
    }
    
}
