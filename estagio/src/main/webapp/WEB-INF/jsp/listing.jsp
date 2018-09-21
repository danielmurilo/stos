<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style type="text/css">
.form-inline {
	padding-top: 1rem;
}
</style>

<title>Movies Application</title>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">

<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	rel="stylesheet" type="text/css">


</head>

<body>

	<div class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar-ex-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/"><span>Filmes Lançamento
						Torrent</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class=""><a href="login">Login</a></li>
					<sec:authorize access="hasRole('ADMIN')">
						<li class=""><a href="/insert">Inserir</a></li>
						<li><a href="javascript:formSubmit()"> Logout</a></li>
					</sec:authorize>
					<li>
						<form class="form-inline my-2 my-lg-0" action="/search">
							<input class="form-control mr-sm-2" type="text"
								placeholder="filmes..." name="search" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Buscar</button>
						</form>
					</li>
				</ul>
			</div>

		</div>
	</div>


	<!-- LOG OUT FUNCTION -->
	<form action="logout" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>


	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<tbody>
							<c:forEach var="list" items="${lists}" varStatus="loop">

								<c:choose>
									<c:when test="${loop.index % 2 == '0'}">
										<c:set var="bgcolor" value="#F2F4F4" />
									</c:when>
									<c:otherwise>
										<c:set var="bgcolor" value="" />
									</c:otherwise>
								</c:choose>
								<tr style="background-color: ${bgcolor}">
									<td rowspan="2" width="170px"><img
										src="data:image/jpg;base64, ${list.imgTO64} " height="150px"
										width="130px" /><br></td>
									<td>${list.title}</td>
								</tr>
								<tr style="background-color: ${bgcolor}">
									<td><a href="${list.link}"
										title="baixar filme via Torrent" target="_blank">Torrent
											Download</a></td>
								</tr>
								<tr style="background-color: ${bgcolor}">
									<td colspan="2">
										<div class="form-group">
											<label for="comment"></label>
											<textarea class="form-control" rows="5" id="comment">${list.description}</textarea>
										</div> <sec:authorize access="hasRole('ADMIN')">
											<div>
												<a href="/update/${list.movieId}" type="button"
													class="btn btn-primary" role="button">Alterar</a> <a
													class="btn btn-default" data-toggle="confirmation"
													data-title="Deseja realmente excluir o filme??"
													href="/delete/${list.movieId}" target="_blank">Excluir</a>
											</div>
										</sec:authorize>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					${fn:length(lists)} filme(s) encontrado(s)
				</div>
			</div>
		</div>
	</div>
</body>
</html>