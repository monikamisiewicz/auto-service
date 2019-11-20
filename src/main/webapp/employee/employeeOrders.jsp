<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-04
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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


<div><h3>EMPLOYEE ORDERS</h3></div>
<h3>Employee: ${employee.firstName} ${employee.lastName}</h3>
<div>
    <div>
        <a href="/employeeList">Back</a>
    </div>
</div>
<div><a href="/addOrder">Add order</a></div>


<div>
    <table>
        <thead>
        <tr>
            <th> </th>
            <th>REPAIR START</th>
            <th>REPAIR DESCRIPTION</th>
            <th>EMPLOYEE ID</th>
            <th>STATUS ID</th>
            <th colspan="3">MORE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}" varStatus="loopCount">
            <tr>
                <th>${loopCount.count}</th>
                <td>${order.repairStart}</td>
                <td>${order.repairDescription}</td>
                <td>${order.employeeId}</td>
                <td>${order.statusId}</td>
                <td><a href="/orderDetails?id=${order.id}">Details</a></td>
                <td><a href="/editOrder?id=${order.id}">Edit</a></td>
                <td><a href="/deleteOrder?id=${order.id}">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
