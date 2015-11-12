
<?php

/*INSERTA*/

$usuario = "maestro";
$ID = "a01034348";

		  	$to = $ID."@itesm.mx";
$subject = "Comentarios de tu evaluacion de ".$usuario;
$txt = "prueba";
$headers = "From: mensajes@evaluacionqx.com" . "\r\n" .
"CC: mensajes@evaluacionqx.com";
mail($to,$subject, $txt);
	$resultado[]=array("logstatus"=>"1");
	




?>