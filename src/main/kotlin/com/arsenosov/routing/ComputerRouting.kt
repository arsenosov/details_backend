package com.arsenosov.routing

import com.arsenosov.data.DbService
import com.arsenosov.data.computers.CabinetDto
import com.arsenosov.data.computers.details.MouseDto
import com.arsenosov.data.computers.details.MouseNoImage
import com.arsenosov.data.computers.details.toDbEntity
import com.arsenosov.data.computers.details.toDtoEntity
import com.arsenosov.data.computers.toDbEntity
import com.arsenosov.data.computers.toDtoEntity
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.ContentTransformationException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureComputerRouting(service: DbService) {
    mouseRouting(service)
}

fun Application.mouseRouting(service: DbService) {
    routing {
        route("/mouse") {
            post("/add") {
                var mouse: MouseDto
                try {
                    mouse = call.receive<MouseDto>()
                } catch (e: ContentTransformationException) {
                    mouse = call.receive<MouseNoImage>().toDtoEntity()
                }
                val id = service.add(mouse.toDbEntity())
                if (id != null) {
                    call.respond(HttpStatusCode.OK, "Mouse with id $id added successfully!")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Unknown error when adding mouse")
                }
            }
            get {
                try {
                    val mouses = service.getAllMouses()
                    call.respond(HttpStatusCode.OK, mouses.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
        }
    }
}