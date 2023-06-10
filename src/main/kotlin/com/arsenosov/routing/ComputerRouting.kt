package com.arsenosov.routing

import com.arsenosov.data.DbService
import com.arsenosov.data.computers.ComputerDto
import com.arsenosov.data.computers.details.*
import com.arsenosov.data.computers.toDbEntity
import com.arsenosov.data.computers.toDtoEntity
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.ContentTransformationException
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureComputerRouting(service: DbService) {
    routing {
        route("/computer") {
            post("/add") {
                val computer: ComputerDto = call.receive()
                val id = service.add(computer.toDbEntity())
                if (id != null) {
                    call.respond(HttpStatusCode.OK, "Computer with id $id added successfully!")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Unknown error when adding computer")
                }
            }
            get {
                try {
                    val computers = service.getAllComputers()
                    call.respond(HttpStatusCode.OK, computers.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
            delete {
                try {
                    val motherboard = call.receive<MotherboardDto>()
                    service.remove(motherboard.toDbEntity())
                    call.respond(HttpStatusCode.OK, "Deleted succesfully!")
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
        }
        route("/mouse") {
            post("/add") {
                val mouse: MouseDto = call.receive()
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
        route("/cpu") {
            post("/add") {
                val cpu: CPUDto = call.receive()
                val id = service.add(cpu.toDbEntity())
                if (id != null) {
                    call.respond(HttpStatusCode.OK, "CPU with id $id added successfully!")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Unknown error when adding CPU")
                }
            }
            get {
                try {
                    val cpus = service.getAllCPUs()
                    call.respond(HttpStatusCode.OK, cpus.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
        }
        route("/gpu") {
            post("/add") {
                val gpu: GPUDto = call.receive()
                val id = service.add(gpu.toDbEntity())
                if (id != null) {
                    call.respond(HttpStatusCode.OK, "GPU with id $id added successfully!")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Unknown error when adding gpu")
                }
            }
            get {
                try {
                    val gpus = service.getAllGPUs()
                    call.respond(HttpStatusCode.OK, gpus.map { it.toDtoEntity() })
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }
            }
            route("/keyboard") {
                post("/add") {
                    val keyboard: KeyboardDto = call.receive()
                    val id = service.add(keyboard.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Keyboard with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding keyboard")
                    }
                }
                get {
                    try {
                        val keyboards = service.getAllKeyboards()
                        call.respond(HttpStatusCode.OK, keyboards.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/monitor") {
                post("/add") {
                    val monitor: MonitorDto = call.receive()
                    val id = service.add(monitor.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Monitor with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding monitor")
                    }
                }
                get {
                    try {
                        val monitors = service.getAllMonitors()
                        call.respond(HttpStatusCode.OK, monitors.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/motherboard") {
                post("/add") {
                    val motherboard: MotherboardDto = call.receive()
                    val id = service.add(motherboard.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Motherboard with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding motherboard")
                    }
                }
                get {
                    try {
                        val motherboards = service.getAllMotherboards()
                        call.respond(HttpStatusCode.OK, motherboards.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/powerunit") {
                post("/add") {
                    val powerUnit: PowerUnitDto = call.receive()
                    val id = service.add(powerUnit.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Power unit with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding power unit")
                    }
                }
                get {
                    try {
                        val powerUnits = service.getAllPowerUnits()
                        call.respond(HttpStatusCode.OK, powerUnits.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/ram") {
                post("/add") {
                    val ram: RAMDto = call.receive()
                    val id = service.add(ram.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "RAM with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding RAM")
                    }
                }
                get {
                    try {
                        val rams = service.getAllRAMs()
                        call.respond(HttpStatusCode.OK, rams.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/storage") {
                post("/add") {
                    val storage: StorageDto = call.receive()
                    val id = service.add(storage.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Storage with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding storage")
                    }
                }
                get {
                    try {
                        val storages = service.getAllStorage()
                        call.respond(HttpStatusCode.OK, storages.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
            route("/case") {
                post("/add") {
                    val case: CaseDto = call.receive()
                    val id = service.add(case.toDbEntity())
                    if (id != null) {
                        call.respond(HttpStatusCode.OK, "Case with id $id added successfully!")
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Unknown error when adding case")
                    }
                }
                get {
                    try {
                        val cases = service.getAllCases()
                        call.respond(HttpStatusCode.OK, cases.map { it.toDtoEntity() })
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                    }
                }
            }
        }
    }
}