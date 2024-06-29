<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<style>
body {
	text-align: center; /* Para centrar texto */
}

img {
	border: 2px solid #000;
	/* Borde sólido de 2 píxeles de ancho y color negro */
	border-radius: 20px; /* Bordes redondeados */
}

.user-icon {
	position: absolute;
	top: 10px; /* Ajusta la distancia desde la parte superior */
	right: 10px; /* Ajusta la distancia desde el borde derecho */
	margin: 10px; /* Agrega un margen del 2% alrededor de la imagen */
}

ul {
	list-style-type: none;
}

body::before {
	content: "";
	background-image: url(img/backgraund.jpg);
	background-size: cover;
	background-repeat: no-repeat;
	filter: blur(5px);
	/* Aplicar un desenfoque de 5px a la imagen de fondo */
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}

.img-size {
	width: 80%;
	/* Ajusta el ancho de las imágenes al 100% del contenedor */
	height: 300px; /* Establece una altura fija para las imágenes */
	object-fit: cover;
	/* Mantiene la relación de aspecto y recorta la imagen si es necesario */
}

footer {
	background-color: #414141;
	padding: 60px 0 30px 0;
	overflow: flex;
}

.contenedor-footer {
	display: flex;
	width: 90%;
	justify-content: space-evenly;
	margin: auto;
	padding-bottom: 50px;
	border-bottom: 1px solid #ccc;
}

.content-foot {
	text-align: center;
}

.content-foot h4 {
	color: #fff;
	border-bottom: 3px solid #af20d3;
	padding-bottom: 5px;
	margin-bottom: 10px;
}

.content-foot p {
	color: #ccc;
}

.titulo-final {
	text-align: center;
	font-size: 24px;
	margin: 20px 0 0 0;
	color: #9e9797;
}

footer img {
	width: 50px;
	border-radius: 30px;
	margin-left: 25px;
}
</style>
</head>
<body>
	<div>
		<br>
		<div class="container mt-4">
			<header class="d-flex justify-content-between align-items-center">
				<h1 class="m-auto display-4">Dulce Aventura</h1>
				<ul>
					<li class="nav-item dropdown"><a
						class='nav-link dropdown-toggle' data-bs-toggle='dropdown'
						href='#' role='button' aria-expanded='false'> <img alt=""
							src="img/usuario.png">
					</a>
						<ul class="dropdown-menu">
							<c:choose>
								<c:when test="${empty sessionScope.user}">
									<li><a class="dropdown-item" href="Login.jsp">Iniciar
											sesión</a></li>
								</c:when>
								<c:otherwise>
									<li><a class="dropdown-item" href="logout">Cerrar
											sesión</a></li>
								</c:otherwise>
							</c:choose>
						</ul></li>
				</ul>
			</header>
		</div>

		<div class="container mt-4">
			<tags:menuIndex contador="${contador }" rol="${u.tipo }" />
		</div>

		<main>
			<br>
			<div class="container">
				<div class="row">
					<div class="col-6 col-sm-4">
						<h1>Mantenimiento de Tortas</h1>
						<form action="crudtor" method="post">
							<div class="form-group">
								<label for="inputAddress">Código de Torta :</label> <input
									value="${t.idtorta}" type="text" name="txtCodigo"
									class="form-control" id="inputAddress" placeholder="TXXXX">
							</div>
							<div class="form-group">
								<label for="inputAddress2">Nombre de Torta :</label> <input
									value="${t.nombret}" type="text" name="txtTorta"
									class="form-control" id="inputAddress2"
									placeholder="Ingrese nombre de la torta">
							</div>
							<div class="form-group">
								<label for="inputAddress2">Descripcion de Torta :</label> <input
									value="${t.descripcion}" type="text" name="txtDescripcion"
									class="form-control" id="inputAddress2"
									placeholder="Ingrese descripción de la torta">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Stock :</label> <input
										value="${t.stock}" type="number" min="0" name="txtStock"
										class="form-control" id="inputEmail4" placeholder="0">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Precio :</label> <input
										value="${t.precio}" type="number" min="0" name="txtPrecio"
										step="0.01" class="form-control" id="inputPassword4"
										placeholder="0.00">
								</div>
							</div>
							<br>
							<button type="submit" class="btn btn-primary" name="btnOpcion"
								value="reg">Registrar</button>
							<button type="submit" class="btn btn-primary" name="btnOpcion"
								value="act">Actualizar</button>
							<button type="submit" class="btn btn-danger" name="btnOpcion"
								value="eli">Eliminar</button>
							<button type="submit" class="btn btn-warning" name="btnOpcion"
								value="lst">Listado</button>
						</form>
						<br>
						<div class="${estilo }" role="alert">${mensaje }</div>
					</div>
					<div class="col-6 col-sm-8">
						<%--seccion para el listado --%>
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col"></th>
									<th scope="col">Código</th>
									<th scope="col">Nombre</th>
									<th scope="col">Descripcion</th>
									<th scope="col">Stock</th>
									<th scope="col">Precio</th>
									<th scope="col">Acción</th>
								</tr>
							</thead>
							<tbody>
								<fmt:setLocale value="es_PE" />
								<c:forEach var="t" items="${lstTorta }">
									<tr>
										<th><img width='100px' alt='producto'
											src='img/tortas/${t.idtorta }.jpeg'></th>
										<td>${t.idtorta }</td>
										<td>${t.nombret }</td>
										<td>${t.descripcion }</td>
										<td>${t.stock }</td>
										<td style="color: red;"><fmt:formatNumber
												value="${t.precio }" type="currency" /></td>
										<td><a
											href='crudtor?id=${t.idtorta }'
											class='btn btn-outline-primary'>Editar</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</main>

		<footer>
			<div class="contenedor-footer">
				<div class="content-foot">
					<h4>Teléfono</h4>
					<p>999-999</p>
				</div>
				<div class="content-foot">
					<h4>Email</h4>
					<p>DulceAventura@gmail.com</p>
				</div>
				<div class="content-foot">
					<h4>Atención</h4>
					<p>SoporteDulceAventura@gmail.com</p>
				</div>
				<div class="content-foot">
					<h4>Redes Sociales</h4>
					<a href="https://www.facebook.com/"><img class="imgfooter"
						src="img/footer/facebook.jpg" alt=""></a> <a
						href="https://www.instagram.com/"><img class="imgfooter"
						src="img/footer/instagram.jpg" alt=""></a> <a
						href="https://twitter.com/?lang=es"><img class="imgfooter"
						src="img/footer/tuiter.jpg" alt=""></a>
				</div>
			</div>
			<h1 class="titulo-final">&copy; Dulce Aventura</h1>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
		
	</script>
</body>
</html>