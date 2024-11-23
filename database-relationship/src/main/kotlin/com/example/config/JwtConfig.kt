package com.example.config

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm
import java.util.*
import java.util.concurrent.TimeUnit

object JwtConfig {
    fun generateToken(secret: String, issuer: String, audience: String, expirationMinutes: Long): String {
        val expiration = Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(expirationMinutes))
        return JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withExpiresAt(expiration)
            .sign(Algorithm.HMAC256(secret))
    }

    fun jwtVerifier(secret: String, issuer: String): JWTVerifier {
        return JWT.require(Algorithm.HMAC256(secret))
            .withIssuer(issuer)
            .build()
    }
}