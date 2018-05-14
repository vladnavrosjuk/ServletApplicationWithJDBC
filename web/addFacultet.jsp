<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 06.05.2018
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Facultet</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<form action="${ pageContext.request.contextPath}addFacultet" method="post">
    <p><input  type="text" name="stud" value="${nameFacultet}"/></p>

    <p>
        <input type="submit" name="submit" value="Save"/></p>
</form>
</body>
</html>
