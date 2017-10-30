<?php

    include_once("db_config.php");
    
    try {

        $sqlStmt = "INSERT INTO movie_info(movie_name, 
                                           movie_price,
                                           movie_studio,
                                           movie_year,
                                           movie_desc) VALUES (
                                           :movie_name,
                                           :movie_price,
                                           :movie_studio,
                                           :movie_year,
                                           :movie_desc)";

        $prepStmt = $pdo->prepare($sqlStmt);

        $prepStmt->bindParam(":movie_name", $_POST["movie_name"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_price", $_POST["movie_price"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_studio", $_POST["movie_studio"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_year", $_POST["movie_year"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_desc", $_POST["movie_desc"], PDO::PARAM_STR);

        $prepStmt->execute();
        $newId = $pdo->lastInsertId();

        echo "Insert successful.";

        $pdo = null;
        
    }catch(PDOException $e) {
        echo "Insert failed: " . $e->getMessage() . "\n";
    }
?>