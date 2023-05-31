<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring boot application</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="javascript:history.back()"><img
					src="/pictures/edit_icon.png" alt="Edit Icon"></a></li>
			<li><a href="/"><img src="/pictures/restart_icon.png"
					alt="Restart Icon"></a></li>
			<li><img src="/pictures/save_icon.png" alt="Save Icon"></li>
		</ul>
	</div>

	<h1>Choco Solver - Response</h1>

	<div class="problem-container">
		<p>Voici le problème :</p>
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
				<p>Désolé, ce problème n'a pas de solution</p>
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
			Version 1.0.0 | Contact us at <a href="mailto:example@example.com">example@example.com</a>
		</p>
	</div>
</body>
</html>
