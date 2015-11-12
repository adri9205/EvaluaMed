
<?php

/*Olvido*/

$usuario = $_POST['usuario'];


require_once 'correo.php';
$db = new funciones_BD();

	if($db->olvido($usuario)){
	
		
$to = $usuario;
$subject = "Olvido de contraseña";
$txt = "Lo sentimos, tu usuario no existe. Solicita ayuda al administrador. ";
$headers = "From: mensajes@evaluacionqx.com" . "\r\n" .
"CC: mensajes@evaluacionqx.com";
mail($to,$subject, $txt);

	$resultado[]=array("logstatus"=>"0");
	
	}else{
$sql=mysql_query("select password from evaluadores where id_evaluadores = '$usuario'");  
  
  while($row=mysql_fetch_assoc($sql)){
  $output[]=$row;
  json_encode($output);
  
  $body .= " \n " ."Has solicitado tu contraseña"." \n "." \n " ."Password : ".$row['password']." \n "; 


  
  }

  	$to = $usuario;
$subject = "Olvido de contraseña";
//$txt = "Tu password es: ".$row["password"];
$headers = "From: mensajes@evaluacionqx.com" . "\r\n" .
"CC: mensajes@evaluacionqx.com";
mail($to,$subject, $body);
	$resultado[]=array("logstatus"=>"1");
	}

echo json_encode($resultado);
//echo json_encode($output);




?>