<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:parseNumber</title>
</head>
<body>
	<fmt:parseNumber value="1234.56" pattern="0000.000" var="num1" />
	${ num1 }
	<br />
	<fmt:parseNumber value="1234.56" var="num2" />
	${ num2 }
	<br />
	<fmt:parseNumber value="1234.56" pattern="####.###" var="num3" />
	${ num3 }
	<br />
</body>
</html>
