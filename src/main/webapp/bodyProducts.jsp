<div class="row container">
	<div class="leftcolumn">
		<c:forEach items="${products}" var="o">
			<div class="product">
				<a href="InformationProductController?id=${o.id}"><img
					src="${o.src}" title="${o.name}"></a>
				<h4>${o.type.toUpperCase()}</h4>
				<p>${o.name}</p>
				<span style="color: red;">$ ${o.price}</span>
			</div>
		</c:forEach>
	</div>
	
</div>