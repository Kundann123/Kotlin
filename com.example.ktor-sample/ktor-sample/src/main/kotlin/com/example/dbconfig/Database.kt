package com.example.dbconfig

import org.ktorm.database.Database

val database = Database.connect(
    url="jdbc:postgresql://localhost:5433/postgres",
    driver = "org.postgresql.Driver",
    user = "postgres",
    password = "Techout"
)