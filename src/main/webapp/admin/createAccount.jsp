<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<div class="left">
			<h1>Create new account</h1>
			<form name="signup-form" action="/PRJ321x-A3/CreateAdmin" method="post">
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
</body>
</html>