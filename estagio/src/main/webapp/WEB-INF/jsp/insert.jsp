<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>
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
				<a class="navbar-brand" href="/"><span>Inserir Filme</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">

			</div>
		</div>
	</div>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<form role="form" method="post"  name="formInsert" action="/save"
						modelAttribute="Movie" enctype="multipart/form-data"> 
						<div class="form-group">
							<input class="form-control" name="id" required="required"
								id="inputId" type="hidden" placeholder="" type="text"
								value="${objectToEdit.movieId}"> <label
								class="control-label" for="exampleInputEmail1">Título</label> 
								<input class="form-control" name="title" required="required"
								id="inputTitulo" placeholder="Insira o título do filme"
								type="text" value="${objectToEdit.title}">
								<label for="comment">link do filme</label>
								<input
								class="form-control" name="link" required="required"
								id="linkFilme" placeholder="Insira o link Torrent"
								type="text" value="${objectToEdit.link}">
								<label for="comment">Descrição</label>
								<textarea class="form-control" rows="5" id="descricao"
									placeholder="Insira a descrição do filme" name="description">${objectToEdit.description}</textarea>
						</div>
						<label for="image">Foto</label>
						<input type="file" class="form-control-file border" name="image">
						<br>
						<button type="submit" class="btn btn-default" href="save">Salvar</button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>

</html>