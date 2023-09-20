<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.ico">
<title>회원가입</title>
</head>
<body>
	<h2>회원가입</h2>
	<form name="joinForm" action="/join" method="post">
    <input type="email" name="member_id" id="member_id" value="" maxlength="80" placeholder="아이디(이메일)" /><br/>
    <input type="button" id="checkId" value="중복검사"><br/>
    <div><span id="result_checkId" style="font-size:12px;"></span></div>
    
    <input type="password" name="member_pw"  value="" maxlength="20" placeholder="비밀번호"><p/>            
    <input type="text" name="member_name" maxlength="40" value="" placeholder="이름"><p/>
    <input type="tel" name="member_phone"  value="" autocomplete="off" placeholder="휴대폰 번호"><p/>
    <input type="submit" value="가입하기">
    <input type="reset"  value="취소하기">
</form> 
	
</body>
</html>