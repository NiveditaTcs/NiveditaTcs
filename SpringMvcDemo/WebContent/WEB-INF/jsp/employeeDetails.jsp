<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<script type="text/javascript">
function enableEdit(empId){
	//var empId=document.getElementById("id_editEmp").value;
	var x = document.getElementById("id_editEmp_"+empId).checked;
	if(x){
		document.getElementById("name_"+empId).disabled=false;
		document.getElementById("desig_"+empId).disabled=false;
		document.getElementById("depart_"+empId).disabled=false;
		
	}else{
		document.getElementById("name_"+empId).disabled=true;
		document.getElementById("desig_"+empId).disabled=true;
		document.getElementById("depart_"+empId).disabled=true;
			
		
	}
	
}

function  submitForm() {
	
	document.getElementById('id_empForm').submit();
}
</script>
<head>
    <title>Employee Details</title>
</head>
<body>

<h2>Edit Employee Details</h2>
<form:form id="id_empForm" method="POST" action="${pageContext.request.contextPath}/editEmp">
   <table>
<td>Name</td><td></td>
<td>Designation</td><td></td>
<td>Department</td><td></td>
<td>Employee Id</td><td></td>
<td>Edit Details</td>
   <c:forEach items="${empList}" var="current">
        <tr>
          <td><form:input id="name_${current.empId}"  path="name" value="${current.name}" disabled="true"/><td>
          <td><form:input id="desig_${current.empId}" path="designation" value="${current.designation}" disabled="true"/><td>
          <td><form:input id="depart_${current.empId}" path="department" value="${current.department}" disabled="true"/><td>
          <td><form:input path="empId" value="${current.empId}" disabled="true"/><td>
        <td>  <form:checkbox id="id_editEmp_${current.empId}" path="editEmp" value="${current.empId}" onclick="enableEdit(this.value)" /></td>
        </tr>
      </c:forEach>
  
   
   <tr>
        <td colspan="2">
            <input type="button" value="EDIT" onclick="submitForm()"/>
        </td>
    </tr>
</table>  
<a href="${pageContext.request.contextPath}/getEmployeeDetails">Click Here For Employee Details</a>
<a href="${pageContext.request.contextPath}/getEmpForDetete">Click Here For Detete</a>
</form:form>
</body>
</html>