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
			<div class="container mt-4">
				<section class="w-75 mx-auto">
					<fieldset class="p-4 rounded bg-light fieldset-hover">
						<legend class="px-2 text-center"
							style="background-color: silver; color: red;">Detalle de
							los  Bocaditos</legend>
						<div class="row">
							<div class="col-md-6">
								<img class="img-fluid" alt='producto'
									src='img/bocaditos/${b.id_boca }.jpeg'>
							</div>
							<div class="col-md-6">
								<form action="ventaboca" method="post">
									<div class="mb-3">
										<label class="form-label">Cod Bocadito:</label> <strong>${b.id_boca}</strong>
										<a href="#"><img src="img/lupa.png" alt=""> </a>
									</div>
									<div class="mb-3">
										<label class="form-label">Nombre :</label> <strong>${b.nombre_boca}</strong>
									</div>
									<div class="mb-3">
										<label class="form-label">Descripcion :</label> <strong>${b.descripcion_boca}</strong>
									</div>
									<div class="mb-3">
										<label class="form-label">Precio :</label> <strong
											style="color: red;"> <fmt:setLocale value="es_PE" />
											<fmt:formatNumber value="${b.precio_boca }" type="currency" />
										</strong>
									</div>
									<div class="mb-3">
										<label class="form-label">Cantidad a comprar: </label> 
										<input type="number" value="1" name="cantidad"
												min="1" max="${b.stock_boca }" class="text-center" >
										<span>Total disponible ${b.stock_boca }</span>
									</div>
									<div class="mb-3">
										<button class="btn btn-primary">
											Agregar a carrito <span
												class="glyphicon glyphicon-shopping-cart"></span>
										</button>
									</div>
								</form>
							</div>
						</div>
					</fieldset>
					<br>
				</section>
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
		crossorigin="anonymous"></script>
</body>
</html>