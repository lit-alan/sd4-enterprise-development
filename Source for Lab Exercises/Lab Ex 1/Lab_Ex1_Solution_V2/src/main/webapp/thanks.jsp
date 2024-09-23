<%-- 
    Document   : thanks
    Created on : 03-Oct-2017, 17:24:36
    Author     : Alan.Ryan
--%>

<%@page import="beans.Customer"%>
<%@page import="data.CustomerIO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanks</title>
    </head>
    <body>
      <h1>Thanks! Your details have been saved</h1>


        <form id = "home" name="home" method="post" action="index.jsp">

            <input type="submit" name="submit" id="submit" value="Home" />
        </form>
    </body>
</html>
