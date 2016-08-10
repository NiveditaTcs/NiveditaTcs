<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Employee Details</title>
</head>
<body>

<h2>Employee Details After Delete</h2>
<form:form id="id_empForm" method="POST" >
   <table>
<td>Name</td><td></td>
<td>Designation</td><td></td>
<td>Department</td><td></td>
<td>Employee Id</td>

   <c:forEach items="${empList}" var="current">
        <tr>
          <%-- <td><c:out value="${current.name}" /><td>
          <td><c:out value="${current.designation}" /><td>
          <td><c:out value="${current.department}" /><td>
          <td><c:out value="${current.empId}" /><td> --%>
          <td><form:input id="name_${current.empId}"  path="name" value="${current.name}" disabled="true"/><td>
          <td><form:input id="desig_${current.empId}" path="designation" value="${current.designation}" disabled="true"/><td>
          <td><form:input id="depart_${current.empId}" path="department" value="${current.department}" disabled="true"/><td>
          <td><form:input path="empId" value="${current.empId}" disabled="true"/><td>
        </tr>
      </c:forEach>
  
   
  
</table>

<a href="${pageContext.request.contextPath}/getEmployeeDetails">Click Here For Employee Details</a>
<a href="${pageContext.request.contextPath}/employee">Click Here For Edit</a>
<a href="${pageContext.request.contextPath}/getEmpForDetete">Click Here For Detete</a>  
</form:form>
</body>
</html>