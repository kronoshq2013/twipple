<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body bgcolor="tan">
	<div style="position:absolute; top:8%; left:34%;">
	<font size="30" color="gold" face="Comic Sans MS"><b>Twipple</b></font>
	</div>
	<div style="position:absolute; top:52%; left:48%;">
	<font color="red">
	<b><c:out value="${requestScope.message}" /></b>
	</font>
	</div>
	<div style="position:absolute; top:25%; left:35%;">
	<font color="red">
	<b><c:out value="${requestScope.message2}" /></b>
	</font>
	</div>
		<div style="position:absolute; top:25%; left:35%;">
	<font color="red">
	<b><c:out value="${requestScope.message3}" /></b>
	</font>
	</div>
	<form action="NewEntryServlet" method="post">
		<div style="position:absolute; top:30%; left:25%;">
			<font size="4" color="brown"  face="Comic Sans MS"><b>ユーザ名:</b></font>
		</div>
		<div style="position:absolute; top:30%; left:35%;">
			<input type="text" name="name" size="12" style="height:20px; width:150px">
		</div>
		<div style="position:absolute; top:40%; left:25%;">
			<font size="4" color="brown"  face="Comic Sans MS"><b>パスワード:</b></font>
		</div>
		<div style="position:absolute; top:40%; left:35%;">
			<input type="password" name="password" size="10" style="height:20px; width:150px">
		</div >
		<div style="position:absolute; top:50%; left:20%;">
			<font size="4" color="brown"  face="Comic Sans MS"><b>パスワード（確認用）:</b></font>
		</div>
		<div style="position:absolute; top:50%; left:35%;">
			<input type="password" name="password2" size="10" style="height:20px; width:150px">
		</div>
		<div style="position:absolute; top:65%; left:35%;">
			<input type="submit" style="height:30px; width:80px" value="登録する" />
		</div>
	</form>
		<a href="login.jsp" style="position:absolute; top:67%; left:43%;">戻る</a>
</body>
</html>