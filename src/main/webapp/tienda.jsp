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
<link
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.10.0/dist/sweetalert2.min.css"
	rel="stylesheet">

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
			<h3>Tienda</h3>
			<%--condicional si la cant de articulos es 0 --%>
			<c:if test="${cantArticulos == 0 }">
				<div class="container mt-4">
					<div style="text-align: center;">
						<img alt="" src="img/vacio.png">
						<p>
							Su carrito de compras está vacío. Haga clic en <a
								href="inicio?accion=home">catálogo</a> para buscar productos
						</p>
					</div>
					<div class="${estilo }" role="alert">${mensaje }</div>
				</div>
			</c:if>
			<%--condicional si la cant de articulos NO es 0 --%>
			<c:if test="${cantArticulos > 0 }">
				<%-- Mostrar una tabla con el contenido del carro --%>
				<div class="container mt-4">
					<div class="row">
						<div class="col-sm-8">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>IMAGEN</th>
										<th>CODIGO</th>
										<th>NOMBRE</th>
										<th>CANTIDAD</th>
										<th>PRECIO</th>
										<th>SUBTOTAL</th>
										<th>ACCION</th>
									</tr>
								</thead>
								<tbody>
									<%-- c:forEach --> equivalente al for each de java
									items : el nombre del atributo listado a recorer
									var : variable para cada elemento de lista
									for (Clase var : lista)
								 --%>
									<%-- localidad o region :idioma_Pais --%>
									<fmt:setLocale value="es_PE" />
									<c:forEach items="${carro }" var="d">
										<tr>
											<c:choose>
											    <c:when test="${not empty d.idtorta}">
											        <th><img width='100px' alt='producto' src='img/tortas/${d.idtorta}.jpeg'></th>
											    </c:when>
											    <c:otherwise>
											        <th><img width='100px' alt='bocadito' src='img/bocaditos/${d.id_boca}.jpeg'></th>
											    </c:otherwise>
											</c:choose>

											<c:choose>
											    <c:when test="${not empty d.idtorta}">
											        <td>${d.idtorta}</td>
											    </c:when>
											    <c:otherwise>
											        <td>${d.id_boca}</td>
											    </c:otherwise>
											</c:choose>
											<c:choose>
											    <c:when test="${not empty d.nomprot}">
											        <td>${d.nomprot}</td>
											    </c:when>
											    <c:otherwise>
											        <td>${d.nomboca}</td>
											    </c:otherwise>
											</c:choose>
											<td>${d.cantidad }</td>
											<td style="color: red;"><fmt:formatNumber
													value="${d.preciovta }" type="currency" /></td>
											<td><fmt:formatNumber
													value="${d.importe }" type="currency" /></td>
											<td><a href="eliminar?cod=${d.idtorta }"
												onclick="event.preventDefault(); showAlert(this.href, '${d.idtorta}');">
													<img alt="seccione producto" src="img/tacho.png">
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<br> <a href="inicio?accion=home" class="btn btn-primary">Continuar
								comprando <span class="glyphicon glyphicon-repeat"></span>
							</a>
							<br>
						</div>
						<div class="col-sm-4">
							<div class="card">
								<div class="card-header">
									<h3>Resumen de pedido</h3>
								</div>
								<div class="card-body">
									<hr>
									<%-- muestra la variable global enviada desde el Listener --%>
									<label>Total de tortas (${cantArticulos }) </label> <label>Sub
										total S/. ${subTotalVenta}</label>
									<hr>
								</div>
								<form action="pagar" method="post">
									<button class="btn btn-primary">
										Procesar compra<span class="glyphicon glyphicon-ok"></span>
									</button>
								</form>
								<br>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			<br>
			<br>
			<br>
		</main>
		<br>
			<br>
			<br>
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
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<script>
	function showAlert(link, idtorta) {
        Swal.fire({
            title: "¿Estás seguro?",
            text: "¡No podrás revertir esto!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "¡Sí, bórralo!"
        }).then((result) => {
            if (result.isConfirmed) {
                Swal.fire({
                    title: "¡Borrado!",
                    text: "Tu archivo ha sido borrado.",
                    icon: "success"
                }).then(() => {
                    // Navega a la siguiente página cuando se cierre la segunda alerta
                    parent.location.href = "eliminar?cod=" + idtorta;
                });
            }
        });
    }
	</script>
</body>
</html>