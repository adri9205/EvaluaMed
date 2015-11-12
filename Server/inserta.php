
<?php

/*INSERTA*/

$usuario = $_POST['usuario'];
$ID = $_POST['ID'];
$promedio = $_POST['promedio'];
$fecha = $_POST['fecha'];
$comentarios = $_POST['comentarios'];
//echo($comentarios);

require_once 'funciones.php';
$db = new funciones_BD();

	if($db->insert($usuario,$ID, $promedio, $fecha)){

	$resultado[]=array("logstatus"=>"0");
	
	}else{
		  	
	$resultado[]=array("logstatus"=>"1");
	}
$to = $ID."@itesm.mx";
$subject = "Comentarios de tu evaluacion de ".$usuario;
$txt = "Los comentarios de tu evaluador son: ".$_POST['comentarios'];
$headers = "From: mensajes@evaluacionqx.com" . "\r\n" .
"CC: mensajes@evaluacionqx.com";
mail($to,$subject, $txt);

echo json_encode($resultado);
//echo json_encode($output);




?>