<%-- 
    Document   : HomePage
    Created on : 12.11.2017, 16:39:54
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
        <h1>Hello</h1>
        <form action = "AccountCreate.jsp" method="POST">
           <input type = "submit" value = "create account" />
        </form>
        </br>
        <form action = "Deposit" method="POST">
           <input type = "submit" value = "Deposit" />
        </form>
        </br>
        <form action = "Withdraw.jsp" method="POST">
           <input type = "submit" value = "Withdraw" />
        </form>
        </br>
        <form action = "Transfer.jsp" method="POST">
           <input type = "submit" value = "Transfer" />
        </form>
         </body>
</html>
