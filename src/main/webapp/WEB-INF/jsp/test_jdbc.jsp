<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Tests JDBC</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/WEB-INF/static/css/test_jdbc.css" />
    </head>
    <body>
        <h1>Tests JDBCC</h1>

        <c:forEach items="${ messages }" var="message" varStatus="boucle">
            <p>${ boucle.count }. ${ message }</p>
        </c:forEach>
    </body>
</html>