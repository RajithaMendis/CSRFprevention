<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%  
    out.print("Your Cookies ");  
    Cookie mycookies[] = request.getCookies();
    for(Cookie mycookie:mycookies){
	String name = mycookie.getName();
	String value = mycookie.getValue();
%>
	Cookie Name : <b><%=name %> </b><br>
    Cookie Value :<b><%=value %></b><br>
<%}%> 

<form action="homePage" method="POST" >  
	
    Submit The Button to Go to The Next Page.
    <input type="submit" value="Submit Request">
	
</form>
</body>
</html>