<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>home</title>
<body>

<jsp:include page="Productmenu.jsp"></jsp:include>

<c:if test="${isUserClickedLoginHere}">
	<jsp:include page="login.jsp"></jsp:include>
</c:if>

<c:if test="${invalidCredentials}">
		      ${errorMessage}
		<jsp:include page="login.jsp"></jsp:include>
</c:if>
<c:if test="${!empty logoutMessage}">
	<div>${logoutMessage}></div>

</c:if>
<c:if test="${ errorMessage}">
	<div>${ errorMessage}</div>
</c:if>

<c:if test="${isUserClickedRegisterHere}">
	<jsp:include page="register.jsp"></jsp:include>
</c:if>
<c:if test="${isAdmin }">
	<jsp:include page="admin.jsp"></jsp:include>
</c:if>
<c:if test="${isAdminClickedCategories}">
<jsp:include page="admin.jsp"></jsp:include>
	<jsp:include page="category.jsp"></jsp:include>
</c:if>
<c:if test="${newusersaved}">
	
	${successMessage}
	</c:if>
<c:if test="${newusernotsaved}">
	
	${errorMessage}
	</c:if>
<c:if test="${isAdminClickedSuppliers }">
<jsp:include page="admin.jsp"></jsp:include>
	<jsp:include page="supplier.jsp"></jsp:include>
</c:if>
<c:if test="${isAdminClickedProducts}">
<jsp:include page="admin.jsp"></jsp:include>
	<jsp:include page="products.jsp"></jsp:include>
</c:if>

</body>
</html>