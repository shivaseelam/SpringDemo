<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Contact Manager</title>
	</head>

	<body>
	<h3> Contact Manager</h3>
	<c:url var="action" value="/book/add.html" ></c:url>
	<form:form method="post" action="${action}" commandName="contact">
		<table>
			<tr>
				<td>
					<form:label path="firstname"/>
					<form:input path="firstname"/>						
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="lastname"/>
					<form:input path="lastname"/>						
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="email"/>
					<form:input path="email"/>						
				</td>
			</tr>
			<tr>
				<td>
					<form:label path="telephone"/>
					<form:input path="telephone"/>						
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="add contact">
				</td>
			</tr>
			
		</table>
	
	</form:form>	
	
	
	<h4>Contacts....</h4>
	<c:if test="${!empty contactList}">
		<table class="data">
			<tr>
				<th>Name</th>
			    <th>Email</th>
			    <th>Telephone</th>
			    <th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<td>${contact.firstname}</td>
				<td>${contact.email}</td>
				<td>${contact.telephone}</td>
				<td><a href="delete/${contact.id}">delete</a> </td>
				
			</c:forEach>
		</table>
	</c:if>
	</body>
</html>