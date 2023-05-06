package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.CPUSocket
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class CPU(
    @BsonId
    val id: Id<CPU>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val socket: CPUSocket,
    val processorCount: Int,
    val speed: Int, // GHz
    val chipsets: List<String>, // List of supported chipsets, like {"AMD A5XX"} or {"Intel 5XX", "Intel 6XX"}, regex-like
)

@Serializable
data class CPUDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val socket: String,
    val processorCount: Int,
    val speed: Int, // GHz
    val chipsets: List<String>,
)

fun CPU.toDtoEntity() =
    CPUDto(
        imageUrl, name, producedBy, socket.name, processorCount, speed, chipsets
    )

fun CPUDto.toDbEntity() =
    CPU(
        null, imageUrl, name, producedBy, CPUSocket.valueOf(socket), processorCount, speed, chipsets
    )
