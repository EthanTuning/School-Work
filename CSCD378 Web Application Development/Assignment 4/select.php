<?php

    include_once("db_config.php");
    
    try {
        
        header('Content-type: application/json');
        $sqlStmt = "SELECT * FROM movie_info";
        $prepStmt = $pdo->prepare($sqlStmt);
        $prepStmt->execute();

        $results = $prepStmt->fetchAll(PDO::FETCH_ASSOC);
        $json = json_encode($results);
        echo $json;
        
        $pdo = null;

    }catch(PDOException $e) {
        echo "Select failed: " . $e->getMessage() . "\n";
    }

?>