/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JOptionPane;

/**
 *
 * @author LordD
 */
public class errorMessages {
    
   
    // MESSAGES
    public void fillerrorMessage()
    {
        JOptionPane.showMessageDialog(null, "Fill in the blanks", "Error Inserting Data", JOptionPane.OK_OPTION);
    }
    public void existerrorMessage()
    {
        JOptionPane.showMessageDialog(null, "SchoolID AlreadyExist", "Error Inserting Data", JOptionPane.OK_OPTION);
    }
    public int deleteconformation()
    {
        int option = JOptionPane.showConfirmDialog(null,"Delete data?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        return option;
    }
    public int confirmationMessage()
    {
        int option = JOptionPane.showConfirmDialog(null,"Insert data?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        return option;
    }
}
