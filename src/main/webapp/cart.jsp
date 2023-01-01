<%@page import="model.CartDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Product"%>
<%@ page import="model.Cart"%>
<%@ page import="model.CartDetails"%>
<%
	Cart c = (Cart) session.getAttribute("cart");
	List<CartDetails> productList = c.getItems();
	int size = productList.size();
	pageContext.setAttribute("productList", productList);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/cart.css">
<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/footer.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Cart</title>
</head>
<body>

	<c:import url="header.jsp" />

	
	<div class="row justify-content-center p-3 md-2 box" >
	<c:set var="p" value="${sessionScope.cart.items}" scope="page" />
	<div style="overflow-x:auto;">
		<table class="table table-light carttable" >
			<thead>
				<th>Product in cart: ${p.size()}</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Amount</th>
				<th>Setting</th>
			</thead>
			<c:forEach var="i" items="${p}">
				<tr>
					<td><c:out value="${i.product.name}"/><br> <span>ID: <c:out value="${i.product.id}"/></span></td>
					<td>($) <c:out value="${i.product.price}"/></td>
					<td>${i.quantity}</td>
					<td>($) <c:out value="${i.amount}"/></td>
					<td>
					
					<a class="danger"
						href="AddToCartController?id=${i.product.id}&action=delete">Remove</a>
					
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="10">Total : <c:out
						value="${sessionScope.cart.amount}" />
				</td>
			</tr>
		</table>
		</div>
		<div>
		<form class="payform" action="PayController" method="post">
			<label class="col-3" for="name">Customer Name</label> <input
				class="col-6" type="text" id="name" name="name"><br> <label
				class="col-3" for="address">Customer Address</label> <input
				class="col-6" type="text" id="address" name="address"><br>
			<label class="col-3" for="discount">Discount code (if any) </label> <input
				class="col-6" type="text" id="discount" name="discount"><br>
			<input type="submit" class="btn-submit center"></input>
			<div class="error">
				<%
				String error = (String) session.getAttribute("error");
				if (error != null) {
					response.getWriter().println(error);
				}
				%>
			</div>
		</form>
		</div>
	</div>
</body>
<footer> <%@include file="footer.jsp"%>

</footer>
</html>