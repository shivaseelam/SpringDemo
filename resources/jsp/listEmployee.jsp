<%@include file="/resources/jsp/include.jsp" %>

<html>
<head>
<link rel="stylesheet" href="/resources/css/screen.css" type="text/css"/>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>N2G Solutions - List of Employees</title>
</head>
<body>

<table style="text-align: left; margin-left: 0px;" border="0" cellpadding="0"
       cellspacing="0">
    <tbody>
        <tr>
		<td >
				<display:table name="employees" id="employee" class="table" pagesize="50" requestURI="">
				  <display:column property="name" escapeXml="true" sortable="true"></display:column>
				  <display:column property="email" escapeXml="true" sortable="true"></display:column>
				  <display:column><a href="<c:url value='/addEmployee.htm' />" >Delete</a></display:column>
				  <display:setProperty name="paging.banner.name" value="employee" />
				  <display:setProperty name="paging.banner.name" value="employees" />
				</display:table>
			</td>
		</tr>
	</tbody>
</table>				

</body>
</html>
