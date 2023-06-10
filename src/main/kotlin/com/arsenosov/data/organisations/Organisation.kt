package com.arsenosov.data.organisations

import com.arsenosov.data.computers.Computer
import com.arsenosov.data.computers.ComputerDto
import com.arsenosov.data.computers.toDbEntity
import com.arsenosov.data.computers.toDtoEntity
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Organisation(
    @BsonId
    val id: Id<Organisation>? = null,
    val name: String,
    val cabinets: List<Cabinet>? = null
)

@Serializable
data class OrganisationDto(
    val name: String,
    val cabinets: List<CabinetDto>? = null
)

fun Organisation.toDtoEntity() =
    OrganisationDto(
        name, cabinets?.map { it.toDtoEntity() }
    )

fun OrganisationDto.toDbEntity() =
    Organisation(
        null, name, cabinets?.map { it.toDbEntity() }
    )
