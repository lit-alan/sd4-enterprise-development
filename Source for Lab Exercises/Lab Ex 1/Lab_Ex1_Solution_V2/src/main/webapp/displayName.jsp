<%@page import="beans.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanks</title>
    </head>
    <b></b>
        <h2>Thanks <%=request.getAttribute("name")%> for submitting your details</h2>
        <h3>Click <a href="viewAgain.jsp">here</a>  to view your details again</h3>
    </body>
</html>
