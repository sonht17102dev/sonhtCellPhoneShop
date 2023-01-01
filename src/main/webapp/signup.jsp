<%@page import="java.util.Arrays"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link rel="stylesheet" type="text/css" href="css/signup.css">
<title>Sign up</title>
</head>
<body>
	<div class="container">
		<div class="left">
			<h1>Register</h1>
			<form name="signup-form" action="signup" method="post">
				<div>
					<input type="text" name="username" class="input-box"
						placeholder="Input your username">
				</div>
				<div>
					<input type="text" name="address" class="input-box"
						placeholder="Input your address">
				</div>
				<div>
					<input type="text" name="phone" class="input-box"
						placeholder="Input your phone">
				</div>
				<div>
					<input type="text" name="usermail" class="input-box"
						placeholder="Input your email">
				</div>
				<div>
					<input type="password" name="password" class="input-box"
						placeholder="Input your password">
				</div>
				<div>
					<input type="password" name="repassword" class="input-box"
						placeholder="Reinput your password">
				</div>
				<div>
					<input class="submit-button" type="submit" value="Register Now" style="background: green;">
				</div>
			</form>
		</div>
		<div class="right">
			<div class="content">
				<h1 style="${error!=null?"color:red;": ""}">${error==null?"Welcome new partner!": "Error"}
				</h1>
				<p style="${error!=null?"color:red;": ""}">
				${error==null ? "To keep connected with us <br>please input with your personal info<br>" : error}
				
				</p>
				<p style="${message!=null?"color:red;": ""}">${message}</p>
			</div>
		</div>
	</div>

</body>
<footer> </footer>
</html>