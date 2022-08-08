<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>todoList</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html {
	width: 100vw;
	height: 100vh;
}

body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	text-align: center;
	background-color: #eee;
}

.main_div {
	border-radius: 15px;
	width: 100%;
	padding: 30px 20px 10px 20px;
	position: fixed;
	z-index: 999;
	border-bottom: 4px solid #00000061;
	margin: 0 auto;
	background-color: #ddd;
}

.auto {
	max-width: 900px;
	margin: 0 auto;
}

.main h3 {
	text-align: center;
}

.input_memo {
	height: 100px;
}

#hs_save {
	margin: 10px auto;
}

.hs_flex {
	display: flex;
}

img {
	width: 120px;
}

.btn_box {
	margin: 10px;
}

.add_btn {
	color: #ddffdd;
	font-weight: 500;
	text-decoration: none;
	font-size: 25px;
	padding: 20px 100px;
}

.add_btn:hover {
	cursor: pointer;
	font-weight: bold;
}

header div h3 {
	padding-left: 15px;
}

.hs_memos:first-of-type {
	margin-top: 230px;
}

.hs_memos {
	display: flex;
	flex-direction: column;
	flex-wrap: wrap;
	justify-content: space-around;
	align-content: space-around;
}

.hs_memo {
	width: 90%;
	height: 120px;
	padding: 15px;
	border-radius: 18px;
	box-shadow: 2px 2px 10px #a5a5a5ba;
	background-image: url(${rootPath}/static/images/texture.PNG);
	max-width: 900px;
	margin: 10px auto;
}
</style>
<link rel="stylesheet" href="${rootPath}/static/css/w3css.css">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/list.js?ver=1"></script>
</head>
<body>
	
	<header class="main">
		
		<div class="main_div">
			<form:form modelAttribute="TODOLIST" class="main_todo">
				<div class="auto">
				<input name="t_sdate" value="${todo.t_sdate}"  type="hidden"/>
				<input name="t_stime" value="${todo.t_stime}"  type="hidden"/>
 				<textarea name="t_content" id="MEMO"
						class="w3-input w3-border input_memo" placeholder="할일을 입력하세요."
						autofocus="autofocus" required="required" autocomplete="off">${todo.t_content}</textarea>
				</div>

				<div id="hs_save">
					<c:if test="${not empty seq}">
						<a href="${rootPath}/${todo.t_seq}/delete" class="w3-button w3-round-xxlarge w3-padding-large">삭제</a>
					</c:if>
					<a href="${rootPath}/todo/list"
						class="w3-button w3-round-xxlarge w3-padding-large">홈으로</a> <input
						type="reset" class="w3-button w3-round-xxlarge w3-padding-large">
					<input type="submit" placeholder="전송" value="저장"
						class="w3-button w3-round-xxlarge w3-padding-large">
				</div>
			</form:form>
		</div>
	</header>
	<nav>
		<div class="hs_memos">
			<c:if test="${empty TODOLIST}">
				<tr>
					<td colspan="6">작성한 내용이 없습니다.</td>
				</tr>
			</c:if>
			<table class="hs_memo hs_container">
				<c:forEach items="${TODOLIST}" var="todo" varStatus="INDEX">
						<tr data-seq="${todo.t_seq}">
							<td>${todo.t_sdate}</td>
							<td>${todo.t_stime}</td>
							<td>${todo.t_content}</td>
							<td><input type="checkbox"></td>
						</tr>
				</c:forEach>
			</table>
		</div>
	</nav>
</body>
</html>