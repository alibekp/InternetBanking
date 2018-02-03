<%-- 
    Document   : Registration
    Created on : 12.11.2017, 15:52:37
    Author     : Alibek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action = "ClientSessionBeanEJB" method="GET">
            Your login: <input type = "text" name = "login">
            <br/> 
            Your password: <input type = "text" name = "pass">
            <br/> 
            Your first name: <input type = "text" name = "firstname">
            <br/> 
            Your last name: <input type = "text" name = "lastname">
            <br/> 
            <input type = "submit" value = "Registration!" />
        </form>
    </body>
</html>
