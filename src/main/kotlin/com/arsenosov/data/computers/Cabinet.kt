package com.arsenosov.data.computers

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Cabinet(
    @BsonId
    val id: Id<Cabinet>? = null,
    val name: String,
    val computers: List<Computer>? = null
)

@Serializable
data class CabinetDto(
    val name: String,
    val computers: List<ComputerDto>? = null
)

@Serializable
data class CabinetEmpty(
    val name: String,
)

fun Cabinet.toDtoEntity() =
    CabinetDto(
        name, computers?.map { it.toDtoEntity() }
    )

fun CabinetDto.toDbEntity() =
    Cabinet(
        null, name, computers?.map { it.toDbEntity() }
    )

fun CabinetEmpty.toDtoEntity() =
    CabinetDto(
        name, null
    )
