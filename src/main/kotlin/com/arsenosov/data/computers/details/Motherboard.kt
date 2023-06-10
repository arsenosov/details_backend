package com.arsenosov.data.computers.details

import com.arsenosov.data.*
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Motherboard(
    @BsonId
    val id: Id<Motherboard>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val cpuSocket: CPUSocket,
    val memoryTechnology: RAMTechnology,
    val memorySlots: Int,
    val chipset: String,
    val formFactor: MotherboardFormFactor,
    val clockSpeed: Int, // GHz
    val storageOutput: StorageOutput,
    val expansionSlots: List<ExpansionSlot>,
)

@Serializable
data class MotherboardDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val cpuSocket: String,
    val memoryTechnology: String,
    val memorySlots: Int,
    val chipset: String,
    val formFactor: String,
    val clockSpeed: Int,
    val storageOutput: String,
    val expansionSlots: List<String>,
)

fun Motherboard.toDtoEntity() =
    MotherboardDto(
        imageUrl, name, producedBy, cpuSocket.name, memoryTechnology.name, memorySlots, chipset, formFactor.name, clockSpeed, storageOutput.name, expansionSlots.map { it.name }
    )

fun MotherboardDto.toDbEntity() =
    Motherboard(
        null, imageUrl, name, producedBy, CPUSocket.valueOf(cpuSocket), RAMTechnology.valueOf(memoryTechnology), memorySlots, chipset, MotherboardFormFactor.valueOf(formFactor), clockSpeed, StorageOutput.valueOf(storageOutput), expansionSlots.map { ExpansionSlot.valueOf(it) }
    )
