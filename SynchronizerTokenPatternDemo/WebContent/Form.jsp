<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body onload="checkParams()">

	<form action="formController" method="POST" id="popup-validation" >  
	
		<input type="hidden" id="csrfVal" name="csrfVal">
		System has set the CSRF Token Value for the Session as a hidden variable
	    <div class="item-input"><input type="hidden" id="sessionKey" name="sessionKey" ></div>
		<br>
		Click the button to complete the action.
		<a href="#" class="btn btn-success btn-lg btn-flat" onclick="javascript:fnClick();return false;">Submit</a>
	</form>
	
<script type="text/javascript" src="vendors/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function checkParams() 
	{
 	  <%
		String sid = null;
		Cookie[] myCookies = request.getCookies();
		if(myCookies != null)
		{
		  for(Cookie tempCookie:myCookies)
		  {
			if("myApp.sessionID".equals(tempCookie.getName()))
			{
				sid = tempCookie.getValue();
				break;
			}
		  }
	    }
      %>
	    var sessionID = "<%=sid%>";
	    $.ajax({
				type : "POST",
				url : "Controller",
				dataType : "json",
				data : { sessionID : sessionID },
				success : function(result) {
					var csrfValue = result;
					document.getElementById('csrfVal').value = csrfValue;
					alert("CSRF Token Created For The Session::"+csrfValue)
				}
		      });
     }


     function fnClick()
      {
	   <%
		 String cookieSid = null;
		 Cookie[] Cookies = request.getCookies();
		 if(Cookies != null)
		 {
		  for(Cookie tempCookie:Cookies)
		  {
			if("myApp.sessionID".equals(tempCookie.getName()))
			{
				cookieSid = tempCookie.getValue();
				break;
			}
		  }
	     }
	    %>
	   var cookieSid = "<%=cookieSid%>";
	
	   alert("Click");
	   document.getElementById('sessionKey').value = cookieSid;
	   var a=document.getElementById('csrfVal').value;
	   //alert(a+"::"+cookieSid)
       $('#popup-validation').submit();
     }
</script>
</body>
</html>