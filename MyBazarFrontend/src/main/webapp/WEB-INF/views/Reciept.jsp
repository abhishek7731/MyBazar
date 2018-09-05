   <%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp"%>


<div class="container">
	<table class="table">
		<tr>
			<td colspan="5"><center>
					<h3>Reciept</h3>
				</center></td>
		</tr>
		
		<tr>
		
		<td colspan="2">OderID</td>
		<td>${oderID}</td>
		<td></td>
	
		<td colspan="2">Oder Date</td>
		<td>${oderDATE}</td>
		</tr>
		

		
		
		<tr bgcolor="lightblue">
			<td>SL #</td>
			<td>Product Name</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Total Price</td>
			

		</tr>
	
<c:set value="1" var="x"/>
<c:if test="${empty cartItems}">
<tr bgcolor="pink "><td colspan="5"><center><h4>!!!Cart Item Is Empty!!!</h4></center></td></tr>
</c:if>
     <c:if test="${not empty cartItems}">
		<c:forEach items="${cartItems}" var="cartItem">
			<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>"
				method="get">
				<tr>
					<td>${x}</td>
					<td>${cartItem.productName}</td>
					<td>"${cartItem.quantity}"</td>
					<td>${cartItem.price}</td>
					<td>${cartItem.quantity * cartItem.price}</td>
				
				</tr>
		
			<c:set value="${x+1}" var="x"/>
		</form>
		</c:forEach>
		</c:if>

		<tr bgcolor="orange">
			<td colspan="3">Total Purchase Ammount</td>
			<td colspan="2">${totalPurchaseAmount}</td>
		</tr>
		
		<tr bgcolor="cyan">
		<td colspan="6"><center><h4> Thanks For Shopping, Hope To See You Again!!!</h4></center> </td>
		
		
		</tr>

</table>

<br/><br/><br/>
</div>
   