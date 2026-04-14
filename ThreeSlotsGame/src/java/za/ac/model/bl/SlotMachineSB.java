/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.model.bl;

import java.util.Random;
import javax.ejb.Stateless;

/**
 *
 * @author aobak
 */
@Stateless
public class SlotMachineSB implements SlotMachineSBLocal {
  private int SlotOne ;
  private int SlotTwo ;
  private int SlotThree;

  
  
  @Override
   public void SlotMachines() {
   
    Random Rand1 = new Random();
    SlotOne = Rand1.nextInt(5) + 1;
        Random Rand2 = new Random();
    SlotTwo = Rand2.nextInt(5) + 1;
        Random Rand3 = new Random();
    SlotThree = Rand3.nextInt(5) + 1;
   
   }
  @Override
    public int getSlotOne() {
        return SlotOne;
    }

  @Override
    public int getSlotTwo() {
        return SlotTwo;
    }

    @Override
    public int getSlotThree() {
        return SlotThree;
    }
   
 @Override
   public String Outcome () {
       String Outcome;
     int Sum = SlotOne + SlotTwo + SlotThree;  
     
    if ( Sum == 15)
         Outcome = "MAX";
       else if (SlotOne == 4 && SlotTwo == 4 && SlotThree == 4 )
        Outcome = "FOUR";
             else if (SlotOne == 3 && SlotTwo == 3 && SlotThree == 3 )
                Outcome = "THREE";
                     else if ((SlotOne == 5 && SlotTwo == 5  ) || (SlotTwo == 5 && SlotThree == 5))
                       Outcome = "TWO";
                           else if ((SlotOne == 4 && SlotTwo == 4  ) || (SlotTwo == 4 && SlotThree == 4))
                               Outcome = "ONE";
                            else if ((SlotOne == 3 && SlotTwo == 3  ) || (SlotTwo == 3 && SlotThree == 3))
                                 Outcome = "MIN";
          else Outcome = "LOST";
   
    
   return Outcome;}

    @Override
    public int AmountWon(int W1, int W2, int W3, int W4, int W5, int W6) {
        int Balance = 0;
        String Result = Outcome();
      switch (Result) {
          case "MAX":
          { 
              Balance =  W1; }
              break;
          case "FOUR":
          { 
               Balance =  W2; }
              break;
          case "THREE":
          { 
               Balance = W3; }
              break;
          case "TWO":
          {  
               Balance =  W4; }
          break;
          case "ONE":
          {  
               Balance =  W5; }
              break;
          case "MIN":
          { 
               Balance = W6; }
              break;
          default: Balance = 0;
              break;
      }
      
    
    return Balance;}







   
  
}
