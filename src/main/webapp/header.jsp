<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="header">
		<div class="left-header">
			<h1>CELLPHONE S</h1>
			<c:if test="${sessionScope.acc == null}">
				<h2>Welcome to my Webside</h2>
			</c:if>
			<c:if test="${sessionScope.acc != null}">
				<h2>Welcome ${sessionScope.acc.name}</h2>
			</c:if>
		</div>
		<div class="right-header">
			<div class="dropdown">
				<button onclick="myFunction()" class="dropbtn">
					Categories <i class="fa fa-caret-down" aria-hidden="true"></i>
				</button>
				<div id="myDropdown" class="dropdown-content">
					<a href="/PRJ321x-A3/search2?name=iPhone 11">iPhone 11</a> 
					<a href="/PRJ321x-A3/search2?name=iPhone X">Iphone X</a> 
					<a href="/PRJ321x-A3/search2?name=iPhone 7">Iphone 7</a>
				</div>
			</div>
			<div class="form-search">
				<form action="search" method="post">
					<%-- Sử dụng EL inputSearch để lưu trữ dữ liệu nhập vào trên form search --%>
					<input value="${inputSearch}" name="txt" type="text"
						placeholder="What are you looking for?" class="search-bar">
					<button type="submit" class="btn-secondary button-search" style="width: 52px; height:52px; background: orange;padding: 0; font-family: auto;">
						<i class="fa fa-search"></i>
					</button>

				</form>
			</div>

		</div>
	</div>
	<div class="topnav">
		<a href="home">Home</a> <a href="list">Products</a>
		<c:if test="${sessionScope.acc == null}">
			<a href="login.jsp" style="float: right;">Log in</a>
		</c:if>
		<a href="signup.jsp" style="float: right;">Register</a>
		<c:if test="${sessionScope.acc != null}">
			<a href="LogOutServlet" style="float: right;">Log out</a>
			<c:if test="${sessionScope.cart != null}">
			<a href="ShowCartController" style="float: right;">Cart <i class="fa fa-shopping-cart"></i></a>
			</c:if>
		</c:if>
	</div>
</div>
	<script type="text/javascript" src="js/dropdown.js"></script>