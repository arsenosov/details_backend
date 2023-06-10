package com.arsenosov.routing

import com.arsenosov.data.DbService
import com.arsenosov.data.organisations.UserDto
import com.arsenosov.data.organisations.toDbEntity
import com.arsenosov.data.organisations.toDtoEntity
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Application.configureUserRouting(service: DbService) {
    routing {
        route("/users") {
            route("/{login}") {
                get {
                    val login = call.parameters["login"]
                    val user = service.userByLogin(login)
                    if (user != null) {
                        call.respond(HttpStatusCode.OK, user.toDtoEntity())
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "User not found")
                    }
                }
                delete {
                    val login = call.parameters["login"]
                    val user = service.userByLogin(login)
                    if (user == null) {
                        call.respond(HttpStatusCode.BadRequest, "User not found")
                    } else {
                        val result = service.deleteUser(user.userId)
                        if (result.deletedCount > 0) {
                            call.respond(HttpStatusCode.OK, "User with login $login deleted succesfully")
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Unknown error")
                        }
                    }
                }
                post {
                    try {
                        val user = call.receive<UserDto>()
                        val userDb = service.userByLogin(user.login)
                        if (user.login == userDb?.login && user.password == userDb.password) {
                            call.respond(HttpStatusCode.OK, UUID.randomUUID().toString())
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Incorrect credentials")
                        }
                    } catch (e: BadRequestException) {
                        call.respond(HttpStatusCode.UnsupportedMediaType)
                    }
                }
            }
            get {
                try {
                    val users = service.getAllUsers()
                    call.respond(HttpStatusCode.OK, users.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
            post("/add") {
                try {
                    val user = call.receive<UserDto>()
                    if (service.userExists(user.login)) {
                        call.respond(HttpStatusCode.BadRequest, "User with that login already exists!")
                    } else {
                        val id = service.add(user.toDbEntity())
                        if (id != null) {
                            call.respond(HttpStatusCode.OK, "User with id $id added successfully!")
                        } else {
                            call.respond(HttpStatusCode.BadRequest, "Unknown error when adding user")
                        }
                    }
                } catch (e: BadRequestException) {
                    call.respond(HttpStatusCode.UnsupportedMediaType)
                }
            }
            delete("/deleteById") {

            }
        }
    }
}