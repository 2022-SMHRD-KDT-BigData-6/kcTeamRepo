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
			<form action="JoinService" method="post">
				<li><input type="text" name="user_id" placeholder="ID를 입력하세요"></li>
				<li><input type="password" name="user_pw" placeholder="PW를 입력하세요"></li>
				<li><input type="text" name="nick_name" placeholder="별명을 입력하세요"></li>
				<li><input type="text" name="height_val" placeholder="신장을 입력하세요"></li>
				<li><input type="text" name="weight_val" placeholder="몸무게를 입력하세요"></li>
				<li><input type="text" name="bmi_val" placeholder="BMI를 입력하세요"></li>
				<li><input type="text" name="address" placeholder="주소를 입력하세요"></li>
				<li><input type="submit" value="JoinUs" class="button fit"></li>
			</form>
				<li><h5>루틴추가</h5></li>
			<form action="rutininsert" method="post">
				<li><input type="text" name="user_id" placeholder="ID를 입력하세요"></li>
				<li><input type="text" name="training_name" placeholder="루틴명을 입력하세요"></li>
				<li><input type="text" name="myobject" placeholder="다짐을 입력하세요"></li>
				<li><input type="date" name="start_date" placeholder="시작일을 입력하세요"></li>
				<li><input type="date" name="end_date" placeholder="종료일을 입력하세요"></li>
				<li><input type="submit" value="rutininsert" class="button fit"></li>
			</form>
			
			<li><h5>상세루틴 운동추가</h5></li>
			<form action="detail_rutininsert" method="post">
				<li><input type="text" name="rutin_index" placeholder="루틴번호를 입력하세요"></li>
				<li><input type="text" name="training_index" placeholder="운동번호를 입력하세요"></li>
				<li><input type="text" name="set_val" placeholder="세트수를 입력하세요"></li>
				<li><input type="text" name="secncnt_val" placeholder="횟수or초를 입력하세요"></li>
				<li><input type="text" name="favor_check" placeholder="선호도를 입력하세요"></li>
				<li><input type="submit" value="detail_rutininsert" class="button fit"></li>
			</form>
			
			<li><h5>루틴 조회</h5></li>
			<form action="select_rutin" method="post">
				<li><input type="text" name="rutin_index" placeholder="루틴번호를 입력하세요"></li>
				<li><input type="submit" value="select_rutin" class="button fit"></li>
			</form>
		</ul>
	</nav>
	</div>
</div>
</body>
</html>