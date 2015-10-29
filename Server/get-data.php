<?php
 
//Configuracion de la conexion a base de datos
  /*$bd_host = "localhost"; 
  $bd_usuario = "evaluac4_equipo"; 
  $bd_password = "equipo2222*"; 
  $bd_base = "evaluac4_base"; 
 
	$con = mysql_connect($bd_host, $bd_usuario, $bd_password); 
	mysql_select_db($bd_base, $con); 
 
//consulta todos los empleados
$sql=mysql_query("SELECT * FROM alumnos",$con);
while ($row = mysql_fetch_array($sql)){
echo json_encode($row);}*/

 header('Content-type: application/json');
  mysql_connect("localhost","evaluac4_equipo","equipo2222*");
  mysql_select_db("evaluac4_base");
  
	$sql=mysql_query("select * from alumnos ORDER BY especialidad ASC, nivel ASC, nombre ASC, apellido_p ASC, apellido_m ASC");  
  
  while($row=mysql_fetch_assoc($sql))
  $output[]=$row;
  json_encode($output);
  print(json_encode($output));
  mysql_close();
?>