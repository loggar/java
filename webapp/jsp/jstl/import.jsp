<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>c:import Tag Example</title>
</head>
<body>
    <div>
        <c:import url="http://localhost:8080/loggar_java/jsp/jstl/forTokens.jsp" />
    </div>
    <div>
        <c:import var="data" url="http://localhost:8080/loggar_java/index.html" />
        <c:out value="${data}" />
    </div>
</body>
</html>