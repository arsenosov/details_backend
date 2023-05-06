package com.arsenosov.data.computers

import com.arsenosov.data.computers.details.*
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

/*@Serializable
data class Computer(
    @BsonId
    val id: Id<Computer>? = null,
    val imageUrl: String? = null,
    val monitor: Monitor? = null,
    val keyboard: Keyboard? = null,
    val mouse: Mouse? = null,
    val motherboard: Motherboard? = null,
    val cpu: CPU? = null,
    val ram: List<RAM>? = null,
    val storage: List<Storage>? = null,
    val graphics: GPU? = null,
    val sound: SoundCard? = null,
    val speakers: Speakers? = null,
    val powerUnit: PowerUnit? = null
)

@Serializable
data class ComputerDto(
    val imageUrl: String? = null,
    val monitor: MonitorDto? = null,
    val keyboard: KeyboardDto? = null,
    val mouse: MouseDto? = null,
    val motherboard: MotherboardDto? = null,
    val cpu: CPUDto? = null,
    val ram: List<RAMDto>? = null,
    val storage: List<StorageDto>? = null,
    val graphics: GPUDto? = null,
    val sound: SoundCardDto? = null,
    val speakers: SpeakersDto? = null,
    val powerUnit: PowerUnitDto? = null
)

fun Computer.toDtoEntity() =
    ComputerDto(
        imageUrl,
        monitor?.toDtoEntity(),
        keyboard,
        mouse,
        motherboard,
        cpu,
        ram,
        storage?.map { it.toDtoEntity() },
        graphics,
        sound,
        speakers,
        powerUnit
    )

fun ComputerDto.toDbEntity() =
    Computer(
        null,
        imageUrl,
        monitor?.toDbEntity(),
        keyboard,
        mouse,
        motherboard,
        cpu,
        ram,
        storage?.map { it.toDbEntity() },
        graphics,
        sound,
        speakers,
        powerUnit
    )
*/