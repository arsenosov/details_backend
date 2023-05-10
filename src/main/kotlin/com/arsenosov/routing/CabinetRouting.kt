package com.arsenosov.routing

import com.arsenosov.data.DbService
import com.arsenosov.data.UserDto
import com.arsenosov.data.computers.*
import com.arsenosov.data.toDbEntity
import com.arsenosov.data.toDtoEntity
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.plugins.ContentTransformationException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureCabinetRouting(service: DbService) {
    routing {
        route("/cabinet") {
            post("/add") {
                val cabinet: CabinetDto = try {
                    call.receive<CabinetDto>()
                } catch (e: ContentTransformationException) {
                    call.receive<CabinetEmpty>().toDtoEntity()
                }
                if (service.cabinetExists(cabinet.name)) {
                    call.respond(HttpStatusCode.BadRequest, "That cabinet already exists!")
                } else {
                    val id = service.add(cabinet.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Cabinet with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding cabinet")
                    }
                }
            }
            post("/addByName") {
                try {
                    val name = call.parameters["name"] ?: throw BadRequestException("")
                    if (service.cabinetExists(name)) {
                        call.respond(HttpStatusCode.BadRequest, "That cabinet already exists!")
                    } else {
                        val id = service.add(Cabinet(null, name, null))
                        if (id != null) {
                            call.respond(HttpStatusCode.OK, "Cabinet with id $id added successfully!")
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Unknown error when adding cabinet")
                        }
                    }
                } catch (e: BadRequestException) {
                    call.respond(HttpStatusCode.UnsupportedMediaType)
                }
            }
            get {
                try {
                    val cabinets = service.getAllCabinets()
                    call.respond(HttpStatusCode.OK, cabinets.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
        }
    }
}