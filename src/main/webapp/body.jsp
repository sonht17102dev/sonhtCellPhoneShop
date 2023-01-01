<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<%@page import="dao.ListProductDAO"%>
<%@page import="model.Product"%>

<%-- Thực hiện phân trang --%>
<%
	ListProductDAO dao = new ListProductDAO();
	int countPage = dao.getTotalProduct();
	int pageSize = 6;
	int endPage = countPage / pageSize;
	if (countPage % pageSize != 0) {
		endPage++;
	}
%>
<%-- Thực hiện phân trang --%>
<div class="row container">
	<div class="pagination" style="${sessionScope.error != null ? "display:none;" : ""}">
		<ul>
			<li><a class="${(tag==null||tag==1) ? "
				hidden" : "" }" href="PagingProductController?index=${tag - 1}">&laquo;</a></li>
			<c:forEach begin="1" end="<%=endPage %>" var="i">
			<%-- <c:forEach begin="1" end ="${endP}" var="i">--%>
				<li><a class='${tag == i ? "active" : ""}' href="PagingProductController?index=${i}">${i}</a></li>
			</c:forEach>
			<li><a class='${tag==2 ? "hidden" : "" }' href="PagingProductController?index=${tag + 1}">&raquo;</a></li>

		</ul>
	</div>
	<div class="leftcolumn" >
		<div>
			<%
			session.removeAttribute("error");
			%>
			<p>
			<%
			String error = (String) session.getAttribute("error");
			
			if (error != null) {
				response.getWriter().println(error);
			}
			%>
			
		</div>
		<%-- Hiển thị danh sách sản phẩm có sử dụng JSTL --%>
		<c:forEach items="${listProduct}" var="o">
			<div class="product">
				<a href="InformationProductController?id=${o.id}"><img 
					src="${o.src}" title="${o.name}"></a>
				<h4><c:out value="${fn:toUpperCase(o.type)}"/></h4>
				<p>${o.name}</p>
				<span style="color: red;">$ <fmt:formatNumber value="${o.price}" maxFractionDigits="2"/></span>
			</div>
		</c:forEach>

	</div>

</div>
