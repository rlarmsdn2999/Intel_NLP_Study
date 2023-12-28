<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>챗봇</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="/resources/css/styles2.css" rel="stylesheet">
<style>
body {
	background-image: url('/resources/img/img1.PNG');
	background-repeat: no-repeat; /* 배경 이미지 반복 없음 */
	background-size: cover; /* 배경 이미지를 컨테이너에 맞게 확대 또는 축소 */
	height: 100vh;
	margin: 0;
	display: flex;
	align-items: center;
	justify-content: center;
}

.chat-container {
	max-width: 600px;
	margin: auto;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	margin-bottom: 20px;
}

.chat-header {
	background-color: #28a745;
	color: #ffffff;
	padding: 15px;
	text-align: center;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	margin-bottom: 20px;
}

.chat-body {
	padding: 20px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	font-weight: bold;
	color: #495057;
}

.form-control {
	border-radius: 8px;
}

.btn-primary {
	background-color: #007bff;
	border-color: #007bff;
	border-radius: 8px;
}

.user-message, .chatbot-message {
	border-radius: 8px;
	padding: 15px;
	margin-bottom: 15px;
}

.user-message {
	background-color: #e2f9ff;
}

.chatbot-message {
	background-color: #f2f2f2;
}

.alimy-container {
	max-width: 600px;
	margin: auto;
	background-color: #ffffff;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-top: 20px;
}

.alimy-container h2 {
	color: #28a745;
	margin-bottom: 15px;
}

.alimy-container p {
	font-size: 16px;
	color: #495057;
}
</style>
</head>
<body>
	<div class="chat-container">
		<div class="chat-header">
			<h1>
				<img src="/resources/img/img3.png" width="50" height="50">올림픽 알리미
			</h1>
		</div>

		<div class="chat-body">
			<form action="/chat" method="post">
				<div class="form-group">
					<label for="userInput">사용자:</label> <input type="text"
						id="userInput" name="userInput" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-primary">전송</button>
			</form>

			<div class="user-message">
				<p>
					<strong>사용자:</strong> ${user}
				</p>
			</div>

			<div class="chatbot-message">
				<p>
					<strong>알리미:</strong> ${chatbot}
				</p>
			</div>
		</div>
		<div class="alimy-container">
			<h2>알리미 종목</h2>
			<p>근대5종, 브레이킹, 사이클BMX 프리스타일, 서핑, 수구, 스케이트 보드, 스포츠 클라이밍, 아티스틱 스위밍, 카누 스프린트, 카누 슬라럼
			, 트라이애슬론, 트램폴린, 축구, 펜싱, 사격, 양궁, 럭비(7인제), 경영, 골프, 체조, 농구, 다이빙, 레슬링, 배구, 배드민턴, 복싱</p>
			<a href="https://olympics.com/ko/sports/summer-olympics#paris-2024"
				target="_blank">공식홈페이지</a>
		</div>
	</div>

</body>
</html>