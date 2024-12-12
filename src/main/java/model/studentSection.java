/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LordD
 */
public class studentSection {
    private int id;
    private String sectionname;
    private int sectionnumber;
    private int courseid;
    private String coursename;
    private char status;

    public void setStatus(char status) {
        this.status = status;
    }

    public char getStatus() {
        return status;
    }
    
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setSectionnumber(int sectionnumber) {
        this.sectionnumber = sectionnumber;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSectionnumber() {
        return sectionnumber;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSectionname(String section) {
        this.sectionname = section;
    }
    public int getId() {
        return id;
    }

    public String getSectionname() {
        return sectionname;
    }
    
}
