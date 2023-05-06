package com.arsenosov.data.computers.details

import com.arsenosov.data.computers.GraphicsOutput
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class Monitor(
    @BsonId
    val id: Id<Monitor>? = null,
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val diagonal: Float, // cm
    val resolution: String,
    val refreshRate: Float, // Hz
    val dpi: Float,
    val outputType: GraphicsOutput,
)

@Serializable
data class MonitorDto(
    val imageUrl: String? = null,
    val name: String,
    val producedBy: String,
    val diagonal: Float, // cm
    val resolution: String,
    val refreshRate: Float, // Hz
    val dpi: Float,
    val outputType: String
)

fun Monitor.toDtoEntity() =
    MonitorDto(
        imageUrl, name, producedBy, diagonal, resolution, refreshRate, dpi, outputType.name
    )

fun MonitorDto.toDbEntity() =
    Monitor(
        null, imageUrl, name, producedBy, diagonal, resolution, refreshRate, dpi, GraphicsOutput.valueOf(outputType)
    )
