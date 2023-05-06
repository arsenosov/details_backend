package com.arsenosov.data.computers.details

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
)
