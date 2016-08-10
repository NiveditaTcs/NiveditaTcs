<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>

<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>Department</td>
        <td>${department}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${empId}</td>
    </tr>
    <tr>
        <td>Designation</td>
        <td>${designation}</td>
    </tr>
</table>  
</body>
</html>