<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>c:out Tag Example</title>
</head>
<body>
    <p>
        <c:out escapeXml="false" value="${'<tag> , &'}" />
    </p>
    <p>
        <c:out escapeXml="true" value="${'<tag> , &'}" />
    </p>
    <p>
        <c:out value="${'<tag> , &'}" />
    </p>
</body>
</html>