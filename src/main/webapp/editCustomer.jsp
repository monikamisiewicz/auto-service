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

<form action="/editCustomer?id=${customer.id}" method="post">
    <div>
        <h3>EDIT CUSTOMER</h3>
        <%--            <input type="hidden" name="id" value="${customer.id}">  ?????--%>
        <button type="submit">Save</button>
    </div>

    <div>
        <div>
            <label for="customerId">
               Customer Id
            </label>
                <input type="number" name="id" value="${customer.id}" required id="customerId">
        </div>
        <div>
            <label for="firstName">
                First Name
            </label>
                <input type="text" name="firstName" placeholder="${customer.firstName}" required id="firstName">
        </div>
        <div>
            <label for="lastName">
                Last Name
            </label>
                <input type="text" name="lastName" placeholder="${customer.lastName}" required id="lastName">

        </div>
        <div>
            <label for="dateOfBirth" >
                Date of Birth
            </label>
                <input type="date" name="dateOfBirth" placeholder="${customer.dateOfBirth}" id="dateOfBirth">
        </div>

    </div>

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
