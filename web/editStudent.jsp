<%--
  Created by IntelliJ IDEA.
  User: navro
  Date: 05.05.2018
  Time: 15:51
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


<form action="${ pageContext.request.contextPath}editStudent?studentID=" method="post">
    <p><input  hidden type="text" name="studentId" value="${studentValue}"/></p>
    <p>Name</p>
    <p><input id="1"  type="text" name="name" value="${stud1}"/></p>
    <p>Surname</p>
    <p><input  type="text" name="surname" value="${stud1}"/></p>

    <p><input  type="text" name="group" value="${stud1}"/></p>
    <p>Facultet</p>


    <select name="testfacultet" >
        <jsp:useBean id="student" scope="request" type="java.util.List"/>
        <c:forEach items="${student}" var="stud">
            <option value=${stud.id}>${stud.name}</option>
        </c:forEach>
    </select>
    <p>Av.Score</p>
    <p><input  type="text" name="avscore" value="${stud1}"/></p>
    <p>Number</p>
    <p><input  type="text" name="number" value="${stud1}"/></p>
    <p>
        <input type="submit" name="submit" value="Save"/></p>
</form>
<%--   --%>

<%-- <c:forEach items="${student}" var="currentAuthor">
    <label><b>Name:</b> ${currentAuthor.name} </label>
    <label><b>Surname:</b> ${currentAuthor.surname}</label>

    <br>
</c:forEach>--%>
</body>
</html>
