package com.arsenosov.data.computers.details

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
    val capacity: Int,
    val outputType: StorageOutput
)

enum class StorageType {
    HDD, SSD
}

enum class StorageOutput {
    PATA, SATA, eSATA, FireWire, SCSI, SAS, USB, ThunderBolt
}

@Serializable
data class StorageDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val type: String,
    val capacity: Int,
    val outputType: StorageOutput
)

fun Storage.toDtoEntity() =
    StorageDto(
        imageUrl, name, producedBy, type.name, capacity, outputType
    )

fun StorageDto.toDbEntity() =
    Storage(
        null, imageUrl, name, producedBy, StorageType.valueOf(type), capacity, outputType
    )
