/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aobak
 */
@WebServlet (name = "StartSessionServlet", urlPatterns = {"/StartSessionServlet.do" })
public class StartSessionServlet extends HttpServlet {


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
    

         HttpSession Session = request.getSession(true);
         
         String Name = (String)request.getParameter("name");
         Integer Deposit = Integer.parseInt(request.getParameter("Deposit"));
         InitializeSession (Session,Name,Deposit);
         
         RequestDispatcher disp = request.getRequestDispatcher("StartGame.jsp");
         disp.forward(request, response);
    }
    
    private void InitializeSession (HttpSession session, String PlayerName, Integer Deposit){
     
     Integer Balance = Deposit, TotalGames = 0;
     List<String> Wins = new ArrayList<>();
      List<List<Integer>> Numbers = new ArrayList<>();
    
     session.setAttribute("name", PlayerName);
     session.setAttribute("Numbers", Numbers);
     session.setAttribute("Balance", Balance);
     session.setAttribute("OutComes", Wins);
     session.setAttribute("TotalGames", TotalGames);
    
    }
         
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
