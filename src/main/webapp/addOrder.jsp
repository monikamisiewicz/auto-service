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


<form action="/addOrder" method="post">
    <div>
        <div>
            <h3 >NEW ORDER</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>


    <label>
        First name: <input type = "text" name="firstName" required placeholder="First name" />
    </label>
    <label>
        Last name: <input type = "text" name="lastName" required placeholder="Last name"/>
    </label>
    <label>Address
        <input type="text" name="address" placeholder="Address">
    </label>
    <label>Telephone number
        <input type="text" name="telephone" placeholder="Telephone number">
    </label>
    <label>Note
        <input type="text" name="note" placeholder="Note">
    </label>
    <label>Man hour cost
        <input type="number" min="0.00" step="0.01" name="manHourCost" placeholder="Man hour cost">
    </label>


</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
