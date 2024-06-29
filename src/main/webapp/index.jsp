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
<link rel="icon" type="image/jpg" href="img/favicon.ico">


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
	top: 30px; /* Ajusta la distancia desde la parte superior */
	right: 30px; /* Ajusta la distancia desde el borde derecho */
	margin: 50px; /* Agrega un margen del 2% alrededor de la imagen */
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

.img-carousel {
	height: 500px; /* Altura deseada para las imágenes */
	object-fit: cover;
	/* Ajusta la imagen dentro del contenedor sin perder su relación de aspecto */
}

.carousel-inner {
	height: 500px; /* Altura deseada para el carrusel */
}

.carrousel {
	transform: scale(0.8); /* Reducir el tamaño al 80% */
}

.img-size {
	width: 100%;
	/* Ajusta el ancho de las imágenes al 100% del contenedor */
	height: 300px; /* Establece una altura fija para las imágenes */
	object-fit: cover;
	/* Mantiene la relación de aspecto y recorta la imagen si es necesario */
}

section {
	color: #000080; /* Cambia el color del texto a un tono naranja */
	font-family: 'McLaren', sans-serif;
	/* Cambia la fuente a Arial o a la que prefieras */
	font-size: 20px; /* Aumenta el tamaño de la fuente */
	/* Ajusta el espaciado entre líneas */
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
		<br>
		<div class="container mt-4">
			<!-- ... -->
			<div id="carouselExampleControls" class="carousel slide"
				data-bs-ride="carousel" data-bs-interval="2000"
				data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/banner/banner_inicio1.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/banner/banner_inicio2.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/banner/banner_inicio3.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/banner/banner_inicio4.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/banner/banner_inicio5.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<div class="carousel-item">
						<img src="img/banner/banner_inicio6.jpg"
							class="d-block w-100 img-carousel" alt="...">
					</div>
					<!-- Agrega más divs de carousel-item para más imágenes -->
				</div>

				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleControls" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>


			<!-- ... -->
		</div>
		<br>
		<main>
			<section class="py-5">
				<div class="container">
					<h2 class="mb-4">¿Por qué elegirnos?</h2>
					<div class="row">
						<div class="col-md-4 mb-4">
							<img src="img/Ingredientes.png" alt=""
								class="img-fluid img-size mb-3"> <strong>Ingredientes</strong>
							<p>Seleccionamos los mejores ingredientes disponibles en el
								mercado resultando productos de calidad.</p>
						</div>
						<div class="col-md-4 mb-4">
							<img src="img/mejores ches.jpg" alt=""
								class="img-fluid img-size mb-3"> <strong>Mejores
								chefs</strong>
							<p>Nuestro personal es altamente calificado, contamos con los
								mejores chefs pasteleros a nuestra disposición.</p>
						</div>
						<div class="col-md-4 mb-4">
							<img src="img/reconocimiento.jpg" alt=""
								class="img-fluid img-size mb-3"> <strong>Reconocimiento</strong>
							<p>Nuestros años de experiencia en este rubro nos respaldan,
								así como el reconocimiento en forma de premios que hemos
								obtenido.</p>
						</div>
					</div>
				</div>
			</section>


			<div class="carrousel">
				<div id="carouselExampleIndicators" class="carousel slide"
					data-bs-ride="carousel">
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide 1"></button>
						<button type="button" data-bs-target="#carouselExampleIndicators"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<!-- Agrega más botones de indicadores para más imágenes -->
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="img/banner-ofertas1.png" alt="...">
						</div>
						<div class="carousel-item">
							<img src="img/banner-ofertas2.png" alt="...">
						</div>
						<!-- Puedes agregar más elementos con la clase carousel-item para más imágenes -->
					</div>
					<!-- No es necesario tener botones de control si usas los indicadores -->
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
		crossorigin="anonymous"></script>

</body>
</html>