 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href="css/myCss.css"></link>

<center><h1>REGISTERED USERS LIST</h1></center>
<c:set var="num" value="${1}" />
<center>
<h2>
<c:forEach var="applicant" items="${user}">
<c:out value="${num}"/>.<a href="http://localhost:8080/personaldata/<c:out value="${applicant.getUsername()}"/>">${applicant.getUsername()}<br>
<c:set var="num" value="${num+1}" />
</c:forEach>
</h2>
</center>
</html>
