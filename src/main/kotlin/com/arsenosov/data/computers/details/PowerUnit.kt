package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.MotherboardFormFactor
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class PowerUnit(
    @BsonId
    val id: Id<PowerUnit>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val connectorType: MotherboardFormFactor,
    val wattage: Int, // W
)

@Serializable
data class PowerUnitDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val connectorType: String,
    val wattage: Int, // W
)

fun PowerUnit.toDtoEntity() =
    PowerUnitDto(
        imageUrl, name, producedBy, connectorType.name, wattage
    )

fun PowerUnitDto.toDbEntity() =
    PowerUnit(
        null, imageUrl, name, producedBy, MotherboardFormFactor.valueOf(connectorType), wattage
    )
