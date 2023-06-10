package com.arsenosov.routing

import com.arsenosov.data.DbService
import com.arsenosov.data.computers.ComputerDto
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.lang.Exception

fun Application.configureConnectionRouting(service: DbService) {
    routing {
        post("motherboard") {
            val computer: ComputerDto = call.receive()
            if (computer.ram?.all { it.technology == computer.motherboard?.memoryTechnology } != false
                && computer.storage?.all { it.outputType == computer.motherboard?.storageOutput } != false
                && computer.cpu?.chipsets?.any { equals(computer.motherboard?.chipset) } != false
                && computer.motherboard?.cpuSocket == (computer.cpu?.socket ?: computer.motherboard?.cpuSocket)
                && (computer.motherboard?.memorySlots ?: 0) >= (computer.ram?.size ?: 0)
                && computer.motherboard?.formFactor == (computer.powerUnit?.connectorType ?: computer.motherboard?.formFactor)
                && computer.motherboard?.formFactor == (computer.case?.size ?: computer.motherboard?.formFactor)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added motherboard to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding motherboard!")
        }
        delete("motherboard") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(motherboard = null))
            call.respond(HttpStatusCode.OK, "Successfully removed motherboard from computer ${computer.id}!")
        }
        post("case") {
            val computer = call.receive<ComputerDto>()
            if (computer.case?.size == (computer.motherboard?.formFactor ?: computer.case?.size)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added case to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding case!")
        }
        delete("case") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(case = null))
            call.respond(HttpStatusCode.OK, "Successfully removed case from computer ${computer.id}!")
        }
        post("cpu") {
            val computer = call.receive<ComputerDto>()
            if (computer.cpu?.chipsets?.any { equals(computer.motherboard?.chipset) } != false
                && computer.cpu?.socket == (computer.motherboard?.cpuSocket ?: computer.cpu?.socket)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added cpu to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding cpu!")
        }
        delete("cpu") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(cpu = null))
            call.respond(HttpStatusCode.OK, "Successfully removed cpu from computer ${computer.id}!")
        }
        post("gpu") {
            val computer = call.receive<ComputerDto>()
            if (computer.graphics?.output == (computer.monitor?.outputType ?: computer.graphics?.output)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added gpu to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding gpu!")
        }
        delete("gpu") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(graphics = null))
            call.respond(HttpStatusCode.OK, "Successfully removed gpu from computer ${computer.id}!")
        }
        post("keyboard") {
            try {
                val computer = call.receive<ComputerDto>()
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added keyboard to computer ${computer.id} successfully!")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, e.message ?: "Incompatibility issues with adding keyboard!")
            }
        }
        delete("keyboard") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(keyboard = null))
            call.respond(HttpStatusCode.OK, "Successfully removed keyboard from computer ${computer.id}!")
        }
        post("monitor") {
            val computer = call.receive<ComputerDto>()
            if (computer.monitor?.outputType == (computer.graphics?.output ?: computer.monitor?.outputType)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added monitor to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding monitor!")
        }
        delete("monitor") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(monitor = null))
            call.respond(HttpStatusCode.OK, "Successfully removed monitor from computer ${computer.id}!")
        }
        post("mouse") {
            try {
                val computer = call.receive<ComputerDto>()
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added mouse to computer ${computer.id} successfully!")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, e.message ?: "Incompatibility issues with adding mouse!")
            }
        }
        delete("mouse") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(mouse = null))
            call.respond(HttpStatusCode.OK, "Successfully removed mouse from computer ${computer.id}!")
        }
        post("powerunit") {
            val computer = call.receive<ComputerDto>()
            if (computer.powerUnit?.connectorType == (computer.motherboard?.formFactor ?: computer.powerUnit?.connectorType)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added power unit to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding power unit!")
        }
        delete("powerunit") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(powerUnit = null))
            call.respond(HttpStatusCode.OK, "Successfully removed power unit from computer ${computer.id}!")
        }
        post("ram") {
            val computer = call.receive<ComputerDto>()
            if (computer.ram?.all { it.technology == computer.motherboard?.memoryTechnology } != false
                && (computer.ram?.size ?: 0) <= (computer.motherboard?.memorySlots ?: Int.MAX_VALUE)) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added RAM to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding RAM!")
        }
        delete("ram") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(ram = null))
            call.respond(HttpStatusCode.OK, "Successfully removed RAM from computer ${computer.id}!")
        }
        post("storage") {
            val computer = call.receive<ComputerDto>()
            if (computer.storage?.all { it.outputType == computer.motherboard?.storageOutput } != false) {
                service.update(computer)
                call.respond(HttpStatusCode.OK, "Added storage to computer ${computer.id} successfully!")
            }
            call.respond(HttpStatusCode.BadRequest, "Incompatibility issues with adding storage!")
        }
        delete("storage") {
            val computer: ComputerDto = call.receive()
            service.update(computer.copy(storage = null))
            call.respond(HttpStatusCode.OK, "Successfully removed storage from computer ${computer.id}!")
        }
    }
}