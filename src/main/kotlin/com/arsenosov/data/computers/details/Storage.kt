package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.StorageOutput
import com.arsenosov.data.computers.StorageType
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Storage(
    @BsonId
    val id: Id<Storage>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val type: StorageType,
    val size: Int, // GB
    val outputType: StorageOutput,
)

@Serializable
data class StorageDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val type: String,
    val size: Int, // GB
    val outputType: String,
)

fun Storage.toDtoEntity() =
    StorageDto(
        imageUrl, name, producedBy, type.name, size, outputType.name
    )

fun StorageDto.toDbEntity() =
    Storage(
        null, imageUrl, name, producedBy, StorageType.valueOf(type), size, StorageOutput.valueOf(outputType)
    )
