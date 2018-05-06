<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 06.05.2018
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center><h1>All books</h1></center>

<table>
    <tr>
        <th> Book</th>
        <th> Edit</th>
        <th> Delete</th>
        <th> Delete</th>
    </tr>


    <c:forEach items="${student}" var="stud">
        <tr>
            <th>
                    ${stud.name}
                            </th>
            <th>
                    ${stud.surname}
            </th>
            <th>
                    ${stud.group}
            </th>
            <th>
            <a href="${pageContext.request.contextPath}deleteBook?book=${stud.id}">
                delete
            </a>
            </th>
        </tr>
        <br>
    </c:forEach>
</table>

</body>
</html>
