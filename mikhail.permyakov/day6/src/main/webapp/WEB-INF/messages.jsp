

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
   <title>Messages</title>
</head>
<body>
    <table>
        <c:forEach var="message" items="${messages}">
        <tr>
            <td>${message.date}</td>
            <td>${message.message}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>