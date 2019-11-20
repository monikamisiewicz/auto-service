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
    <div><a href="/customerList">Back</a>
    </div>
</div>


<div>
    <h3>CUSTOMER DETAILS</h3>
</div>

<div>
    <table>
        <thead>
        <tr>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>DATE OF BIRTH</th>
            <th>CUSTOMER VEHICLES</th>
            <th>CUSTOMER ORDERS</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.dateOfBirth}</td>
            <td><a href="/customerVehicles?id=${customer.id}">Customer vehicles</a></td>
            <td><a href="/customerOrders?id=${customer.id}">Customer orders</a></td>
        </tr>
        </tbody>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
