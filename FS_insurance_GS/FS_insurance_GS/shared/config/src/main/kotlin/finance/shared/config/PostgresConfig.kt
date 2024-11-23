package finance.shared.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

class PostgresConfig {
    fun connect(isTestEnv: String = "N", dataBaseUrl: String, userName: String, dbPassword: String) {
        if (isTestEnv.equals("Y", true)) {
            println("Test env ")
            val config = HikariConfig()
            config.driverClassName = "org.h2.Driver"
            config.jdbcUrl = "jdbc:h2:mem:;DATABASE_TO_UPPER=false;MODE=MYSQL"
            config.maximumPoolSize = 2
            config.isAutoCommit = true
            config.validate()
            val source = HikariDataSource(config)
            Database.connect(source)
        } else {
            Database.connect(hikari(dataBaseUrl, userName, dbPassword))
        }
    }

    private fun hikari(dataBaseUrl: String, userName: String, dbPassword: String): HikariDataSource {
        val config = HikariConfig()
        config.driverClassName = "org.postgresql.Driver"
        config.jdbcUrl = dataBaseUrl
        config.username = userName
        config.password = dbPassword
        config.maximumPoolSize = 3
        config.isAutoCommit = false
        config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        config.maxLifetime = 90000
        config.validate()
        return HikariDataSource(config)
    }
}