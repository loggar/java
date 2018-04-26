<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:formatNumber</title>
</head>
<body>
    <c:set var="price" value="12345" />
    <fmt:formatNumber value="${ price }" type="number" var="numberType" /><br />
    <fmt:formatNumber value="${ price }" type="currency" currencySymbol="￦" /><br />
    <fmt:formatNumber value="${ price }" type="percent" groupingUsed="false" /><br />
    ${ numberType }<br />
    <fmt:formatNumber value="${ price }" pattern="00000000.000" /><br />
    <fmt:formatNumber value="${ price }" pattern="########.###" /><br />
</body>
</html>
