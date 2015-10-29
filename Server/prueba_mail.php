<?php
$username = $_POST['usuario'];
header('Content-type: application/json');
  mysql_connect("localhost","evaluac4_equipo","equipo2222*");
  mysql_select_db("evaluac4_base");
  
	//$sql=mysql_query("SELECT password FROM evaluadores WHERE id_evaluadores='maestro1@gmail.com' ");  
	$result = mysql_query("SELECT id_evaluadores from evaluadores WHERE id_evaluadores = '$username'");

        $num_rows = mysql_num_rows($result); //numero de filas retornadas

        if ($num_rows > 0) {

            // el usuario existe 

$sql=mysql_query("select password from evaluadores where id_evaluadores = '$username'");  
  
  while($row=mysql_fetch_assoc($sql))
  $output[]=$row;
  json_encode($output);
  //print(json_encode($output));
  //$obj=json_encode($output);
  //$obj2=json_decode($obj);
 // print $obj2->{'password'};
  	$to = "adri925@gmail.com";
$subject = "Olvido de contraseña";
$txt = "Tu password es: ";
$txt .= json_encode($output);
$headers = "From: adri925@hotmail.com" . "\r\n" .
"CC: adri925@hotmail.com";
mail($to,$subject, $txt);
//echo json_encode($sql);
echo ("enviado");
           
        } else {
            // no existe
            echo ("no existe");
			$to = "adri925@gmail.com";
$subject = "Olvido de contraseña";
$txt = "Lo sentimos, tu usuario no existe. Solicita ayuda al administrador. ";
$headers = "From: adri925@hotmail.com" . "\r\n" .
"CC: adri925@hotmail.com";
mail($to,$subject, $txt);
        }
 

?>