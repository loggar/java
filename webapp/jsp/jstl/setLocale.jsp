<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>JSTL fmt:setLocale Tag</title>
</head>
<body>
    <fmt:setLocale value="en_US" />
    <fmt:bundle basename="com.loggar.resource.bundle.Example">
        <fmt:message key="count.one" />
        <br />
        <fmt:message key="count.two" />
        <br />
        <fmt:message key="count.three" />
        <br />
    </fmt:bundle>
    <!-- Change the Locale -->
    <fmt:setLocale value="es_ES" />
    <fmt:bundle basename="com.loggar.resource.bundle.Example">
        <fmt:message key="count.one" />
        <br />
        <fmt:message key="count.two" />
        <br />
        <fmt:message key="count.three" />
        <br />
    </fmt:bundle>
    
    <c:set var="now" value="<%=new java.util.Date()%>" />
    
    <fmt:setLocale value="ko_KR" />
    <fmt:formatNumber value="1000000" type="currency" />
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <hr>
    <fmt:setLocale value="en_US" />
    <fmt:formatNumber value="1000000" type="currency" />
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <hr>
    <fmt:setLocale value="ja_JP" />
    <fmt:formatNumber value="1000000" type="currency" />
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <hr>
</body>
</html>