<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="lightskyblue">
	<div align="right">
	<font size="4">
	ようこそ
	<font color="red">
	<c:out value="${ sessionScope.userData.name }" />
	</font>
	 さん
	</font>
	</div>
	<div align="right" >
		<a href="login.jsp">ログアウト</a>
	</div>

<form action="SpeakServlet" method="post">
<div style="position:absolute; top:15%; left:35%;">
<textarea name="speak" cols="40" rows="5" style="height:30px; width:170px" >
</textarea>
</div>
<div style="position:absolute; top:16%; left:50%;">
<input type="submit" style="height:30px; width:80px" value="つぶやく" />
</div>
<HR size="10" width="80%" style="position:absolute; top:25%; left:8%;" color="gold">
</form>
<div style="position:absolute; top:33%; left:35%;">
<c:forEach var="user" items="${users}" >
<font size="7" color="brown"  face="Comic Sans MS">
<b><c:out value="${user.speak}"/></b></font><br>
<c:out value="${user.dt}"/>#<font  color="red"  face="Comic Sans MS"><c:out value="${sessionScope.userData.name}"/></font><br>
</c:forEach>
</div>
<c:out value="${ sessionScope.massage }" />
</body>
</html>