<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
</head>
<body>
<% 
	String err = (String)session.getAttribute("error");
	//System.out.println(err);
	Cookie[] cookies = request.getCookies();
	String name="";
	String pass="";
	for(Cookie c: cookies) {
		if(c.getName().equals("user")) 
			name = c.getValue();
		else if(c.getName().equals("password")) 
			pass = c.getValue();
		}
	//System.out.println(name);
	//System.out.println(pass);
%>
	<div class="container">
	    <div class="left">
	      <h1>Sign in</h1>
	      <form name="login-form" action="/PRJ321x-A3/login"  method="post">
	        
	        <div><input type="text" name="username" class="input-box" placeholder="Input your email" value=<%= name%>></div>
	        <div><input type="password" name="password" class="input-box" placeholder="Input your password" value=<%= pass%>></div>
	        <div><span><a href="#" title="forgot" class="forgot">Forgot your password</a></span></div>
	        
	        <div class="remember">
	          <input type="checkbox" name="remember">
	          <label for="remember">Remember me</label>
	        </div>
	        <input class="submit-button" type="submit" value="LOGIN">
	        
	      </form>
	      <a href="signup.jsp"><input class="submit-button" type="submit" value="REGISTER" style="background: green;"></a>
	    </div>
	    <div class="right">
	      <div class="content">
	        <h1><%= session.getAttribute("isNew")==null?"Welcome back!":"Error:" %></h1>
	        <p><%= session.getAttribute("isNew")==null?"To keep connected with us <br>please login with your personal info!<br>Register now if you don't have an account!":err %></p>
	        <% session.removeAttribute("isNew"); %>   <!-- the isNew is release, press F5 or open new tab, Welcome text will appear -->
	        <% session.removeAttribute("error"); %>   <!-- the isNew is release, press F5 or open new tab, Welcome text will appear -->
	      </div>
	    </div>
	</div>
</body>
</html>