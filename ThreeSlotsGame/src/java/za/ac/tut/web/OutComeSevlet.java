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

/**
 *
 * @author aobak
 */
@WebServlet (name = "OutComeSevlet", urlPatterns = {"/OutComeSevlet.do"})
public class OutComeSevlet extends HttpServlet {

 @EJB   SlotMachineSBLocal Slot;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        HttpSession session = request.getSession();
        
        Integer AmountOne = Integer.parseInt(getServletContext().getInitParameter("AmountOne"));
        Integer AmountTwo = Integer.parseInt(getServletContext().getInitParameter("AmountTwo"));
        Integer AmountThree = Integer.parseInt(getServletContext().getInitParameter("AmountThree"));
        Integer AmountFour = Integer.parseInt(getServletContext().getInitParameter("AmountFour"));
        Integer AmountFive = Integer.parseInt(getServletContext().getInitParameter("AmountFive"));
        Integer AmountSix = Integer.parseInt(getServletContext().getInitParameter("AmountSix"));
     
        int Results = Slot.AmountWon(AmountOne, AmountTwo, AmountThree, AmountFour, AmountFive, AmountSix);
   
        String Outcome = Slot.Outcome();
        UpdateSession(session, Results, Outcome, request);
        
        request.setAttribute("Result", Results);

        
        RequestDispatcher Disp = request.getRequestDispatcher("Outcome.jsp");
        Disp.forward(request, response);
        
    }
    
    public void UpdateSession(HttpSession session, Integer Amount, String Outcome, HttpServletRequest request){ 
    
       List<String> Dubs =  (List<String>)session.getAttribute("OutComes");
        Dubs.add(Outcome);         
        session.setAttribute("OutComes", Dubs);
     
        String Message = "Congratulations, you have won R";
        
       if (!Outcome.equals("LOST"))
       { 
        Integer Balance = (Integer)session.getAttribute("Balance");
        int UpdateBalance = Balance + Amount;
        session.setAttribute("Balance", UpdateBalance); 
        request.setAttribute ("Message", Message);
 } else
       {  Message = "Loss, Try again";
       request.setAttribute ("Message", Message); } 
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
