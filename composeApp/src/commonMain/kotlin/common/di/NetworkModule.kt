package common.di


import common.database.getRoomDatabase
import getDatabaseBuilder
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.dsl.module

fun networkModule(applicationContext: KoinApplication) = module {

    single {

        val client = HttpClient(CIO) {
            expectSuccess = true
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        println("HTTP Client: $message")
                    }
                }
            }

            defaultRequest {
                header("Content-Type", "application/json")
                url("https://api.climatetrace.org/v4/")
//                url("http://192.168.1.17:8081/")
//                url("http://10.0.0.47:8095/")
            }

            /*       install(WebSockets) {
                       contentConverter = KotlinxWebsocketSerializationConverter(Json)
                       val urlBuilder = URLBuilder(
                           protocol = URLProtocol.WSS,
                           host = "beep-beep-api-gateway-nap2u.ondigitalocean.app/",
       //    Local         host = "192.168.1.100",
       //    Local         port = 8081
                       )
                       Url(urlBuilder)
                       pingInterval = 10000
                   }*/

            install(ContentNegotiation) {
                json(
                    Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
        client
    }


    single {

        val appDatabase = getRoomDatabase(getDatabaseBuilder(applicationContext))
        appDatabase

    }

}
