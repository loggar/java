<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fmt:formatDate</title>
</head>
<body>
    <c:set var="now" value="<%=new java.util.Date()%>" />
    <h1>type = date</h1>
    default :
    <fmt:formatDate value="${ now }" type="date" dateStyle="default" />
    <br> short :
    <fmt:formatDate value="${ now }" type="date" dateStyle="short" />
    <br> medium :
    <fmt:formatDate value="${ now }" type="date" dateStyle="medium" />
    <br> long :
    <fmt:formatDate value="${ now }" type="date" dateStyle="long" />
    <br> full :
    <fmt:formatDate value="${ now }" type="date" dateStyle="full" />
    <hr>
    <h1>type = time</h1>
    default :
    <fmt:formatDate value="${ now }" type="time" timeStyle="default" />
    <br> short :
    <fmt:formatDate value="${ now }" type="time" timeStyle="short" />
    <br> medium :
    <fmt:formatDate value="${ now }" type="time" timeStyle="medium" />
    <br> long :
    <fmt:formatDate value="${ now }" type="time" timeStyle="long" />
    <br> full :
    <fmt:formatDate value="${ now }" type="time" timeStyle="full" />
    <hr>
    <h1>type = both</h1>
    default :
    <fmt:formatDate value="${ now }" type="both" dateStyle="default" timeStyle="default" />
    <br> short :
    <fmt:formatDate value="${ now }" type="both" dateStyle="short" timeStyle="default" />
    <br> medium :
    <fmt:formatDate value="${ now }" type="both" dateStyle="medium" timeStyle="default" />
    <br> long :
    <fmt:formatDate value="${ now }" type="both" dateStyle="long" timeStyle="default" />
    <br> full :
    <fmt:formatDate value="${ now }" type="both" dateStyle="full" timeStyle="default" />
    <hr>
    <h1>pattern</h1>
    YYYY/MM/dd :
    <fmt:formatDate value="${ now }" type="date" pattern="YYYY/MM/dd" />
    <br> HH:mm:SS :
    <fmt:formatDate value="${ now }" type="time" pattern="HH:mm:SS" />
    <br> hh:mm:ss :
    <fmt:formatDate value="${ now }" type="time" pattern="hh:mm:ss" />
    <br> a :
    <fmt:formatDate value="${ now }" type="time" pattern="a" />
    <br> H :
    <fmt:formatDate value="${ now }" type="time" pattern="HH" />
    <br> k :
    <fmt:formatDate value="${ now }" type="time" pattern="kk" />
    <br> K :
    <fmt:formatDate value="${ now }" type="time" pattern="KK" />
    <br> h :
    <fmt:formatDate value="${ now }" type="time" pattern="hh" />
    <br> z :
    <fmt:formatDate value="${ now }" type="time" pattern="z" />
    <br> Z :
    <fmt:formatDate value="${ now }" type="time" pattern="Z" />
    <br> X :
    <fmt:formatDate value="${ now }" type="time" pattern="X" />
    <br>
    <br />
</body>
</html>
