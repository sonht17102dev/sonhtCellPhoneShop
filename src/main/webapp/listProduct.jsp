<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="leftcolumn">
	<c:forEach items="${listProduct}" var="o">
		<div class="product">
			<a href="InformationProductController?id=${o.id}"><img
				src="${o.src}" title="${o.name}"></a>
			<h4>${o.type}</h4>
			<p>${o.name}</p>
			<span>$ ${o.price}</span>
		</div>
	</c:forEach>
</div>
<div class="pagination">
	<ul>
		<li><a href="#">&laquo;</a></li>
		<c:forEach begin="1" end="${endPage}" var="i">
			<li><a href="PagingProductController?index=${i}">${i}</a></li>
		</c:forEach>
		<li><a href="#">&raquo;</a></li>

	</ul>

</div>