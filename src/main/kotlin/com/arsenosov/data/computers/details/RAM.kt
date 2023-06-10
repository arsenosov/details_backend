package com.arsenosov.data.computers.details

import com.arsenosov.data.RAMTechnology
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class RAM(
    @BsonId
    val id: Id<RAM>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val size: Int, // GB
    val memorySpeed: Int, // MHz
    val technology: RAMTechnology
)

@Serializable
data class RAMDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val size: Int, // GB
    val memorySpeed: Int, // MHz
    val technology: String
)

fun RAM.toDtoEntity() =
    RAMDto(
        imageUrl, name, producedBy, size, memorySpeed, technology.name
    )

fun RAMDto.toDbEntity() =
    RAM(
        null, imageUrl, name, producedBy, size, memorySpeed, RAMTechnology.valueOf(technology)
    )
