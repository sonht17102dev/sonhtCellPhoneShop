<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- Xem chi tiết sản phẩm  
	Sử dụng JSTL để hiển thị dữ liệu trong JSP
--%>
<center>
<div class="wrapper">
	<div class="product-img">
		<img src="<c:out value="${product.src}"/>" height="420" width="327"
			title="<c:out value="${product.brand}"/>">
	</div>
	<div class="product-info">
		<div class="product-text">
			<h1>
				<c:out value="${product.name}" />
			</h1>
			<h2>
				<c:out value="${product.type}" />
			</h2>
			<p>
				Product Description:
				<c:out value="${product.description}" />
			</p>
			<p><span><c:out value="${product.price}" />$</span></p>
		</div>
		<div class="product-price-btn">
			<form action="${pageContext.request.contextPath}/addtocart"
				method="get" style="margin-top: -17px;">
				<input type="hidden" name="id" value="${product.id}" /> 
				<input
					type="hidden" name="action" value="add" />
				<div class="form-group mb-1">
					<button type="button" class="quantity-button" name="subtract"
						onclick='javascript: subtractQty();' value="-">-</button>
					<input type="text" class="quantity-field" name="quantity" value="1"
						id='qty' />
					<button type='button' class="quantity-button" name='add'
						onclick='javascript: document.getElementById("qty").value++;'
						value='+'>+</button>
						<br>
					<button id="btn-addtocart" class="btn btn-success" type="submit">Add to cart</button>
				</div>
			</form>
		</div>
	</div>
</div>
</center>

<script src="js/quantity.js">
</script>