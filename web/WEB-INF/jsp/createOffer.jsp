<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new offer</title>
    <link href="${pageContext.request.contextPath}/css/styles.css?<%=Math.random()%>" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Create a new offer</h1>
<sf:form method="post" action="${pageContext.request.contextPath}/doCreate" commandName="offer">

    <table>
        <tr>
            <td>Name:</td>
            <td>
                <sf:input path="name" name="name" type="text"/>
                <br/>
                <sf:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                <sf:input path="email" name="email" type="text"/>
                <br/>
                <sf:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Your offer:</td>
            <td>
                <sf:textarea path="text" name="text" rows="10" cols="10"/>
                <br/>
                <sf:errors path="text" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input value="Create Teh Offer" type="submit"/></td>
        </tr>
    </table>

</sf:form>
</body>
</html>
