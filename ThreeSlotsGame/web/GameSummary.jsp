<%-- 
    Document   : GameSummary
    Created on : 08 Mar 2026, 1:40:02 AM
    Author     : aobak
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Game Summary</title>
    </head>
    <body>
        <h1>SUMMARY!</h1>
        <%  String Name = (String)session.getAttribute("name"); 
            Integer Games= (Integer)session.getAttribute("TotalGames");
            List<String> Wins = (List<String>)session.getAttribute("OutComes"); 
            Integer Balance = (Integer)session.getAttribute("Balance");
            List<List<Integer>> Numbers =  (List<List<Integer>>)session.getAttribute("Numbers");
                      
 %>                     
                        
                   <ul>       
                          
                   <li>Player Name: <%=Name %> </li>  
                  <li>Total Games: <%=Games%> </li> 
            
                    </ul>
                    <br /> 
                  <table border="1">
    <tr>
        <th><b>Slot One</b></th>
        <th><b>Slot Two</b></th>
        <th><b>Slot Three</b></th>
        <th><b>Outcome</b></th>
    </tr>

        <%
           
                 for (int i = 0; i < Numbers.size(); i++) {
                   List<Integer> row = Numbers.get(i);
                    String outcome = Wins.get(i);   %>
    
                <tr>
                   <td><%= row.get(0) %></td>
                    <td><%= row.get(1) %></td>
                    <td><%= row.get(2) %></td>
                    <td><%= outcome %></td>
                </tr>
             <%
                 }   %>
               
</table>
                              
                                               
        
            
             <form action="EndSessionServlet.do" method="post">
                 <input type="submit" value="Logout">
          
    </body>
</html>
