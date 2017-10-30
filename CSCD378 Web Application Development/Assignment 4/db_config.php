<?php

    $servername = "localhost";
    $username = "test";
    $password = "test"; 

    try {

        $pdo = new PDO("mysql:host=$servername;dbname=moviedatabase", $username, $password);
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    }catch(PDOException $e) {
        echo "Connection failed: " . $e->getMessage() . "\n";
    }
?>