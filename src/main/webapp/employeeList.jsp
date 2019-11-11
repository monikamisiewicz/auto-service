<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-04
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>AUTO SERVICE</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/> ">
</head>
<body>
<jsp:include page="header.jsp"/>

<div ><h3>Employee List</h3></div>
<div><a href="/addEmployee">Add employee</a></div>

<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>ADDRESS</th>
            <th>TELEPHONE NUMBER</th>
            <th>NOTE</th>
            <th>MAN HOUR COST</th>
            <th>MORE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.address}</td>
                <td>${employee.telephone}</td>
                <td>${employee.note}</td>
                <td>${employee.manHourCost}</td>
                <td><a href="/employeeDetails?id=${employee.id}">Details</a></td>
                <td><a href="/editEmployee?id=${employee.id}">Edit</a></td>
                <td><a href="/deleteEmployee?id=${employee.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<jsp:include page="footer.jsp"/>
</body>
</html>
