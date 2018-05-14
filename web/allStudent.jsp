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
<jsp:include page="header.jsp"/>
<p><input   type="text" name="studentName" value="${studentNameValue}"/></p>
<center><h1>All Students</h1></center>

<table>
    <tr>
        <th> Name</th>
        <th> Surname</th>
        <th> StudentGroup</th>
        <th> Facultet</th>
        <th> Av.Score</th>
        <th> Number</th>
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
                    ${stud.facultet}
            </th>
            <th>
                    ${stud.avscore}
            </th>
            <th>
                    ${stud.number}
            </th>
            <th>
            <a href="${pageContext.request.contextPath}deleteStudent?student=${stud.id}">
                delete
            </a>

            </th>
            <th>
                <a href="${pageContext.request.contextPath}editStudent?studentID=${stud.id}">
                    edit
                </a>

            </th>
        </tr>
        <br>
    </c:forEach>
</table>

</body>
</html>
