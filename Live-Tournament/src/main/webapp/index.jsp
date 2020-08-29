<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.io.*,javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<title>LiveScoreApp</title>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="939678263258-ohvm8sbripnn4acjevrka1ucmfejorm7.apps.googleusercontent.com">
</head>

 

<body>


<div class="g-signin2" data-onsuccess="onSignIn" id="myP" ></div>

<img id="myImg"><br>
<p id="name"></p> 
<div id="status"></div>

<script type="text/javascript">
		function onSignIn(googleUser) {
			//alert('test');
		// window.location.href='success.jsp';
			  var profile = googleUser.getBasicProfile();
			  //var profile = auth2.currentUser.get().getBasicProfile();
			  var imagurl=profile.getImageUrl();
			  var name=profile.getName();
			  var email=profile.getEmail();
			  var givenName = profile.getGivenName ();
			  window.familyName = profile.getFamilyName();
			  var id_token =  googleUser.getAuthResponse().id_token
			  localStorage.setItem("Token", id_token);
			  //alert(id_token);
			  document.getElementById("myImg").src = imagurl;
			  document.getElementById("name").innerHTML = name;
			  
			  //window.location.replace("http://localhost:3000/");
			  
 			  var url = '<a href="data.jsp?email='+email+'&name='+name+'&givenName='+givenName+'&familyName='+familyName+'">Continue with Google login</a>'
			  document.getElementById("myP").style.visibility = "hidden";
			  
			  document.getElementById("status").innerHTML = 'Welcome '+name+'!' + url
			  
 			  /*var redirectUrl = 'data';
 			  var form = $('<form action="' + redirectUrl + '" method="post">' +
                       '<input type="text" name="id_token" value="' +
                        googleUser.getAuthResponse().id_token + '" />' +
                                                             '</form>');
      $('body').append(form);
      form.submit(); */
			  
			  }
</script>



                                  
<%-- <% 
	String name = (String)request.getParameter("name");
	request.setAttribute("name", name);
	String givenName = (String)request.getParameter("givenName");
	request.setAttribute("givenName", givenName);
	out.println(name + " " + givenName);
	RequestDispatcher rd  = request.getRequestDispatcher("data");
	response.sendRedirect("data"); 
%> --%>


<!-- <button onclick="myFunction()">Sign Out</button>

<script>
function myFunction() {
	gapi.auth2.getAuthInstance().disconnect();
    location.reload();
}
</script>
  -->
<button onclick="myFunction()">Sign Out</button>

<script>
function myFunction() {
	gapi.auth2.getAuthInstance().disconnect();
    location.reload();
}
</script>

</body>
</html>