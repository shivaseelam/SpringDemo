<%@include file="/resources/jsp/include.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="description" content="N2G Solutions"/>
<meta name="keywords" content="nano, giga, solutions, 2" />
<meta name="author" content="N2G Solutions" />
<title>Nano2Giga Solutions - Employee Management Tool</title>
<link href="resources/css/generic.css" rel="stylesheet" type="text/css" />

</head>
<body>


<div id="outline">
  <table width="100%"  border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td class="spacer"></td>
    </tr>
	     <tr>
	       <td align="center" >
                <form method="post" onsubmit="return validateAddEmployeeCO(this)">
			         <table align="center" width="400" border="0" cellspacing="0" cellpadding="2">
			         <tr>
						 <td width="107" height="26"><%-- <fmt:message key="empForm.name" /> --%>Employee Name : <span class="asterisk">*</span></td>
				         <spring:bind path="addEmployeeForm.name">
					         <td width="533" height="26">
					            <input type="text" name="name" maxlength="50" size="25"/>
					         </td>
				             <td style="text-align:center"><font color="red">*</font></td>
			         	 </spring:bind>
			         </tr>

			         <tr>
				         <td width="107" height="29"><%-- <fmt:message key="empForm.name"/> --%>Employee Email : <span class="asterisk">*</span></td>
				         <spring:bind path="addEmployeeForm.email">
					         <td width="533" height="29">
					            <input type="text" name="email" maxlength="50" size="25"/>
					         </td>
					         <td style="text-align:center"><font color="red">*</font></td>
				        </spring:bind>
			         </tr>

			        <tr >
				        <td align="center" valign="center" width="107" height="40">
				         &nbsp;</td>
				        <td width="533" height="40">
				        	<input type=submit class="button" value="submit" width="163" height="40">
				        </td>
			        </tr>
			     	</table>
			  	 </form>
			</td>
		</tr>
  </table>
</div>

	<v:javascript formName="addEmployeeCO" staticJavascript="false" xhtml="true" cdata="false"/>
	<script type="text/javascript"
	        src="<c:url value="/validatorjspcontroller.htm"/>">
	</script>
</body>
</html>
