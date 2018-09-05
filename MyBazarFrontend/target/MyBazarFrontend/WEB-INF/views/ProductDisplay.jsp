<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp"%>
<h1>Product Display</h1>
<div class="row">
<c:forEach items="${productList}" var="product">

	
		<div class="col-sm-6 col-md-4">
			<div class="thumbnail">
				<h4>
				<span data-toggle="tooltip" title="Bootstrap version">${product.productName} &nbsp; ${product.price}/-</span>
				</h4>
				<img
					src="<c:url value="/resources/images/${product.productId}.jpg "/>" width="150" height="150"
					alt="Image not Supported"> 
					<a href="<c:url value="/totalProductInfo/${product.productId}"/>"
					class="btn btn-primary col-xs-12" role="button">Click For Large</a>
				<div class="clearfix"></div>
			</div>
		</div>


	
</c:forEach>

</div>




















</body>
</html>