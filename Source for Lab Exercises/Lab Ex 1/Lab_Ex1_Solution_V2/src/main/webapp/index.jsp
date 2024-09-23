<%@page import="beans.Customer"%>
<%@ page import="java.util.Arrays" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Please Send Us Your Details</title>
</head>

<% Customer c = (Customer) session.getAttribute("customer");

if (c == null) {
    c = new Customer();
}

%>
<body>
<form id="detailsForm" name="detailsForm" method="post" action="HandleForm">
  <h2>Please Send Us Your Details.</h2>
  <table width="730" border="0">
    <tr>
      <td width="266">Name</td>
      <td width="454"><input name="name" type="text" id="name" size="50" value="<%= c.getName()%>" /></td>
    </tr>
    <tr>
      <td height="31">Address</td>
      <td><input name="address" type="text" id="address" size="50" value="<%= c.getAddress()%>" /></td>
    </tr>
    <tr>
      <td>City</td>
      <td><input type="text" name="city" id="city" value="<%= c.getCity() %>" /></td>
    </tr>
     <tr>
      <td>Country</td>
      <td><input type="text" name="country" id="country" value="<%= c.getCountry()%>" /></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="phone" id="phone" value="<%= c.getPhone()%>" /></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="email" id="email" value="<%= c.getEmail()%>" /></td>
    </tr>
    <tr>
      <td>EU Status</td>
      <td><p>
        <label>
          <label>EU</label>
          <input type="radio" id="eu" name="eu" value="eu" <%= (c.getEu() == null || c.getEu().equals("eu")) ? "checked='checked'" : "" %> >

          <label>Non EU</label>
          <input type="radio" id="noneu" name="eu" value="noneu" <%= (c.getEu() != null && c.getEu().equals("noneu")) ? "checked='checked'" : "" %> >
<!--
Check for null on the first load: The condition c.getEu() == null ensures that when the page is loaded for the first time and c.getEu() is not set, the "EU" radio button will be selected by default.
Non-EU only if noneu is selected: The "Non EU" radio button will only be selected if c.getEu().equals("noneu"), meaning if the user has previously selected "Non EU" and it is reflected in c.getEu().
-->
      </p>
      </td>
    </tr>
    <tr>
      <td>How Did You Hear About Us?</td>
      <td>
        Twitter
        <input name="check" type="checkbox" id="check" value="twitter"
                <%= (c.getHearOptions() != null && Arrays.asList(c.getHearOptions()).contains("twitter") ? "checked='checked'" : "") %> />

        Facebook
        <input name="check" type="checkbox" id="check" value="facebook"
                <%= (c.getHearOptions() != null && Arrays.asList(c.getHearOptions()).contains("facebook") ? "checked='checked'" : "") %> />

        Newspaper
        <input name="check" type="checkbox" id="check" value="newspaper"
                <%= (c.getHearOptions() != null && Arrays.asList(c.getHearOptions()).contains("newspaper") ? "checked='checked'" : "") %> />

        Radio
        <input name="check" type="checkbox" id="radio" value="radio"
                <%= (c.getHearOptions() != null && Arrays.asList(c.getHearOptions()).contains("radio") ? "checked='checked'" : "") %> />

        Other
        <input name="check" type="checkbox" id="check" value="other"
                <%= (c.getHearOptions() != null && Arrays.asList(c.getHearOptions()).contains("other") ? "checked='checked'" : "") %> />
      </td>
    </tr>
    <tr>
      <td>Comments</td>
      <td><label for="comments"></label>
        <textarea name="comments" id="comments" cols="45" rows="5"><%= c.getComments()%> </textarea></td>
    </tr>
    <tr>
      <td><input type="submit" name="submit" id="submit" value="Submit" /></td>
      <td><input type="reset" name="clear" id="clear" value="Clear" /></td>
    </tr>
  </table>
</form>
</body>
</html>
