<%-- 
    Document   : Outcome
    Created on : 07 Mar 2026, 11:46:40 PM
    Author     : aobak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>GAME RESULTS!</h1>
        
      <%  Integer result = (Integer)request.getAttribute("Result");
          Integer Balance = (Integer)session.getAttribute("Balance");
          String Message = (String)request.getAttribute("Message");%>
          
         <p style="font-weight: bold; font-size: 20px;">
          <%= Message %><%= result %> </p>
          <p>Amount Added to Balance: R<%=result%></p>
            <p>Your current balance: R<%=Balance%></p>
      <form action="GenerateSlotServlet.do" method="post">
          <input type="submit" value="PLAY AGAIN!!" 
                  style="background-color: black;color: white;font-size: 14px; font-weight: bold; padding: 10px 20px;border: none; border-radius: 3px; cursor: pointer;">
     </form>
      
      <form action="GameSummary.jsp" method="post">
          <input type="submit" value="SUMMARY!!"
                 
    style="background-color: grey;color: white;font-size: 14px; font-weight: bold; padding: 10px 20px;border: none; border-radius: 3px; cursor: pointer;">
     </form>
                        
     
    </body>
</html>
