package com.arsenosov.data.computers.details

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
)

@Serializable
data class RAMDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val size: Int, // GB
    val memorySpeed: Int, // MHz
)

fun RAM.toDtoEntity() =
    RAMDto(
        imageUrl, name, producedBy, size, memorySpeed
    )

fun RAMDto.toDbEntity() =
    RAM(
        null, imageUrl, name, producedBy, size, memorySpeed
    )
