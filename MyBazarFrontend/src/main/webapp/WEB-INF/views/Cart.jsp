<%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp"%>


<div class="container">
	<table class="table">
		<tr>
		<td colspan="6"><center><h3> Shopping Cart</h3></center></td>
		</tr>
		
		<tr>
			<td>SL #</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
			<td>Operation</td>

		</tr>
<c:set value="1" var="x"/>
<c:if test="${empty cartItems}">
<tr><td colspan="6"><center>!!!Cart Item Is Empty!!!</center></td></tr>
</c:if>
     <c:if test="${cartItems!=null}">
		<c:forEach items="${cartItems}" var="cartItem">
			<form
				action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>"
				method="get">
				<tr>
					<td>${x}</td>
					<td>${cartItem.productName}</td>
					<td><input type="text" name="quantity" value="${cartItem.quantity}" /></td>
					<td>${cartItem.price}</td>
					<td>${cartItem.quantity * cartItem.price}</td>
					<td><input type="submit" value="Update" class="btn btn-info" />
						<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>"
						class="btn btn-danger">Delete</</a></td>
				</tr>
			</form>
			<c:set value="${x+1}" var="x"/>
		</c:forEach>
		</c:if>

		<tr bgcolor="orange">
			<td colspan="4">Total Purchase Ammount</td>
			<td colspan="2"}>${totalPurchaseAmount}</td>
		</tr>
		<tr bgcolor="lightblue">
			<td colspan="3"><a href="<c:url value="/continueShopping"/>"
				class="btn btn-info">Continue Shopping</a></td>
			<td colspan="3"><a href="<c:url value="/checkout"/>"
				class="btn btn-info">Checkout</a></td>



		</tr>


	</table>




</div>