<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/body.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/footer.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title></title>

</head>
<body>
	<c:import url="header.jsp" />
	<div class="row container">
		<div class="leftcolumn">
			<c:choose>
				<c:when test="${list7 != null}">
					<c:forEach items="${list7}" var="o7">
						<div class="product">
							<a href="InformationProductController?id=${o7.id}"><img
								src="<c:out value="${o7.src}" />" title="<c:out value="${o7.name}" />"></a>
							<h4><c:out value="${o7.type.toUpperCase()}" /></h4>
							<p><c:out value="${o7.name}" /></p>
							<span style="color: red;">$ <c:out value="${o7.price}" /></span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${list11 != null}">
					<c:forEach items="${list11}" var="o11">
						<div class="product">
							<a href="InformationProductController?id=${o11.id}"><img
								src="<c:out value="${o11.src}" />" title="<c:out value="${o11.name}" />"></a>
							<h4><c:out value="${o11.type.toUpperCase()}" /></h4>
							<p><c:out value="${o11.name}" /></p>
							<span style="color: red;">$ <c:out value="${o11.price}" /></span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${listX != null}">
					<c:forEach items="${listX}" var="oX">
						<div class="product">
							<a href="InformationProductController?id=${oX.id}"><img
								src="<c:out value="${oX.src}" />" title="<c:out value="${oX.name}" />"></a>
							<h4><c:out value="${oX.type.toUpperCase()}" /></h4>
							<p><c:out value="${oX.name}" /></p>
							<span style="color: red;">$ <c:out value="${oX.price}" /></span>
						</div>
					</c:forEach>
				</c:when>
				<c:when test="${listProduct != null}">
					<c:forEach items="${listProduct}" var="o">
						<div class="product">
						<a href="InformationProductController?id=${o.id}"><img
							src="<c:out value="${o.src}" />" title="<c:out value="${o.name}" />"></a>
						<h4><c:out value="${o.type.toUpperCase()}" /></h4>
						<p><c:out value="${o.name}" /></p>
						<span style="color: red;">$ <c:out value="${o.price}" /></span>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
				<p/>
				<c:set var="error" scope="session" value="${sessionScope.error}"/>
					
					${error == null ? "" : error}
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
<footer> <c:import url="footer.jsp"/>
</footer>
</html>