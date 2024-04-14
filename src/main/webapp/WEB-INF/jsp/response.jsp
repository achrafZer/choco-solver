<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring boot application</title>
<link rel="stylesheet" href="/css/style.css">
<style>
.popup {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background-color: white;
	padding: 20px;
	border: 1px solid black;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
	z-index: 9999;
}

.popup.show {
	display: block;
}
</style>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="javascript:history.back()" title="Edit"> <img
					src="/pictures/edit_icon.png" alt="Edit Icon">
			</a></li>
			<li><a href="/restart" title="Restart"><img
					src="/pictures/restart_icon.png" alt="Restart Icon"></a></li>
			<li><a href="/save" title="Save"><img
					src="/pictures/save_icon.png" alt="Save Icon"></a></li>
		</ul>
	</div>

	<h1>Choco Solver - Response</h1>

	<div class="problem-container">
		<p>Problem :</p>
		<pre>${problem}</pre>
	</div>
	<div>
		<p>Problem solution:</p>
		<div class="table-container">
			<%
			List<Map<String, Integer>> solutions = (List<Map<String, Integer>>) request.getAttribute("solution");
			%>
			<%
			if (solutions.isEmpty()) {
			%>
			<div class="problem-container">
				<p>D�sol�, ce probl�me n'a pas de solution</p>
			</div>

			<%
			} else {
			%>
			<table>
				<thead>
					<tr>
						<th class="center">S/V</th>
						<%
						Map<String, Integer> firstSolution = solutions.get(0);
						for (String variable : firstSolution.keySet()) {
						%>
						<th class="center"><%=variable%></th>
						<%
						}
						%>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < solutions.size(); i++) {
						Map<String, Integer> solution = solutions.get(i);
					%>
					<tr>
						<td class="center"><%=i + 1%></td>
						<%
						for (Integer value : solution.values()) {
						%>
						<td class="center"><%=value%></td>
						<%
						}
						%>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
			<%
			}
			%>
		</div>
	</div>

	<div>
		<hr>
		<p>
			Version 1.0.0 | Contact us at <a href="mailto:example@example.com">zerhouniachraf@hotmail.com</a>
		</p>
	</div>
	<div id="popup" class="popup">
		<p id="message">${saveMessage}</p>
		<button onclick="closePopup()">OK</button>
	</div>

	<script>
    const isSaved = <%= request.getAttribute("isSaved") %>;
    const isHigherThan100 = <%=request.getAttribute("isHigherThan100")%>;
    function closePopup() {
        document.getElementById('popup').classList.remove('show');
    }
    window.addEventListener('DOMContentLoaded', function () {
        if (isSaved === true) {
            document.getElementById('popup').classList.add('show');
        }
	    if(isHigherThan100===true)
	    {
	    	document.getElementById('popup').classList.add('show');
	    	document.getElementById('message').textContent="le nombre de solutions d�passe 100 mais nous n'afficherons que les 100 premi�res solutions";
	    }
    });
</script>


</body>
</html>
