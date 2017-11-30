<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="<c:url value="/user/upload" />" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="file_name"/>
        <input type="file" name="file" />
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
