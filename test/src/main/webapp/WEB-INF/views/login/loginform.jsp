<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>직원 관리</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="modal-dialog">

		<div>
			<h1 style="font-size: x-large;">
Spring Security<small>v.인메모리</small>
			</h1>
		</div>
		<!-- Modal content-->
		<div class="modal-content">

			<div class="modal-header" style="padding: 35px 50px;">
				<h4>
					<span class="glyphicon glyphicon-lock"></span> 로그인
				</h4>
				<label>정상적인 서비스 사용을 위해서 로그인해야 합니다.</label>
			</div>
			<div class="modal-body" style="padding: 40px 50px;">
				<form role="form" method="post" action="j_spring_security_check">
					<div class="form-group">
						<label for="id"> ID :</label> <input type="text"
							class="form-control" id="id" name="j_username" placeholder="Enter ID"
							required="required">
					</div>
					<div class="form-group">
						<label for="pw"> Password :</label> <input type="password"
							class="form-control" id="pw" name="j_password"
							placeholder="Enter Password" required="required">
					</div>
					
					<button type="submit" class="btn btn-default btn-block">
						Login</button>
						<br>
				</form>
			
				<div id="naver_id_login" style="text-align:center"><a href="/login"><img width="223" src="${pageContext.request.contextPath}/img/naver.png"/></a></div>
					<br>		
					<div id="kakao_id_login" style="text-align:center"><a href="/kakaologin"><img width="223" src="${pageContext.request.contextPath}/img/kakao.png"/></a></div>
			</div>
			<div class="modal-footer"></div>
		</div>

	</div>
</body>
</html>
