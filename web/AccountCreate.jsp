<%-- 
    Document   : AccountCreate
    Created on : Dec 1, 2017, 3:36:38 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action = "AccountSessionBeanEJB" method="POST">
            Name of your account: <input type = "text" name = "accname">
            <br/> 
            How much money you want to deposit?: <input type = "text" name = "money">
            <br/> 
            <input type = "submit" value = "enter" />
        </form>
    </body>
</html>
