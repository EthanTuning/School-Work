<?php

    include_once("db_config.php");
    
    try {

        $sqlStmt = "UPDATE movie_info SET movie_name = :movie_name,
                                          movie_price = :movie_price,
                                          movie_studio = :movie_studio,
                                          movie_year = :movie_year,
                                          movie_desc = :movie_desc
                                          
                    WHERE movie_id = :movie_id";

        $prepStmt = $pdo->prepare($sqlStmt);

        $prepStmt->bindParam(":movie_id", $_POST["movie_id"], PDO::PARAM_INT);
        $prepStmt->bindParam(":movie_name", $_POST["movie_name"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_price", $_POST["movie_price"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_studio", $_POST["movie_studio"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_year", $_POST["movie_year"], PDO::PARAM_STR);
        $prepStmt->bindParam(":movie_desc", $_POST["movie_desc"], PDO::PARAM_STR);

        $prepStmt->execute();

        echo "Update successful.";
        
        $pdo = null;

    }catch(PDOException $e) {
        echo "Update failed: " . $e->getMessage() . "\n";
    }
?>