<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${flag}">

<form action="<c:url value="/UpdateSupplier"/>" method="post">
	<table align="center">
		<tr>
			<td>Supplier Id</td>
			<td><input type="text" name="supid"
				value="${SupplierData.supplierId}" readonly="readonly" /></td>

		</tr>
		<tr>
			<td>Supplier Name</td>
			<td><input type="text" name="supname"
				value="${SupplierData.supplierName}" /></td>
		</tr>

		<tr>

			<td>Supplier Description</td>
			<td><input type="text" name="supDesc"
				value="${SupplierData.supplierDesc}" /></td>
		</tr>
           <tr>
           <td>Supplier Address</td>
           <td><input type="text" name="supAddr"
           value="${SupplierData.supplierAddr}"/></td>
           
           </tr>
		<tr>

			<td colspan="2">
				<center>
					<input type="submit" value="Update Supplier" />
				</center>
			</td>
		</tr>
	</table>
</form>

</c:if>

<c:if test="${!flag}">

<form action="<c:url value="/InsertSupplier"/>" method="post">
	<table align="center">
		<tr>
			<td>Supplier Name</td>
			<td><input type="text" name="supname" /></td>
		</tr>

		<tr>

			<td>Supplier Description</td>
			<td><input type="text" name="supDesc" /></td>
		</tr>
		<tr>
			<td>Supplier Address</td>
			<td><input type="text" name="supAddr" /></td>

		</tr>
		<tr>

			<td colspan="2">
				<center>
					<input type="submit" value=" Insert Supplier" />
				</center>
			</td>
		</tr>
	</table>
</form>









<table align="center">
	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${supplierList}" var="supplier">
		<tr>


			<td>${supplier.supplierId}</td>
			<td>${supplier.supplierName}</td>
			<td>${supplier.supplierDesc}</td>
			<td>${supplier.supplierAddr}</td>
			<td><a
				href="<c:url value = '/deleteSupplier/${supplier.supplierId}'/>">Delete</a>
				<a href="<c:url value = '/editSupplier/${supplier.supplierId}'/>">Edit</a>
			</td>
		</tr>
	</c:forEach>
</table>
</c:if>