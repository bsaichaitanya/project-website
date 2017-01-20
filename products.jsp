<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
	<h1>Add a Product</h1>

	<c:url var="addAction" value="/manageProductAdd"></c:url>

	<form:form action="${addAction}" commandName="product"  method="post" >
	
	<table>
			<tr>
				<td><form:label path="productID"><spring:message text="ID" /></form:label></td>
				<c:choose>
					<c:when test="${!empty product.productID}">
						<td><form:input path="productID" value="" disabled="true" readonly="true" />
						</td>
					</c:when>
					<c:otherwise>
						<td><form:input path="productID" pattern=".{5,20}" required="true"
								title="productID should contain 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<form:input path="productID" hidden="true" />
				<td>
					<form:label path="name">
						<spring:message text="Name" />
					</form:label>
				</td>
				<td><form:input path="name" required="true" /></td>
			</tr>

			<tr>
				<td>
					<form:label path="description">
						<spring:message text="Description" />
					</form:label>
				</td>
				<td><form:input path="description" required="true" /></td>
			</tr>

			<tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
				<td><form:select path="supplier.name" items="${supplierList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category.name" items="${categoryList}"
						itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td><form:label path="price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="price" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="stock">
						<spring:message text="Stock" />
					</form:label></td>
				<td><form:input path="stock" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="size">
						<spring:message text="Size" />
					</form:label></td>
				<td><form:input path="size" required="true" /></td>
			</tr>
			
			<tr>
				<td align="left"><form:label path="image">
						<spring:message text=" Image" />
					</form:label></td>
				<td align="left"><form:input type="file" name="image" path="image" /></td>
			</tr>
			
			
			
			<tr>
				<td colspan="2"><c:if test="${!empty product.name}">
						<input type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
	
	</table>
	</form:form>
	
	
	<h3>Product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Description</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="80">Price</th>
				<th width="60">Size</th>
				<th width="60">Stock</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.productID}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.category.name}</td>
					<td>${product.supplier.name}</td>
					<td>${product.price}</td>
					<td>${product.size}</td>
					<td>${product.stock}</td>
					<td><a href="<c:url value='manageProductEdit/${product.productID}' />">Edit</a></td>
					<td><a href="<c:url value='manageProductRemove/${product.productID}' />">Delete</a></td>
				</tr>
			</c:forEach>
		
		</table>
		</c:if>
	
</body>
</html>