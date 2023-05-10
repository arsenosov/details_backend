package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.GPUMemory
import com.arsenosov.data.computers.GraphicsOutput
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class GPU(
    @BsonId
    val id: Id<GPU>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val memory: Int, // GB
    val memoryType: GPUMemory,
    val clockSpeed: Int, // GHz
    val output: GraphicsOutput,
    val power: Int, // W
)

@Serializable
data class GPUDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val memory: Int, // GB
    val memoryType: String,
    val clockSpeed: Int, // GHz
    val output: String,
    val power: Int, // W
)

fun GPU.toDtoEntity() =
    GPUDto(
        imageUrl, name, producedBy, memory, memoryType.name, clockSpeed, output.name, power
    )

fun GPUDto.toDbEntity() =
    GPU(
        null, imageUrl, name, producedBy, memory, GPUMemory.valueOf(memoryType), clockSpeed, GraphicsOutput.valueOf(output), power
    )
