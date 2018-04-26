<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Using JSTL Functions</title>
</head>
<body>
    <c:set var="str1" value="This is first String." />
    <c:set var="str2" value="This is second String.     " />
    <c:set var="str3" value=" is fir" />
    <%
    	String[] yankees = { "Jeter", "Posada", "Rodriguez", "Kanoe", "Rivera", "Swisher" };
    	pageContext.setAttribute("yankees", yankees, PageContext.REQUEST_SCOPE);
    %>
    <c:set var="yankees2" scope='request' value="Jeter, Posada, Rodriguez, Kanoe, Rivera, Swisher" />
    
    <p>${fn:length(str1)}</p>
    <p>${fn:length(str2)}</p>
    <p>${fn:toUpperCase(str1)}</p>
    <p>${fn:toLowerCase(str1)}</p>
    <p>${fn:substring(str1, 3, 6) }</p>
    <p>${fn:substringAfter(str1, str3)}</p>
    <p>${fn:substringBefore(str1, str3) }</p>
    <p>${fn:trim(str2) }</p>
    <p>${fn:replace(str2, "second", "third") }</p>
    <p>${str2 }</p>
    <p>${fn:indexOf(str1, str3) }</p>
    <p>${fn:startsWith(str1, str3) }</p>
    <p>${fn:endsWith(str3, "fir") }</p>
    <p>${fn:contains(str1, str3) }</p>
    <p>${fn:containsIgnoreCase(str1, "FIRST") }</p>
    <p>${fn:escapeXml(str1) }</p>
    <p>${fn:join(yankees, ", ") }</p>
    <p>${fn:split(yankees2, ", ")}</p>
</body>
</html>