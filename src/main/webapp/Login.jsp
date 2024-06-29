<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pasteleria Dulce Aventura</title>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/jpg" href="img/favicon.ico">
<link rel="stylesheet" href="css/estilos.css" >

</head>
<body>
	<div class="container vertical-center">
		<div class="col-md-8">
			<div class="login-block">
				<div class="row">
					<div class="col-md-6">
						<div class="login-form">
							<h1 class="text-center">Entra a una Dulce Aventura</h1>
							<form action="ls" method="post">
								<div class="form-group">
									<label for="inputEmail4">Usuario o correo</label> <input
										type="text" name="txtusuario" class="form-control"
										id="inputEmail4" placeholder="Introduce su Correo">
								</div>
								<div class="form-group">
									<label for="inputPassword4">Contraseña</label> <input
										type="password" name="txtclave" class="form-control"
										id="inputPassword4" placeholder="Introduce Contraseña">
								</div>
								<button type="submit" class="btn btn-iniciar-sesion"
									name="btnOpcion" value="ini">Iniciar Sesión</button>

								<a href="Registro.jsp" class="btn btn-iniciar-sesion"> Registro </a>
							</form>
							<br>
							<div class="${estilo}" role="alert">${mensaje}</div>
						</div>
					</div>
					<div class="col-md-6">
						<img src="img/Plogin.png" alt="Imagen de inicio de sesión"
							class="login-image">
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
		
		
		
		
</body>
</html>









