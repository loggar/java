<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:setLocale value="ko" />
<head>
<title>JSTL fmt:setBundle Tag</title>
</head>
<body>
    <fmt:setBundle basename="message.msg" var="bundle1" />
    <fmt:message var="title" key="AAA" bundle="${bundle1}" />
    <p>${title }</p>
    <p>
        <fmt:message key="AAA" bundle="${bundle1}" />
    </p>
</body>
</html>