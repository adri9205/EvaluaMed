<?php
// Connection 
$matricula=$_GET['id'];
$conn=mysql_connect('localhost','evaluac4_equipo','equipo2222*');
$db=mysql_select_db('evaluac4_base',$conn);
//echo($_GET['id']);
$mes =date("m");
$filename = "calificaciones.xls"; // File Name
// Download file
header("Content-Disposition: attachment; filename=\"$filename\"");
header("Content-Type: application/vnd.ms-excel");
$user_query = mysql_query("select rubrica.id_alumno as 'Matricula', rubrica.promedio as 'Promedio', rubrica.fecha as 'Fecha', rubrica.juicio_clinico as 'Juicio Clinico', rubrica.conocimiento_medico as 'Conocimiento Medico', rubrica.interrogatorio as 'Interrogatorio', rubrica.exploracion_fisica as 'Exploracion Fisica', rubrica.expediente_clinico as 'Expediente Clinico', rubrica.comportamiento_quirurgico as 'Comportamiento Quirurgico', rubrica.comunicacion as 'Comunicacion', rubrica.desempeno as 'Desempeno', rubrica.desarrollo as 'Desarrollo',evaluadores.nombre as 'Evaluador', rubrica.comentarios as 'Comentarios' from rubrica, evaluadores where rubrica.id_alumno = '$matricula' and  rubrica.id_evaluador=evaluadores.id_evaluadores and MONTH(rubrica.fecha)= '$mes'");

$user = mysql_query("Select AVG(promedio) from rubrica where MONTH(fecha)= '$mes'");
// Write data to file
$flag = false;
while ($row = mysql_fetch_assoc($user_query)) {
    if (!$flag) {
        // display field/column names as first row
        echo implode("\t", array_keys($row)) . "\r\n";
        $flag = true;
    }
    echo implode("\t", array_values($row)) . "\r\n";
}
while ($row = mysql_fetch_assoc($user)) {
	echo ("Promedio ");
    echo implode("\t", array_values($row)) . "\r\n"; }
?>