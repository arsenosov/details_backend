package com.arsenosov.data.computers.details

import com.arsenosov.data.MotherboardFormFactor
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import kotlin.math.sign

@Serializable
data class Case(
    @BsonId
    val id: Id<Case>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val size: MotherboardFormFactor
)

@Serializable
data class CaseDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val size: String
)

fun Case.toDtoEntity() =
    CaseDto(
        imageUrl, name, producedBy, size.name
    )

fun CaseDto.toDbEntity() =
    Case(
        null, imageUrl, name, producedBy, MotherboardFormFactor.valueOf(size)
    )
