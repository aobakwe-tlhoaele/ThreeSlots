/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.model.bl.SlotMachineSBLocal;
import java.util.Arrays;
import za.ac.model.bl.InvalidFunds;

/**
 *
 * @author aobak
 */
@WebServlet (name = "GenerateSlotServlet", urlPatterns = {"/GenerateSlotServlet.do"})
public class GenerateSlotServlet extends HttpServlet {
 @EJB SlotMachineSBLocal Slot;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
  

    }
    
    private void UpdateSession(HttpSession session, int s1, int s2, int s3){
       Integer RemBal; 
       Integer Games =  (Integer)session.getAttribute("TotalGames" );
       Integer TotalBal =  (Integer)session.getAttribute("Balance" );
       List<List<Integer>> Numbs=  (List<List<Integer>>)session.getAttribute("Numbers");
           Numbs.add(Arrays.asList(s1,s2,s3));

           
       Games++;
        if (TotalBal > 0  )
         RemBal = TotalBal - 50;
        else
        throw new InvalidFunds("No funds please deposit and start playing again!!");
        
       session.setAttribute("TotalGames", Games);
       session.setAttribute("Balance", RemBal);
     session.setAttribute("Numbers", Numbs);
     
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
    HttpSession session = request.getSession();
     
        Slot.SlotMachines();
        Integer FirstSlot = Slot.getSlotOne();
         Integer SecondSlot = Slot.getSlotTwo();
          Integer ThirdSlot = Slot.getSlotThree();
          
          request.setAttribute("Slot1", FirstSlot);
            request.setAttribute("Slot2", SecondSlot);
              request.setAttribute("Slot3", ThirdSlot);
              
              UpdateSession(session,FirstSlot,SecondSlot,ThirdSlot);
        RequestDispatcher disp = request.getRequestDispatcher("GuessServlet.jsp");
        disp.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
