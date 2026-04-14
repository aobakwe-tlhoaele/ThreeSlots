/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmasterminds.robs.studentInfo;

import java.io.BufferedReader;
import java.io.File;


/**
 *
 * @author aobak
 */
public class StudentInfo  {
       
     private String surname;
    private String name;
    private String institution;
    private String studentNumber;   
    private boolean bursary;
    private int monthlyAllowance;

    // Constructor
    public StudentInfo(String surname, String name, String institution,String studentNumber, boolean bursary,int monthlyAllowance) {
        this.surname = surname;
        this.name = name;
        this.institution = institution;
        this.bursary = bursary;
        this.studentNumber = studentNumber;
        this.monthlyAllowance = monthlyAllowance;

    }

    public void setMonthlyAllowance(int monthlyAllowance) {
        this.monthlyAllowance = monthlyAllowance;
    }

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return name;
    }

    public String getInstitution() {
        return institution;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    
    public boolean hasBursary() {
        return bursary;
    }
  
   public int getMonthlyAllowance() {
      
        return monthlyAllowance ;
    }
   
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setInitials(String initials) {
        this.name = initials;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    
    
    public void setBursary(boolean bursary) {
        this.bursary = bursary;}

    public String ToString(){
     return surname + "#" + name+ "#" + institution + "#" + studentNumber + "#" + bursary + "#"+ monthlyAllowance;}
    

}
    
    

    
    

    
    

