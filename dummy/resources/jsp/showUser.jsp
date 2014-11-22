<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="spring" uri="/WEB-INF/spring.tld" %>


<html>
<head>
<link rel="stylesheet" href="/resources/css/screen.css" type="text/css"/>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <h4>Welcome to ....<c:out value="${model.user.name}"/></h2> --%>


<%-- <h5>Users ....<c:out value="${users.name}"/></h5> --%> 

<%-- <c:forEach var="user" items="${users}">
   <h5>Name <c:out value="${user.name}"/><p></h5>
</c:forEach> --%>


<table style="text-align: left; margin-left: 0px; height: 370px; width: 990px;" border="1" cellpadding="0"
       cellspacing="0">
    <tbody>
        <tr>
<%--             <td style="width: 250px;">
                <jsp:include page="filterParams.jsp"/>
            </td>
 --%>			<td height="370">
				<display:table name="users" id="user" class="table" pagesize="50" requestURI="">
				  <display:column property="userId" escapeXml="true" sortable="true"> </display:column>
				  <display:column property="name" escapeXml="true" sortable="true"> </display:column>
				  <display:setProperty name="paging.banner.name" value="user" />
				  <display:setProperty name="paging.banner.name" value="users" />
				</display:table>
			</td>
		</tr>
	</tbody>
</table>				

</body>
</html>