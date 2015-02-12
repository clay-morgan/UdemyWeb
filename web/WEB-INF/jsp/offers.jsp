<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    <!-- specify we'll be using the JSTL tag library -->
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>    <!-- specify we'll be using the JSTL SQL tag library -->
<html>
<head>
    <title>Spring whut?</title>
</head>
<body>
<h1>Spring Expression Language (SPEL) whut?</h1>
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

<h1>List of Offers wuuuuuuuuuuuuuuuuuuuut?</h1>
If dis works then teh controller is asking the service layer for a list of offers, and then setting that list as an attribute of the model.
<c:forEach var="offer" items="${offers}">
    <ul>
        <li>id: ${offer.id}</li>
        <li>name: <strong>${offer.name}</strong></li>
        <li>email: ${offer.email}</li>
        <li>text: ${offer.text}</li>
    </ul>
</c:forEach>
<span style="color:#dc143c">Wuuuuuuuuuut?</span>
<span style="color:#bd60dc">Wuuuuuuuuuut?</span>
<span style="color:#72cddc">Wuuuuuuuuuut?</span>
<span style="color:#69dc24">Wuuuuuuuuuut?</span>
<span style="color:#dcd821">Wuuuuuuuuuut?</span>

<h1>JNDI wut?</h1>
If dis works then JNDI is working - not using spring, just JSTL connecting to the JNDI and using a result set
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