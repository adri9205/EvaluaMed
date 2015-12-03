
<?php

/*INSERTA*/

$usuario = $_POST['usuario'];
$ID = $_POST['ID'];
$promedio = $_POST['promedio'];
$fecha = $_POST['fecha'];
$comentarios = $_POST['comentarios'];
$juicio = $_POST['juicio'];
$conocimiento = $_POST['conocimiento'];
$interrogatorio = $_POST['interrogatorio'];
$fisico = $_POST['fisico'];
$clinico = $_POST['clinico'];
$quirurgico = $_POST['quirurgico'];
$comunicacion = $_POST['comunicacion'];
$desempeno = $_POST['desempeno'];
$desarrollo = $_POST['desarrollo'];
//$prom = floatval($_POST['promedio']);
//echo($comentarios);

require_once 'funciones.php';
$db = new funciones_BD();

	if($db->insert($usuario,$ID, $promedio, $fecha, $comentarios, $juicio, $conocimiento, $interrogatorio, $fisico, $clinico, $quirurgico, $comunicacion, $desempeno, $desarrollo)){

	$resultado[]=array("logstatus"=>"0");
	
	}else{
		  	
	$resultado[]=array("logstatus"=>"1");
	}

$subject = "Comentarios de tu evaluacion de ".$usuario;
$to = $ID."@itesm.mx";
$txt = "Los comentarios de tu evaluador son: ".$_POST['comentarios']."\n Tu calificacion para este evento fue de: ".$_POST['promedio'];
//$headers = "From: mensajes@evaluacionqx.com" . "\r\n" .;
mail($to,$subject, $txt);

$prom = (float) $promedio;
if ($prom < 7.0 ){
	$sql=mysql_query("select correo from administrador");  
  
  while($row=mysql_fetch_assoc($sql)){
  $output[]=$row;
$to = $row['correo'];
$txt = "El alumno con la matricula: ".$ID." obtuvo una calificacion de ".$promedio." para este evento. Los comentarios del evaluador ".$usuario." son: ".$comentarios;
//$to = "adri925@hotmail.com";
mail($to,$subject, $txt);
}}



echo json_encode($resultado);
//echo json_encode($output);




?>