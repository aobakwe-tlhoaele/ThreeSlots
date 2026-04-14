<%-- 
    Document   : StartSession
    Created on : 07 Mar 2026, 3:20:13 PM
    Author     : aobak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Session Page</title>
    </head>
    <body>
        <h1>USER LOGIN</h1>
        
        <form action = "StartSessionServlet.do" method="POST">
            
            <p>Please enter your name : <input type="text" name = "name" ></p>   
            <p>Please deposit into your account : <input type="number" name = "Deposit" ></p>  
                <input type="submit" value="PROCEED"
                        style="background-color: black;color: white;font-size: 14px; font-weight: bold; padding: 10px 20px;border: none; border-radius: 3px; cursor: pointer;">           
        </form>
    </body>
</html>
