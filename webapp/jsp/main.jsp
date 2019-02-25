<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <%--<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">--%>
    <%--<link href="${pageContext.request.contextPath}/css/logStyle.css" rel="stylesheet" type="text/css">--%>
    <style>
    <%@include file="/css/styles.css" %>
    <%@include file="/css/logStyle.css" %>

    </style>
</head>

<body>
<%--header--%>
<br>
<br/>

<hr/>
<br>

<div>
    <div>
        <h1> Welcome on our music forum!<br>
            Our subjects for discussion!

        </h1>
    </div>
    <table>
        <%--<tr>--%>
        <%--<th>Subject Name</th>--%>

        <%--</tr>--%>
        <form name="subjForm" method="get" action="/topics">

            <c:forEach items="${allSubjects}" var="subjectList">
            <tr>
                <input type="submit" value="${subjectList.subjectName}"/>
                <input type="hidden" name="command" value="${subjectList.id}"/>
                <%--<td><h1>${subjectList.subjectName}</h1></td>--%>
            </tr>
            </c:forEach>
        </form>
    </table>
</div>
<br>

<hr/>
<%--<c:import url="/WEB-INF/jsp/parts/footer.jsp" charEncoding="utf-8"/>--%>
</body>
</html>
