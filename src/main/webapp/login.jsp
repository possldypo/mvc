
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<%@ include file="common.jsp"%>
<div>
    <div>
        <div>
            <form>
                <input type="text" name="email" id="email" placeholder="send email"/><span id="emailMsg"></span><br/>
                <input type="password" name="password" id="password" placeholder="send password"/><span id="passwordMsg"></span><br/>
                <input type="button" id="loginButton" value="login"/><input type="button" value="regist" id="registButton"/>
            </form>
        </div>
    </div>
</div>
<script src="${basePath}/js/jq/jquery-3.2.1.min.js"/>
<script>
    function validtionForm(){
        var email = $("#email").val()
        var password = $("#password").val()
    }
</script>
</body>
</html>
