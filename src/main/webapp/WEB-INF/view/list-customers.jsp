<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
<%--	reference style sheet--%>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		<div id="container">
			<div id="content">
<%--				add new button: Add Customer--%>
				<input type="button" value="Add Customer"
					onclick="window.location.href='show-form-for-add';return false;"
				   class="add-button"
				/>
<%--				add out html table here--%>
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
<%--					loop over and print our customers--%>
					<c:forEach var="customer" items="${customers}">
<%--						construct an "update" link with customer id--%>
						<c:url var="updateLink" value="/customer/show-form-update">
							<c:param name="customerId" value="${customer.id}"/>
						</c:url>
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td>
<%--								display update link--%>
								<a href="${updateLink}">Update</a>
							</td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>