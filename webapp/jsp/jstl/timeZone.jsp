<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:timeZone</title>
</head>
<body>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    Korea :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <br>
    <fmt:timeZone value="Asia/Hong_kong">
     HongKong :
      <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    </fmt:timeZone>
    <br>
    <fmt:timeZone value="Europe/London">
     London :
      <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    </fmt:timeZone>
    <br>
    <fmt:timeZone value="America/New_York">
     New York :
      <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    </fmt:timeZone>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    Korea :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <br>
    <fmt:setTimeZone value="Asia/Hong_kong" />
    HongKong :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <br>
    <fmt:setTimeZone value="Europe/London" />
    London :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <br>
    <fmt:setTimeZone value="America/New_York" />
    New York :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="full" />
    <div>
        <p>TimeZone List</p>
        <p>
            <c:forEach var="id" items="<%=java.util.TimeZone.getAvailableIDs()%>"> ${ id }<br>
            </c:forEach>
        </p>
    </div>
</body>
</html>
v