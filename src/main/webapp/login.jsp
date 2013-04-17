<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="lightskyblue">
	<div style="position:absolute; top:27%; left:28%;">
	<font color="red">
	<b><c:out value="${requestScope.message}" /></b>
	</font>
	</div>
	<div style="position:absolute; top:8%; left:34%;">
	<font size="30" color="gold" face="Comic Sans MS"><b>Twipple</b></font>
	</div>
	<form action="TwippleServlet" method="post">
		<div style="position:absolute; top:33%; left:25%;">
			<font size="4" color="brown"  face="Comic Sans MS"><b>ユーザ名:</b></font>
		</div>
		<div style="position:absolute; top:33%; left:35%;">
			<input type="text" name="name" size="12" style="height:20px; width:150px">
		</div>
		<div style="position:absolute; top:43%; left:25%;">
			<font size="4" color="brown"  face="Comic Sans MS"><b>パスワード:</b></font>
		</div>
		<div style="position:absolute; top:43%; left:35%;">
			<input type="password" name="password" size="10" style="height:20px; width:150px">
		</div>
		<div style="position:absolute; top:57%; left:35%;">
			<input type="submit" style="height:30px; width:80px" value="ログイン" />
		</div>
	</form>
	
	<a href="NewEntry.jsp" style="position:absolute; top:58%; left:43%;">新規登録はこちら</a>

</body>
</html>