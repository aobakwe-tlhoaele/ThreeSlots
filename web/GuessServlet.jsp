<%-- 
    Document   : GuessServlet
    Created on : 07 Mar 2026, 6:15:08 PM
    Author     : aobak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guess Page</title>
    </head>
    <body>
        <h1>LET US PLAY!</h1>
        
        <% Integer SlotOne = (Integer)request.getAttribute("Slot1"); 
        Integer SlotTwo = (Integer)request.getAttribute("Slot2");
        Integer SlotThree = (Integer)request.getAttribute("Slot3");
        Integer Balance = (Integer)session.getAttribute("Balance");%>
        
        <table border="1" cellpadding="8" cellspacing="0">
            <tr>
                <td>SLOT ONE</td>
                  <td>SLOT TWO</td>
                    <td>SLOT THREE</td>
            </tr>  
            <tr>
                <td><%=SlotOne %></td>
                  <td><%=SlotTwo %></td>
                    <td><%=SlotThree %></td>
            </tr>              
        </table>
                    <div> <p>Remaining Balance: R <%=Balance %> </p></div>
  
   <form action="OutComeSevlet.do" method="post">
    <input type="submit" value="OUTCOME"
           style="background-color: black;color: white;font-size: 14px; font-weight: bold; padding: 10px 20px;border: none; border-radius: 3px; cursor: pointer;"> 
</form>
                    

    </body>
</html>
