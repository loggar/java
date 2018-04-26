<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>JSTL c:url Tag Example</title>
</head>
<body>
    <p>
        <c:url var="myurl" value="/file1.jsp" />
        ${myurl}
    </p>
    <p>
        <c:url var="myurl" value="/file1.jsp" context="/MyJSPProject" />
        ${myurl}
    </p>
    <p>
        <c:url var="myurl" value="/file1.jsp" context="/MyJSPProject" scope="session" />
        ${requestScope.myurl}
    </p>
    <p>
        <c:url var="myurl" value="/file1.jsp" context="/MyJSPProject" scope="session" />
        ${sessionScope.myurl}
    </p>
</body>
</html>