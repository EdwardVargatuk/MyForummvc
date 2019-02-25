<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Edward
  Date: 25.02.2019
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Comments</title>
    <style>
        <%@include file="/css/styles.css" %>
        <%@include file="/css/logStyle.css" %>
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            /*  Submit form using Ajax */
            $('button[type=submit]').click(function (e) {

                //Prevent default submission of form
                e.preventDefault();

                //Remove all errors
                $('input').next().remove();

                $.post({
                    url: 'saveComment',
                    data: $('form[name=commentForm]').serialize(),
                    success: function (res) {

                        if (res.validated) {
                            //Set response
                            $('#resultContainer pre code').text(JSON.stringify(res.comment));
                            $('#resultContainer').show();


                        } else {
                            //Set error messages
                            $.each(res.errorMessages, function (key, value) {
                                $('input[name=' + key + ']').after('<span class="error">' + value + '</span>');
                            });
                        }
                    }
                })
            });
        });
    </script>
</head>
<body>

<jsp:useBean id="now" class="java.util.Date"/>

<div class="form-style-2">
    <form action="saveComment" method="post" name="commentForm">
        <table>
            <tr>
                <td>Add your text here</td>
                <td>
                    <label><input name="userComment" type="text"/>
                    </label>
                </td>

            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit">Add comment</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- Result Container  -->
<div id="resultContainer" style="display: none;">
    <hr/>
    <h4 style="color: green;">JSON Response From Server</h4>
    <pre style="color: green;">
    <code></code>
   </pre>
</div>


<table>
    <c:forEach items="${allComments}" var="commentList">
        <tr>
            <p>${commentList.userComment}</p>
            <p>${commentList.date}</p>
            <br>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
