<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:parseDate</title>
</head>
<body>
    <fmt:parseDate value="1989-09-18 03:00:23" pattern="yyyy-MM-dd HH:mm:ss" var="date" />
    ${ date }
</body>
</html>
