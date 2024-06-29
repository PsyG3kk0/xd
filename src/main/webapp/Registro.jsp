<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/jpg" href="img/favicon.ico">
<link rel="stylesheet" href="css/estilosReg.css" >
</head>
<body>
	<div class="container vertical-center">
		<div class="col-md-8">
			<div class="login-block">
				<div class="row">
					<div class="col-md-6">
						<img src="img/ps.png" alt="Imagen de inicio de sesión"
							class="login-image">
					</div>
					<div class="col-md-6">
						<div class="login-form">
							<h1 class="text-center">Unete a una travesia deliciosa</h1>

							<form id="registroForm" action="rs" method="post">
								<div class="form-group">
									<label for="inputNombre">Nombre</label> <input type="text"
										name="txtnombre" class="form-control" id="inputNombre"
										placeholder="Introduce tu Nombre">
								</div>
								<div class="form-group">
									<label for="inputApellido">Apellido</label> <input type="text"
										name="txtapellido" class="form-control" id="inputApellido"
										placeholder="Introduce tu Apellido">
								</div>
								<div class="form-group">
									<label for="inputEdad">Edad</label> <input type="number"
										name="txtedad" class="form-control" id="inputEdad"
										placeholder="Introduce tu Edad">
								</div>
								<div class="form-group">
									<label for="inputEmail4">Usuario o correo</label> <input
										type="text" name="txtusuario" class="form-control"
										id="inputEmail4" placeholder="Introduce tu Correo">
								</div>
								<div class="form-group">
									<label for="inputPassword4">Contraseña</label> <input
										type="password" name="txtclave" class="form-control"
										id="inputPassword4" placeholder="Introduce Contraseña">
								</div>




								<a href="Login.jsp" class="btn btn-iniciar-sesion"> Iniciar
									Sesión </a>



								<button type="submit" class="btn btn-success" name="btnOpcion"
									value="reg">Crear cuenta nueva</button>



							</form>
							<br>

						</div>
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

	<script>
		$(document)
				.ready(
						function() {
							$("#registroForm")
									.validate(
											{
												errorPlacement : function(
														error, element) {
													// Personaliza la ubicación del mensaje de error
													error
															.insertAfter(
																	element)
															.addClass(
																	"text-danger");
												},
												rules : {
													txtnombre : {
														required : true,
														lettersonly : true
													},
													txtapellido : {
														required : true,
														lettersonly : true
													},
													txtedad : {
														required : true,
														digits : true,
														min : 18
													},
													txtusuario : {
														required : true,
														customEmail : true
													},
													txtclave : {
														required : true,
														minlength : 5
													}
												},
												messages : {
													txtnombre : {
														required : '<i class="fas fa-exclamation-circle"></i> Por favor, introduce tu nombre',
														lettersonly : '<i class="fas fa-exclamation-circle"></i> El nombre no debe contener números'
													},
													txtapellido : {
														required : '<i class="fas fa-exclamation-circle"></i> Por favor, introduce tu apellido',
														lettersonly : '<i class="fas fa-exclamation-circle"></i> El apellido no debe contener números'
													},
													txtedad : {
														required : '<i class="fas fa-exclamation-circle"></i> Por favor, introduce tu edad',
														digits : '<i class="fas fa-exclamation-circle"></i> La edad debe ser un número entero',
														min : '<i class="fas fa-exclamation-circle"></i> Debes tener al menos 18 años'
													},
													txtusuario : {
														required : '<i class="fas fa-exclamation-circle"></i> Por favor, introduce tu correo',
														customEmail : '<i class="fas fa-exclamation-circle"></i> El correo debe contener al menos un @'
													},
													txtclave : {
														required : '<i class="fas fa-exclamation-circle"></i> Por favor, introduce tu contraseña',
														minlength : '<i class="fas fa-exclamation-circle"></i> La contraseña debe tener al menos 5 caracteres'
													}
												},
												submitHandler : function(form) {
													// Agrega código para enviar el formulario si pasa la validación
													form.submit();
												}
											});

							// Agregar método personalizado para validar solo letras en el campo de nombre y apellido
							$.validator.addMethod("lettersonly", function(
									value, element) {
								return this.optional(element)
										|| /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/
												.test(value);
							}, "Este campo no debe contener números");

							// Agregar método personalizado para validar que el campo de usuario contenga al menos un @
							$.validator.addMethod("customEmail", function(
									value, element) {
								return this.optional(element)
										|| value.indexOf('@') !== -1;
							}, "El correo debe contener al menos un @");
						});
	</script>










</body>
</html>