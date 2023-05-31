<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Choco Solver</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="javascript:history.back()"><img
					src="/pictures/edit_icon.png" alt="Edit Icon"></a></li>
			<li><a href="/"><img src="/pictures/restart_icon.png"
					alt="Restart Icon"></a></li>
		</ul>
	</div>
	<div class="error-container">
		<h1>Error:</h1>
		<p>${errormessage}</p>
	</div>

</body>
</html>