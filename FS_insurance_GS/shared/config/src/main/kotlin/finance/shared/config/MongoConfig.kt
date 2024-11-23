package finance.shared.config

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.connection.ConnectionPoolSettings
import org.litote.kmongo.coroutine.CoroutineClient
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

class MongoConfig(databaseName: String, databaseUrl: String) {
    private val log: Logger = LoggerFactory.getLogger(javaClass)

    private var client: CoroutineClient
    private var database: CoroutineDatabase

    init {
        log.info("Loading Mongo Config")
        client = KMongo.createClient(
            MongoClientSettings.builder()
                .applyConnectionString(ConnectionString(databaseUrl))
                .applyToConnectionPoolSettings {
                    ConnectionPoolSettings.builder().maxConnectionIdleTime(120000, TimeUnit.MILLISECONDS)
                        .minSize(5).maxSize(40)
                }
                .applicationName("Finance")
                .build()).coroutine
        database = client.getDatabase(databaseName)
    }

    fun getDatabase(): CoroutineDatabase {
        return database
    }

    fun getClient(): CoroutineClient {
        return client
    }
}
