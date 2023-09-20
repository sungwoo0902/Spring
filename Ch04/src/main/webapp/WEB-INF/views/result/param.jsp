<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>annotation::param</title>
	</head>
	<body>
		<h3>@RequestParam 어노테이션 결과</h3>
		
		<a href="/Ch04/index">index</a>
		
		<h4>param1 결과</h4>
		<p>
			uid : ${uid}
		</p>	
		
		<h4>param2 결과</h4>
		<p>
			uid : ${uid}<br>
			name : ${name}<br>
		</p>
		
		<h4>param2 결과</h4>
		<p>
			uid : ${uid}<br>
			name : ${name}<br>
			hp : ${hp}<br>
			age : ${age}<br>
		</p>
	</body>
</html>