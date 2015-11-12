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
    public function insert($usuario,$ID, $promedio, $fecha) {

    $result = mysql_query("INSERT INTO rubrica(id_alumno, id_evaluador, fecha, promedio) VALUES('$ID', '$usuario','$fecha','$promedio')");
        // check for successful store

        if ($result) {

            return true;

        } else {

            return false;
        }

    }
 
 	
  
}
 
?>
