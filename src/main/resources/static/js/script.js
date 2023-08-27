function mostrarCampos() {
    var seleccion = document.getElementById("opciones").value;
    var campos = document.getElementsByClassName("campo");

    // Oculta todos los campos
    for (var i = 0; i < campos.length; i++) {
      campos[i].style.display = "none";
    }
// Muestra los campos según la opción seleccionada
    if (seleccion === "cliente") {
      document.getElementById("cliente").style.display = "block";
      document.getElementById("boton").style.display = "block";
      

    } else if (seleccion === "profesional") {
      document.getElementById("profesional").style.display = "block";
      document.getElementById("boton").style.display = "block";
      
     
    } else if (seleccion === "administrativo") {
      document.getElementById("administrativo").style.display = "block";
      document.getElementById("boton").style.display = "block";
     
    }
    
  }

    