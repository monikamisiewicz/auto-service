<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-03
  Time: 19:30
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

<div ><h3>Customer List</h3></div>
<div><a href="/addCustomer">Add customer</a></div>



<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>FIRST NAME</th>
            <th>LAST NAME</th>
            <th>DATE OF BIRTH</th>
            <th colspan="2">MORE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.dateOfBirth}</td>
                <td><a href="/customerDetails?id=${customer.id}">Details</a></td>
                <td><a href="/editCustomer?id=${customer.id}">Edit</a></td>
                <td><a href="/deleteCustomer?id=${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<jsp:include page="footer.jsp"/>
</body>

</html>
