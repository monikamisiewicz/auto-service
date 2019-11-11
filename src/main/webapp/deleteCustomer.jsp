<%--
  Created by IntelliJ IDEA.
  User: monikamisiewicz
  Date: 2019-11-05
  Time: 15:19
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

<form action="/deleteCustomer?id=${customer.id}" method="post">

    <h4>Delete customer?</h4>
    <input type="radio" name="delete" value="Cancel" checked>Cancel
    <input type="radio" name="delete" value="Ok">Delete

    <button type="submit">Submit</button>

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
