
<?php

/*Olvido*/

$usuario = $_POST['usuario'];


require_once 'correo.php';
$db = new funciones_BD();

	if($db->olvido($usuario)){
	
		
$to = $usuario;
$subject = "Olvido de contraseña11";
$txt = "Lo sentimos, tu usuario no existe. Solicita ayuda al administrador. ";
$headers = "From: adri925@hotmail.com" . "\r\n" .
"CC: adri925@hotmail.com";
mail($to,$subject, $txt);

	$resultado[]=array("logstatus"=>"0");
	
	}else{
$sql=mysql_query("select password from evaluadores where id_evaluadores = '$usuario'");  
  
  while($row=mysql_fetch_assoc($sql))
  $output[]=$row;
  json_encode($output);

  	$to = $usuario;
$subject = "Olvido de contraseña11";
$txt = "Tu password es: ";
$txt .= json_encode($output);
$headers = "From: adri925@hotmail.com" . "\r\n" .
"CC: adri925@hotmail.com";
mail($to,$subject, $txt);
	$resultado[]=array("logstatus"=>"1");
	}

echo json_encode($resultado);
//echo json_encode($output);




?>