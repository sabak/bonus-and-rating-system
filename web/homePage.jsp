<%@ page import="ge.bog.intern.bonus_and_rating_system.model.Employee" %><%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/homePage.css">

</head>

<body>
<div class="ph-container">
    <div class="ph-float">
        <a href='logout' class='ph-button ph-btn-red'>Log Out</a>
    </div>
</div>

<%
    Employee employee = (Employee) request.getAttribute("employee");
%>
<div class="table-title">
    <h3>Employee Data</h3>
</div>
<table class="table-fill">

    <tbody class="table-hover">
    <tr>
        <td class="text-left">Name</td>
        <td class="text-left"><%=employee.getName()%>
        </td>
    </tr>
    <tr>
        <td class="text-left">Surname</td>
        <td class="text-left"><%=employee.getSurname()%>
        </td>
    </tr>
    <tr>
        <td class="text-left">Sex</td>
        <td class="text-left"><%=employee.getSex()%>
        </td>
    </tr>
    <tr>
        <td class="text-left">Date Of Birth</td>
        <td class="text-left"><%=employee.getDateOfBirth()%>
        </td>
    </tr>
    <tr>
        <td class="text-left">ID Number</td>
        <td class="text-left"><%=employee.getPid()%>
        </td>
    </tr>

    <tr>
        <td class="text-left">Position</td>
        <td class="text-left"><%=employee.getPos().getDescription()%>
        </td>
    </tr>

    <tr>
        <td class="text-left">Salary</td>
        <td class="text-left"><%=employee.getSalary()%>
        </td>
    </tr>

    <tr>
        <td class="text-left">Department</td>
        <td class="text-left"><%=employee.getDepartment().getDepartmentName()%>
        </td>
    </tr>


    </tbody>
</table>



</body>
</html>


