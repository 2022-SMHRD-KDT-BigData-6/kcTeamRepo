<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper" align="center"> 
	<div id="forms" align="center">
	<nav>
		<ul class="actions vertical">
		<%-- 로그인 기능을 만들어 봅시다. --%>
		<%-- form태그의 3요소!!!!!! --%>
			<li><h5>로그인</h5></li>
			<form action="LoginService" method="post">
				<li><input type="text" name="user_id" placeholder="ID를 입력하세요"></li>
				<li><input type="password" name="user_pw" placeholder="PW를 입력하세요"></li>
				<li><input type="submit" value="LogIn" class="button fit"></li>
			</form>
		</ul>
		<ul class="actions vertical">
		<%-- 회원가입 기능을 만들어 봅시다. --%>
			<li><h5>회원가입</h5></li>
			<form action="#">
				<li><input type="text" placeholder="ID를 입력하세요"></li>
				<li><input type="password" placeholder="PW를 입력하세요"></li>
				<li><input type="text" placeholder="별명을 입력하세요"></li>
				<li><input type="text" placeholder="신장을 입력하세요"></li>
				<li><input type="text" placeholder="몸무게를 입력하세요"></li>
				<li><input type="text" placeholder="BMI를 입력하세요"></li>
				<li><input type="text" placeholder="주소를 입력하세요"></li>
				<li><input type="submit" value="JoinUs" class="button fit"></li>
			</form>
		</ul>
	</nav>
	</div>
</div>
</body>
</html>