package com.arsenosov.data.computers.details

import com.arsenosov.data.KeyboardInterface
import com.arsenosov.data.KeyboardType
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Keyboard(
    @BsonId
    val id: Id<Keyboard>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val keysCount: Int,
    val keyboardType: KeyboardType,
    val keyboardInterface: KeyboardInterface,
)

@Serializable
data class KeyboardDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val keysCount: Int,
    val keyboardType: String,
    val keyboardInterface: String,
)

fun Keyboard.toDtoEntity() =
    KeyboardDto(
        imageUrl, name, producedBy, keysCount, keyboardType.name, keyboardInterface.name
    )

fun KeyboardDto.toDbEntity() =
    Keyboard(
        null, imageUrl, name, producedBy, keysCount, KeyboardType.valueOf(keyboardType), KeyboardInterface.valueOf(keyboardInterface)
    )
