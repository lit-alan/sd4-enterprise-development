<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<html>
<head>
    <title>Email Address App</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>Join Our Email List</h1>

<p>To join our email list, enter your name and email address below, </p>

<form action="display_email_entry.jsp" method="get">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right"> First name: </td>
            <td><input type="text" name="firstName"> </td>
        </tr>

        <tr>
            <td align="right"> Last name: </td>
            <td><input type="text" name="lastName"> </td>
        </tr>

        <tr>
            <td align="right"> Email address: </td>
            <td><input type="text" name="emailAddress"> </td>
        </tr>
        <tr>
            <td></td>
            <td><br><input type="submit" value="Submit"> </td>
        </tr>



    </table>
</form>
</body>
</html>
