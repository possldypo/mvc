<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%
        String path = request.getContextPath();
        String rootPath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + "/";
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
        request.setAttribute("basePath", basePath);
        request.setAttribute("rootPath", rootPath);
    %>
</head>
<body>
<script type="text/javascript">
    var basePath = "<%=basePath%>"
</script>
</body>
</html>