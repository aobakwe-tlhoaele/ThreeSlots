/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.model.bl;

import javax.ejb.Local;

/**
 *
 * @author aobak
 */
@Local
public interface SlotMachineSBLocal {
    void SlotMachines();
    int getSlotOne();
    int getSlotTwo();
    int getSlotThree();
    String Outcome();
    int AmountWon(int W1,int W2,int W3,int W4,int W5, int W6);
    
}
