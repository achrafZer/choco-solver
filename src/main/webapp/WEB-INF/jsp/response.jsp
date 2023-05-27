<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring boot application</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<h1>Choco Solver - Response</h1>

	<div class="problem-container">
		<p>Voici le problème :</p>
		<p>${problem}</p>
	</div>
	<div>
		<p>Problem solution:</p>
		<div class="table-container">
			<%
			List<HashMap<String, Integer>> solutions = (List<HashMap<String, Integer>>) request.getAttribute("solution");
			%>
			<% if (solutions.isEmpty()) { %>
			<div class="problem-container">
				<p>Desole, ce problème n'a pas de solution</p>
			</div>

			<% } else { %>
			<table>
				<thead>
					<tr>
						<th class="center">S/V</th>
						<th class="center">a</th>
						<th class="center">b</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < solutions.size(); i++) {
						%>
					<tr>
						<td class="center"><%= i + 1 %></td>
						<td class="center"><%= solutions.get(i).get("a") %></td>
						<td class="center"><%= solutions.get(i).get("b") %></td>
					</tr>
					<%
						}
						%>
				</tbody>
			</table>
			<% } %>
		</div>
	</div>

	<div>
		<hr>
		<p>
			Version 1.0.0 | Contact us at <a href="mailto:example@example.com">example@example.com</a>
		</p>
	</div>
</body>
</html>
