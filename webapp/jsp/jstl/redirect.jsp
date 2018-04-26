<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>c:redirect Tag Example</title>
</head>
<body>
    <c:redirect url="./import.jsp">
        <c:param name="w" value="w1" />
    </c:redirect>
</body>
</html>