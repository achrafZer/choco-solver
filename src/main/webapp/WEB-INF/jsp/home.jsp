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
			<li>Seules les 100 premières solutions sont affichées</li>
		</ul>
	</div>

	<div class="form-container">
		<h1>Welcome to the Choco Solver!</h1>
		<form action="/solve" method="post">
		<label for="problem">Write your problem:</label>
		<textarea id="problem" name="problem" rows="10" cols="50"
				  placeholder="taper votre script ici par exemple&#10;myFirstVar dans [1, 10];&#10;mySecondVar dans {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};&#10;ALLDIFF(myFirstVar, mySecondVar);&#10;myFirstVar + mySecondVar = 10;
"><%
			String problemText = (String) request.getAttribute("problemText");
			if (problemText != null) {
				out.print(problemText);
			}
		%></textarea>
		<div class="error-message">
			<p id="errorText"><%=request.getAttribute("errormessage")%></p>
		</div>
		<button id="solveButton" type="submit" >Solve</button>
	</form>
		
	</div>
</div>
<div class="version-container">
       <p>EOI : ";" - INF : "<" - SUP : ">" - EQUALS : "=" - EXC : "!" - ID : un nom de variable - OPENPAR : "(" - CLOSEPAR : ")" - SEPARATOR : "," - ALLDIFF : le mot clé "ALLDIFF")</p>
	<hr>
	<p>
		Version 1.0.0 | Contact us at <a href="mailto:example@example.com">example@example.com</a>
	</p>
</div>


<script>
	const errorMessage = "<%=request.getAttribute("errormessage")%>";
	const hasError = "<%=request.getAttribute("error")%>";
	
	// Display the error message if there is an error
	if(hasError===true)
		{
		document.querySelector('.error-message').style.display = 'block';
		}
	else {
		document.querySelector('.error-message').style.display = 'none';
	}
	
	</script>

</body>
</html>


