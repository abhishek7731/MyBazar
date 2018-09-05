
<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>







<c:if test="${flag}">
	<form action="<c:url value="/UpdateProduct"/>" method="post">
		<table align="center">
			<tr>
				<td>Product Id</td>
				<td><input type="text" name="productid"
					value="${ProductData.productId}" readonly="readonly" /></td>

			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="productname"
					value="${ProductData.productName}" /></td>
			</tr>

			<tr>

				<td>Product Description</td>
				<td><input type="text" name="productDesc"
					value="${ProductData.productDesc}" /></td>
			</tr>
			<tr>

				<td>Product Price</td>
				<td><input type="text" name="productprice"
					value="${ProductData.price}"></td>

			</tr>

			<tr>

				<td>Product Stock</td>
				<td><input type="text" name="productstock"
					value="${ProductData.stock}"></td>

			</tr>

			<tr>
				<td>Product Supplier</td>
				<td><input type="text" name="productsupplier"
					value="${ProductData.supplierId}"></td>

			</tr>


			<tr>

				<td>Category</td>
				<td><select name="categoryId">
						<option value="0">-------Select------</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryId}">${category.categoryName}</option>
						</c:forEach>

				</select></td>

			</tr>





			<tr>

				<td colspan="2">
					<center>
						<input type="submit" value="Update Category" />
					</center>
				</td>
			</tr>
		</table>
	</form>

</c:if>
























<c:if test="${!flag}">
	<form action="<c:url value="/InsertProduct"/>" method="post" enctype="multipart/form-data">
		<table align="center" cellspacing="3">
			<tr bgcolor="pink">
				<td colspan="2"><center>Product Manager</center></td>


			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="productname"></td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td><input type="text" name="productDesc"></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name="productprice"></td>
			</tr>
			<tr>
				<td>Product Stock</td>
				<td><input type="text" name="productstock"></td>
			</tr>
			<tr>

				<td>Category</td>
				<td><select name="categoryId">
						<option value="0">-------Select------</option>
						<c:forEach items="${categoryList}" var="category">
							<option value="${category.categoryId}">${category.categoryName}</option>
						</c:forEach>

				</select></td>

			</tr>
			<tr>
				<td>Supplier ID</td>
				<td><input type="text" name="productsupplier"></td>
			</tr>
			
			

               <td>Product Image</td>
               <td><input type="file" name="file"/></td>
               
               
               </tr>
				<td colspan="2">
					<center>
						<input type="submit" value=" Insert Category" class="btn btn-info"/>
					</center>
				</td>
			</tr>

		</table>

	</form>


	<table align="center">
		<tr bgcolor="pink">
			<td>Product Id</td>
			<td>Product Name</td>
			<td>Product Description</td>
			<td>Product Price</td>
			<td>Product Stock</td>

			<td>Supplier ID</td>
			<td>Category ID</td>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
				<td>${product.supplierId}</td>
				<td>${product.categoryId}</td>
				<td><a 
					href="<c:url value = '/deleteProduct/${product.productId}'/>">Delete</a>
					<a href="<c:url value = '/editProduct/${product.productId}'/>">Edit</a>
				</td>

			</tr>






		</c:forEach>
	</table>
</c:if>


