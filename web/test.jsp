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
    ${message};
    <form action="${ pageContext.request.contextPath}test" method="post">

        <p><input id="1"  type="text" name="name" value="${stud1}"/></p>
        <p><input  type="text" name="surname" value="${stud1}"/></p>
        <p><input  type="text" name="group" value="${stud1}"/></p>


        <select name="testfacultet" >

            <c:forEach items="${student}" var="stud">
                <option value=${stud.id}>${stud.name}</option>
            </c:forEach>
        </select>
        <p><input  type="text" name="avscore" value="${stud1}"/></p>
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
