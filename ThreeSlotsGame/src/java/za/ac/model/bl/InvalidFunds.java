/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.model.bl;
import javax.ejb.EJBException;

/**
 *
 * @author aobak
 */
public class InvalidFunds extends EJBException{
    public InvalidFunds(String errMsg){
        super(errMsg);
    }
    
}
