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


<form action="/addEmployee" method="post">
    <div>
        <div>
            <h3>NEW EMPLOYEE</h3>
        </div>
        <div>
            <button type="submit">SAVE</button>
        </div>
    </div>

    <div>
        <label>First name:</label>
        <div>
            <input type="text" name="firstName" required placeholder="First name"/>
        </div>
    </div>
    <div>
        <label>Last name:</label>
        <div>
            <input type="text" name="lastName" required placeholder="Last name"/>
        </div>
    </div>

<div>
    <label>Address</label>
    <div>
        <input type="text" name="address" placeholder="Address">
    </div>
</div>
   <div>
       <label>Telephone number</label>
       <div>
           <input type="text" name="telephone" placeholder="Telephone number">
       </div>
   </div>

    <div>
        <label>Note</label>
        <div>
            <textarea name="note" cols="30" rows="5" placeholder="Note"></textarea>
        </div>
    </div>

    <div>
        <label>Man hour cost</label>
        <div>
            <input type="number" min="0.00" step="0.01" name="manHourCost" placeholder="Man hour cost">
        </div>
    </div>

</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
