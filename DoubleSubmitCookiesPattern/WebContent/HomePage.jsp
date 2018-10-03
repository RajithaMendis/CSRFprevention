<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>

<form action="homePageController" method="POST" >  
	
    <!-- SessionID:<%= session.getAttribute("sessionID") %></br>

    CSRF Token:<%= session.getAttribute("csrfToken") %></br> -->
    
    Enter Your Details
    <br>
    Email Address<input type="text"  id="email" name="email">
    
	<input type="submit" value="Submit Request">
	
</form>

</body>
</html>