<?php

$id=$_SESSION['cookie1'];
if((!isset($_SESSION['username']))&&($_SESSION['username']=="admin")){
	
	header("location:default.html");
	
}

include 'configuration.php';

		$matricula 		= $_GET['matricula'];
		$nombre 		= $_GET['nombre'];
		$apellido_p 		= $_GET['apaterno'];
		$apellido_m 		= $_GET['amaterno'];
		$nivel 			= $_GET['nivel'];
		$especialidad 		= $_GET['especialidad'];
		
		if($matricula != ""){
		
			$result=mysql_query("select * from alumnos a WHERE a.id_alumno = '".$matricula."' ") or die(mysql_error()); 
			
		}
		else if(($nombre != "") || ($apellido_p != "") || ($apellido_m != "")){
		
			if($nombre != ""){
				
				$nombrebd = "a.nombre= '".$nombre."'";
			}
			else{
			
				$nombrebd = "";
			
			}
			if ($apellido_p != ""){
			
				if($nombre != ""){
			
					$apellido_pbd = "AND a.apellido_p= '".$apellido_p."'";
				}
				else{
					
					$apellido_pbd = "a.apellido_p= '".$apellido_p."'";
				}
			}
			else{
			
				$apellido_pbd = "";
			}
			if ($apellido_m != ""){
			
				if(($nombre != "") || ($apellido_p != "")){
			
					$apellido_mbd = "AND a.apellido_m= '".$apellido_m."'";
				
				}
				else{
				
					$apellido_mbd = "a.apellido_m= '".$apellido_m."' ";
				}
			}
			else{
			
				$apellido_mbd = "";
			}
			
			$result=mysql_query("select * from alumnos a WHERE ".$nombrebd.$apellido_pbd.$apellido_mbd."") or die(mysql_error()); 
		
		}
		else if(($nivel != 0)&&($especialidad != 0)){
		
			$result=mysql_query("select * from alumnos a WHERE a.nivel = '".$nivel."'  AND a.especialidad= '".$especialidad."'  ") or die(mysql_error()); 
		
		}
		else if($nivel != 0){
		
			$result=mysql_query("select * from alumnos a WHERE a.nivel = '".$nivel."'  ") or die(mysql_error());
		
		}
		else{
		
			$result=mysql_query("select * from alumnos a WHERE a.especialidad= '".$especialidad."'  ") or die(mysql_error());
		
		}
		

	$row = mysql_fetch_array($result);
	if($row != NULL){
		
	echo " <p></p>";
	echo "	<table class='as_gridder_table'>";
        echo "    <tr class='grid_header'>";
        echo "        <td>Matricula</td>";
        echo "        <td>Nombre(s)</td>";
        echo "        <td>Apellido P</td>";
        echo "        <td>Apellido M</td>";
        echo "        <td>A&ntilde;o</td>";
        echo "        <td>Especialidad</td>";
		echo "        <td>Descargar</td>";
               
        echo "    </tr>";
        
        do{
        
        
        echo "    <tr style='background-color:#FFFFFF'>";
                  
        echo "            <td><a href='http://evaluacionqx.com/db_malumnos.php?id=".$row['id_alumno']."'>".$row['id_alumno']."</a></td>";
        echo "            <td>".$row['nombre']."</td>";
        echo "            <td>".$row['apellido_p']."</td>";
        echo "            <td>".$row['apellido_m']."</td>";
        echo "     	 <td>"  .$row['nivel']. " </td>";
        echo "      	<td>". $row['especialidad'] ."</td>";
		echo "            <td><a href='http://evaluacionqx.com/excel.php?id=".$row['id_alumno']."'>"."Descargar"."</a></td>";
                    
                   
                    
	echo "			</tr>";
				
		}while($row = mysql_fetch_array($result)); 
         echo "       </table>";
						
	}  
	
	else {
		
		echo "<p> No se encontr&oacute; alg&uacute;n alumno con esos datos. </p>";

	}
?>