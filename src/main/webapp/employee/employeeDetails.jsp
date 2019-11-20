<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-04
  Time: 21:28
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


<div>
    <div><a href="/employeeList">Back</a>
    </div>
</div>


<div>
    <h3>EMPLOYEE DETAILS</h3>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>ADDRESS</th>
            <th>TELEPHONE</th>
            <th>NOTE</th>
            <th>MAN HOUR COST</th>
            <th>EMPLOYEE ORDERS</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.address}</td>
            <td>${employee.telephone}</td>
            <td>${employee.note}</td>
            <td>${employee.manHourCost}</td>
            <td><a href="/employeeOrders?id=${employee.id}">Orders</a></td>
        </tr>
        </tbody>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
