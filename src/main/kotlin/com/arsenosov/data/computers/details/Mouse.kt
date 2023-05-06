package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.MouseInterface
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Mouse(
    @BsonId
    val id: Id<Mouse>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val mouseInterface: MouseInterface,
    val buttons: Int,
)

@Serializable
data class MouseDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val mouseInterface: String,
    val buttons: Int,
)

fun Mouse.toDtoEntity() =
    MouseDto(
        imageUrl, name, producedBy, mouseInterface.name, buttons
    )

fun MouseDto.toDbEntity() =
    Mouse(
        null, imageUrl, name, producedBy, MouseInterface.valueOf(mouseInterface), buttons
    )
