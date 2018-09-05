<%@ page language="java" contentType="text/html"%>
<%@ include file="Header.jsp"%>


<div class="container">
	<table class="table">
		<tr>
			<td colspan="6"><center>
					<h3>Your Oder</h3>
				</center></td>
		</tr>

		<tr bgcolor="orange">
			<td colspan="4">Total Purchase Amount</td>
			<td>INR.${totalPurchaseAmount}/-</td>
		</tr>

</table>
<br/><br/><br/>


		<div class="container">
		<form action="<c:url value="/paymentProcess"/>" method="post">
			<table class="table" align="center" width="50%">
				<tr>
					<td colspan="2">Payment Option</td>
				</tr>

				<tr> 
					<td colspan="2"><input type="radio" name=paymenttype
						" value="CC" />Credit Card <input type="radio" name=paymenttype
						" value="CDD" />Cash On Delivery</td>

				</tr>
				<tr>
					<td>Card No :</td>
					<td><input type="text" name="cardno" required /></td>
				</tr>
				<tr>
					<td>CW</td>
					<td><input type="text" name="cvv" /></td>
				</tr>


				<tr>
					<td>Valid Upto</td>
					<td><input type="text" name="valid" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Payment" /></td>
				</tr>
			</table>
		</form>
		</div>
		</div> 