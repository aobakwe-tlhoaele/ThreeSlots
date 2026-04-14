/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package techmasterminds.robs.expensetracker;

import java.util.ArrayList;
import techmasterminds.robs.monthexpeses.MonthExpenses;
import techmasterminds.robs.studentInfo.StudentInfo;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author aobak
 */
public class ExpenseTracker {
    private StudentInfo student;
     private ArrayList<MonthExpenses> Expenses;

     
      public ExpenseTracker(){
      this.Expenses = new ArrayList<>();}
     
      public ExpenseTracker(StudentInfo student ){
      this.Expenses = new ArrayList<>(); 
   
      this.student = student;}
 


    public void AddExpenses( String Expense, double ExpenseCost ) {
       
        Expenses.add(new MonthExpenses(Expense,ExpenseCost));
        
   }

    public ArrayList<MonthExpenses> getExpenses() {
        return Expenses;
    }

    
 public double CalculateSavings(double monthlyAllowance, double totalExpenses){    
    return  monthlyAllowance - totalExpenses;}
     
   
public void saveToFile(File ExpenseFile, ArrayList<MonthExpenses> Expenses) throws IOException {
String listToSave = "";  
    for (MonthExpenses expense : Expenses) {
        listToSave += expense.toString() + "\n";  
    }

    BufferedWriter bw = new BufferedWriter(new FileWriter(ExpenseFile, false));   
    bw.write(listToSave);  
    bw.close();             
}
  
    public String Summary(String Expenses, double TotalExpenses, String month) {
       double savings = CalculateSavings(student.getMonthlyAllowance(), TotalExpenses);
    String output =            
                  "Monthly Summary (" + month + ")\n\n" +
                     "Student Information:\n" +
                     "Name: " + student.getInitials() + " " + student.getSurname() + "\n" +
                     "Institution: " + student.getInstitution() + "\n" +
                     "Student Number: " + student.getStudentNumber() + "\n" +
                     "Has Funding: " + (student.hasBursary() ? "Yes" : "No") + "\n" +
                     "Monthly Allowance: R" + student.getMonthlyAllowance() + "\n\n" +
                     Expenses.toString() + "\n" +
                     "Total Expenses: R" + TotalExpenses + "\n" +  
                     "Savings: R" + savings + "\n\n" +
                     (savings >= 0 ? "Good job! You're within budget." : "Warning! You've exceeded your budget.");
                 
    return output;
}
    
 

 }

    
   

