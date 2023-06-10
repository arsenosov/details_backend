package com.arsenosov.data.computers

import com.arsenosov.data.computers.details.*
import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
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
    val powerUnit: PowerUnit? = null,
    val case: Case? = null,
)

@Serializable
data class ComputerDto(
    val id: String,
    val imageUrl: String? = null,
    val monitor: MonitorDto? = null,
    val keyboard: KeyboardDto? = null,
    val mouse: MouseDto? = null,
    val motherboard: MotherboardDto? = null,
    val cpu: CPUDto? = null,
    val ram: List<RAMDto>? = null,
    val storage: List<StorageDto>? = null,
    val graphics: GPUDto? = null,
    val powerUnit: PowerUnitDto? = null,
    val case: CaseDto? = null,
)

fun Computer.toDtoEntity() =
    ComputerDto(
        id.toString(),
        imageUrl,
        monitor?.toDtoEntity(),
        keyboard?.toDtoEntity(),
        mouse?.toDtoEntity(),
        motherboard?.toDtoEntity(),
        cpu?.toDtoEntity(),
        ram?.map { it.toDtoEntity() },
        storage?.map { it.toDtoEntity() },
        graphics?.toDtoEntity(),
        powerUnit?.toDtoEntity(),
        case?.toDtoEntity(),
    )

fun ComputerDto.toDbEntity() =
    Computer(
        null,
        imageUrl,
        monitor?.toDbEntity(),
        keyboard?.toDbEntity(),
        mouse?.toDbEntity(),
        motherboard?.toDbEntity(),
        cpu?.toDbEntity(),
        ram?.map { it.toDbEntity() },
        storage?.map { it.toDbEntity() },
        graphics?.toDbEntity(),
        powerUnit?.toDbEntity(),
        case?.toDbEntity(),
    )
