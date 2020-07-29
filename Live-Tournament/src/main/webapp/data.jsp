<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	String name=(String)request.getParameter("name");
	String email=(String)request.getParameter("email");
	//String givenName = request.getAttribute("givenName");
	String givenName = (String)request.getParameter("givenName");
	String familyName = (String)request.getParameter("familyName");
	request.setAttribute("name", name);
	request.setAttribute("email", email);
	request.setAttribute("givenName", givenName);
	request.setAttribute("familyName", familyName);
	
	//System.out.println(familyName);
	//request.setAttribute("familyName",familyName);
	RequestDispatcher rd  = request.getRequestDispatcher("data");
	rd.forward(request,response); 
%>


</body>
</html>