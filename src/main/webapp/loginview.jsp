<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href="css/myCss.css"></link>

<body>
<img src="http://localhost:8080/img/${applicant.getUsername()}" width="200px" height="200px"/></img><br>

NAME: ${applicant.getUsername()}<br>
PH: ${applicant.getPh()}<br>

<a href="http://localhost:8080/pdf/${applicant.getUsername()}">CV</a>
<a href="http://localhost:8080/update/<c:out value="${applicant.getUsername()}"/>">EDIT 
<a href="http://localhost:8080/delete/<c:out value="${applicant.getUsername()}"/>">DELETE</a><br>
<a href="http://localhost:8080/Home.jsp">HOME</a>
</body>
</html>