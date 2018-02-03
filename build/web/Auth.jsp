<%-- 
    Document   : Auth
    Created on : 12.11.2017, 15:20:49
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
        <form action = "AuthServlet" method="POST">
            login: <input type = "text" name = "login">
            <br/> 
            password: <input type = "text" name = "pass">
            <br/> 
            <input type = "submit" value = "enter" />
        </form>
        <br/> 
        <form action = "Registration.jsp" method="POST">
           <input type = "submit" value = "Registration" />
        </form>
    </body>
</html>
