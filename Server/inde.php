<?php
 
//Configuracion de la conexion a base de datos
  $bd_host = "localhost"; 
  $bd_usuario = "evaluac4_equipo"; 
  $bd_password = "equipo2222*"; 
  $bd_base = "evaluac4_base"; 
 
	$con = mysql_connect($bd_host, $bd_usuario, $bd_password); 
	mysql_select_db($bd_base, $con); 
 
//consulta todos los empleados
$sql=mysql_query("SELECT * FROM alumnos",$con);
$row = mysql_fetch_array($sql);
		echo json_encode($row);
?>

<!DOCTYPE html>							
<html>							
<head>	
<meta http-equiv="refresh" content="20">
<style>

	td {
	height: 40px; 
	} 

</style>


	

<title>Twitter</title>							
</head>		


<body>

		  	<?php
			$row = mysql_fetch_array($sql);
		echo json_encode($row);
 /* while($row = mysql_fetch_array($sql)){
 echo "<tr>";
  	echo "<td>".$row['nombre']."</td>";
	
  	echo "</tr>";
	$resultado[]=array("logstatus"=>row['nombre']);
	
  }
  echo json_encode($resultado);*/
?>
		    <td></td>
		  </tr>
		</table>

	</div>


</body>							
</html>	