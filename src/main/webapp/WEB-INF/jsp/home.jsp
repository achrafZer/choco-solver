<!DOCTYPE html>
<html>
<head>
<title>Choco Solver</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="centre">

	<div class="instructions">
		<ul>
			<li>La dernière variable déclarée est la seule qui est prise en compte</li>
			<li>La limites du nombre de résultats</li>
		</ul>
	</div>

	<div class="form-container">
		<h1>Welcome to the Choco Solver!</h1>
		<form action="/solve" method="post">
		<label for="problem">Write your problem:</label>
		<textarea id="problem" name="problem" rows="4" cols="50" ><%
			String problemText = (String) request.getAttribute("problemText");
			if (problemText != null) {
				out.print(problemText);
			}
		%></textarea>
		<div class="error-message">
			<p id="errorText"></p>
		</div>
		<button id="solveButton" type="submit" disabled>Solve</button>
	</form>
		
	</div>
</div>
<div class="version-container">
       <p>Les mots clé à savoir (EOI, ...)</p>
	<hr>
	<p>
		Version 1.0.0 | Contact us at <a href="mailto:example@example.com">example@example.com</a>
	</p>
</div>


<script>
	const errorMessage = "<%=request.getAttribute("errormessage")%>";
	const hasError = "<%=request.getAttribute("error")%>" === "true";
	const problemInput = document.getElementById('problem');
	const solveButton = document.getElementById('solveButton');

	// Display the error message if there is an error
	if (hasError && errorMessage.trim() !== '') {
		document.querySelector('.error-message').style.display = 'block';
		document.querySelector('#errorText').textContent = errorMessage;
	} else {
		document.querySelector('.error-message').style.display = 'none';
	}

	// Enable/disable the solve button based on the input value
	problemInput.addEventListener('input', function() {
		if (problemInput.value.trim() !== '') {
			solveButton.disabled = false;
		} else {
			solveButton.disabled = true;
		}
	});
	</script>

</body>
</html>
