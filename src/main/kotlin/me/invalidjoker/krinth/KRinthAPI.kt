package me.invalidjoker.krinth

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import me.invalidjoker.krinth.handlers.Projects

class KRinthAPI(val userAgent: String = "KRinth (InvalidJokerDE/KRinth)", val staging: Boolean = false) {
    private val client = HttpClient(CIO) {
        expectSuccess = false

        install(ContentNegotiation) {
            json()
        }

        defaultRequest {
            header(HttpHeaders.UserAgent, userAgent)
            url {
                protocol = URLProtocol.HTTPS
                host = if (staging) "staging-api.modrinth.com/v2" else "api.modrinth.com/v2"
            }
        }
    }

    val projects = Projects(client)

}