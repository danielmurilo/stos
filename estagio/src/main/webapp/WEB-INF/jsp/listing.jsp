<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE head PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movies Application</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
				<a class="navbar-brand" href="#"><span>Movies</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="insert">Inserir</a></li>
					<li class="disabled"><a href="#">Sair </a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<table class="table">
						<thead>
							<tr>
								<th>Foto</th>
								<th>Dados do Filme</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${lists}">
										<tr>
											<td rowspan="3" width="250px"><img
												src="data:image/jpg;base64, ${list.imgTO64} " height="200px"
												width="170px" /><br></td>
											<td>${list.movieId}</td>
										</tr>
										<tr>
											<td>${list.title}</td>
										</tr>
										<tr>
											<td>
												<div class="form-group">
													<label for="comment"></label>
													<textarea class="form-control" rows="5" id="comment">${list.description}</textarea>
												</div>
												<a href="/update/${list.movieId}" type="button" class="btn btn-primary" role="button">Alterar</a>
												<a href="/delete/${list.movieId}" type="button" class="btn btn-danger" role="button">Excluir</a>
											</td>
										</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>