package com.arsenosov.data.computers

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

/*@Serializable
data class Cabinet(
    @BsonId
    val id: Id<Cabinet>? = null,
    val computers: List<Computer>? = null
)

@Serializable
data class CabinetDto(
    val computers: List<ComputerDto>? = null
)

fun Cabinet.toDtoEntity() =
    CabinetDto(
        computers = computers?.map { it.toDtoEntity() }
    )

fun CabinetDto.toDbEntity() =
    Cabinet(
        id = null,
        computers = computers?.map { it.toDbEntity() }
    )
*/