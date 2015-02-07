<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- specify we'll be using the JSTL tag library -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    <!-- specify we'll be using the JSTL SQL tag library -->
<html>
<head>
    <title>Spring whut?</title>
</head>
<body>
    <h1>Nigguh whut?</h1>
    Name in session: <%= session.getAttribute( "name" )%>
    <br/>
    Name set in request scope: <%= request.getAttribute( "name" )%>
    <br/>
    Request Name using Expression Language (EL): ${name}
    <br/>
    Using @ModelAttribute:
    ${getOfferName}
    <br/>
    Using JSTL:
    <c:out value="${name}"/>
    </br>

    <h1>Data wut?</h1>
    If dis works then JNDI is working
    <sql:query var="rs" dataSource="jdbc/udemy">
        SELECT id, name, email, text FROM offer
    </sql:query>
        <c:forEach var="row" items="${rs.rows}">
            <ul>
                <li>id: ${row.id}</li>
                <li>name: <strong>${row.name}</strong></li>
                <li>email: ${row.email}</li>
                <li>text: ${row.text}</li>
            </ul>
        </c:forEach>


</body>
</html>