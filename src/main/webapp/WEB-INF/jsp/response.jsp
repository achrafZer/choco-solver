<!DOCTYPE html>
<html>
<head>
<title>Choco Solver - Response</title>
<link rel="stylesheet" href="/css/style.css">

</head>
<body>
	<h1>Choco Solver - Response</h1>

	<div>
		<p>Voici le Problem :</p>
		<p>
			<%= request.getAttribute("problem") %>
		</p>
	</div>
	<div>
		<p>Problem solution:</p>
		<p>	
			<%= request.getAttribute("solution") %></p>
	</div>

	<div>
		<hr>
		<p>
			Version 1.0.0 | Contact us at <a href="mailto:example@example.com">example@example.com</a>
		</p>
	</div>
</body>
</html>
