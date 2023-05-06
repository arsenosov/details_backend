package com.arsenosov.routing

import com.arsenosov.data.*
import com.arsenosov.routing.configureComputerRouting
import com.arsenosov.routing.configureUserRouting
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.UUID

fun Application.configureRouting() {
    val service = DbService()
    configureUserRouting(service)
    configureComputerRouting(service)
}
