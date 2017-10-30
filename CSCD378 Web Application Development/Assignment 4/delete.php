<?php

    include_once("db_config.php");
    
    try {

        $sqlStmt = "DELETE FROM movie_info WHERE movie_id = :movie_id";
        $prepStmt = $pdo->prepare($sqlStmt);
        $prepStmt->bindParam(":movie_id", $_POST["movie_id"], PDO::PARAM_INT);
        $prepStmt->execute();

        echo "Delete successful.";

        $pdo = null;
        
    }catch(PDOException $e) {
        echo "Delete failed: " . $e->getMessage() . "\n";
    }
?>