/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package techmasterminds.robs.monthexpeses;

import techmasterminds.robs.studentInfo.StudentInfo;

/**
 *
 * @author aobak
 */
public class MonthExpenses {
  private String expenseName;
  private double expenseCost;
  
   public MonthExpenses(String ExpenseName, double ExpenseCost){
    this.expenseCost = ExpenseCost;
    this.expenseName = ExpenseName;}

    public String getExpenseName() {
        return expenseName;
    }

    public double getExpenseCost() {
        return expenseCost;
    }
    
    public String toString() {
    return expenseName + "$" + expenseCost;
}
  
 
}
