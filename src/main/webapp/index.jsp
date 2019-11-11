<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-03
  Time: 15:25
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

<div><h3>CURRENT REPAIRS</h3></div>
<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>REPAIR ACCEPTANCE DATE</th>
<%--            <th>PLANNED REPAIR START</th>--%>
            <th>REPAIR START</th>
            <th>PROBLEM DESCRIPTION</th>
            <th>REPAIR DESCRIPTION</th>
            <th>STATUS</th>
            <th>VEHICLE</th>
            <th>CUSTOMER COST</th>
            <th>SPARE PARTS COST</th>
            <th>MAN HOUR COST</th>
            <th>MAN HOUR AMOUNT</th>
            <th>CUSTOMER ID</th>
            <th>EMPLOYEE ID</th>
            <th>MORE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td><a href="/orders?id=${order.id}">${order.id}</a></td>
                <td>${order.repairAcceptanceDate}</td>
                <td>${order.repairStart}</td>
                <td>${order.problemDescription}</td>
                <td>${order.repairDescription}</td>
                <td>${order.status}</td>
                <td>${order.vehicle}</td>
                <td>${order.customerCost}</td>
                <td>${order.sparepartsCost}</td>
                <td>${order.manHourCost}</td>
                <td>${order.manHourAmount}</td>
                <td>${order.customerId}</td>
                <td>${order.employeeId}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>



<jsp:include page="footer.jsp"/>
</body>
</html>

