<%-- 
    Document   : StartGame
    Created on : 07 Mar 2026, 3:59:50 PM
    Author     : aobak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Game</title>
    </head>
    <body>
          
        <h1>THREE SLOT MACHINE!</h1>
        <% String Name = (String)session.getAttribute("name");
           Integer Deposit = (Integer)session.getAttribute("Deposit");
           String GameName = pageContext.getServletContext().getInitParameter("GameName");
           Integer AmountOne = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountOne"));
           Integer AmountTwo = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountTwo"));
           Integer AmountThree = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountThree"));
           Integer AmountFour = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountFour"));
           Integer AmountFive = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountFive"));
           Integer AmountSix = Integer.parseInt(pageContext.getServletContext().getInitParameter("AmountSix"));%>
            
           
           
        <P> Hi, <%= Name %> you have deposited R<%=Deposit%> into your account!. </P>
        <P> You will be playing, <%= GameName%> These are the rules:  </P>
        <ul>
            <li>Entry fee for each game is R50</li>
            <li>Three Fives = R<%= AmountOne %> </li> 
            <li>Three Fours = R<%= AmountTwo %> </li> 
            <li>Three Threes = R<%= AmountThree %> </li> 
            <li>Two Fives = R<%= AmountFour %> </li> 
            <li>Two Fours = R<%= AmountFive %> </li> 
            <li>Two Threes = R<%= AmountSix %> </li> 
            
        
            </ul>
            
        <form action="GenerateSlotServlet.do" method="post">
    <input type="submit" value="PLAY!!"
   style="background-color: black;color: white;font-size: 14px; font-weight: bold; padding: 10px 20px;border: none; border-radius: 3px; cursor: pointer;">
</form>
        

        
    
       
    </body>
</html>
