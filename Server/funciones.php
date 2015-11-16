<?php
 
class funciones_BD {
 
    private $db;
 
    // constructor

    function __construct() {
        require_once 'connectbd.php';
        // connecting to database

        $this->db = new DB_Connect();
        $this->db->connect();

    }
 
    // destructor
    function __destruct() {
 
    }
 
    /**
     * agregar nuevo usuario
     */
    public function insert($usuario,$ID, $promedio, $fecha, $comentarios, $juicio, $conocimiento, $interrogatorio, $fisico, $clinico, $quirurgico, $comunicacion, $desempeno, $desarrollo) {

    $result = mysql_query("INSERT INTO rubrica(id_alumno, id_evaluador, fecha, promedio, juicio_clinico, conocimiento_medico, interrogatorio, exploracion_fisica, expediente_clinico, comportamiento_quirurgico, comunicacion, desempeno, desarrollo, comentarios) VALUES('$ID', '$usuario','$fecha','$promedio', '$juicio', '$conocimiento', '$interrogatorio', '$fisica', '$clinico', '$quirurgico', '$comunicacion', '$desempeno', '$desarrollo', '$comentarios')");
        // check for successful store

        if ($result) {

            return true;

        } else {

            return false;
        }

    }
 
 	
  
}
 
?>
