package com.example.plugins

import com.example.config.JwtConfig
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.jwt
import io.ktor.server.auth.jwt.JWTPrincipal

fun Application.configureAuthentication() {
    val jwtSecret = "your_secret_key"
    val jwtIssuer = "your_app"
    val jwtRealm = "your_realm"
    val jwtAudience = "your_audience"
    install(Authentication) {
        jwt {
            realm = jwtRealm
            verifier(JwtConfig.jwtVerifier(jwtSecret, jwtIssuer))
            validate { credential ->
                if (credential.payload.audience.contains(jwtAudience)) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
        }
    }
}
