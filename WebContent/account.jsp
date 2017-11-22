<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.buy {
	background-color: yellow;
}
</style>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script type="text/javascript">
	// 使用 jQuery 发送 ajax post 请求 XMLHttpRequest
	$(function() {
		// account 元素失去焦点
		$('#account').on('blur', function() {
			// 1）url 2) 数据 3) 回调函数
			$.post('checkName.action', {
				account : $('#account').val()
			}, function(data) {
				$('#account_hint').text(data);
			});
		});
		// task 2
		// task 3
	});
</script>

<link href="css/master.css" rel="stylesheet">
<style type="text/css">
#main {
	width: 60%;
	margin-left: auto;
	margin-right: auto;
	margin: 0 auto;
	/* background-color: #666; */
	min-height: 200px;
}

#login {
	width: 50%;
	float: left;
	/* background-color: #f00; */
	min-height: 200px;
}

#register {
	width: 50%;
	float: right;
	/* background-color: #ff0; */
	min-height: 200px;
}

form {
	
}

form lable {
	display: block;
}
</style>
</head>
<body>

	<%@ include file="header.jsp"%>

	<div id="main">
		<div id="login">
			<h1>登陆 ${errorMessage}</h1>
			<form action="login.action">
				<div>
					<label>用户名</label><input name="account" required>
				</div>
				<div>
					<label>密码</label><input name="password" type="password"
						maxlength="6" required>
				</div>
				<div>
					<label></label><input type="submit">
				</div>
			</form>
		</div>
		<div id="register">
			<h1>注册</h1>
			<form action="register.action">
				<div>
					<label>用户名</label><input id="account" name="account"><span
						id="account_hint"></span>
				</div>
				<div>
					<label>密码</label><input id="pw1" name="password">
				</div>
				<div>
					<label>确认密码</label><input id="pw2" name="password">
				</div>
				<div>
					<label></label><input type="submit">
				</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>
</html>