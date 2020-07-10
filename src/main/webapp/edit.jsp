 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href="css/myCss.css"></link>

NAME: ${user.getUsername()}<br>
<form action="http://localhost:8080/save" method="post" enctype="multipart/form-data">
UserName:<input type="text" name="username" value="<c:out value="${user.getUsername()}"/>"></input>
Password:<input type="password" name="password" value="<c:out value="${user.getPassword()}"/>"></input>
PH:<input type="text" name="ph" value="<c:out value="${user.getPh()}"/>"></input>
Address:<input type="text" name="address" value="<c:out value="${user.getAddress()}"/>"></input><br>
UpLoadIMG:<input type="file" name="file1" ></input><br>
UploadCV:<input type="file" name="file2"></input><br>
<input type="submit" name="submit"></input>

</form>

</html>