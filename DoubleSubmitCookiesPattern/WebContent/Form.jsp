<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onload="checkParams()">

	<form action="formController" method="POST" id="popup-validation"> 
	 
		<input type="hidden" id="csrfVal" name="csrfVal">
		<div class="item-input">
			<input type="hidden" id="csrfTokenVal" name="csrfTokenVal" ></div>
		<a href="#" class="btn btn-success btn-lg btn-flat" onclick="javascript:fnClick();return false;">Submit</a>
	</form>
	
<script type="text/javascript" src="vendors/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function checkParams() 
	{
 	  <%
		String csrfVal = null;
		Cookie[] tokenCookies = request.getCookies();
		if(tokenCookies != null)
		{
		  for(Cookie tempCookie:tokenCookies)
		  {
			if("myApp.tokenID".equals(tempCookie.getName()))
			{
				csrfVal = tempCookie.getValue();
				break;
			}
		  }
	    }
      %>
	    var csrfValue = "<%=csrfVal%>";
	    document.getElementById('csrfVal').value = csrfValue;
	    document.getElementById('csrfTokenVal').value = csrfValue;
		
	    
     }


     function fnClick()
      {
	   <%
		 String cookieVal = null;
		 Cookie[] Cookies = request.getCookies();
		 if(Cookies != null)
		 {
		  for(Cookie tempCookie:Cookies)
		  {
			if("myApp.tokenID".equals(tempCookie.getName()))
			{
				cookieVal = tempCookie.getValue();
				break;
			}
		  }
	     }
	    %>
	   var cookieValue = "<%=cookieVal%>";
	
	   alert("Click");
	   //document.getElementById('sessionKey').value = cookieSid;
	  // var a=document.getElementById('csrfVal').value;
	  // alert(a+"::"+cookieSid)
       $('#popup-validation').submit();
     }
</script>
</body>
</html>