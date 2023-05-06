package com.arsenosov.data

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class User(
    @BsonId
    val userId: Id<User>? = null,
    val login: String,
    val password: String
)

@Serializable
data class UserDto(
    val login: String,
    val password: String
)

fun User.toDtoEntity() =
    UserDto(
        login = login,
        password = password
    )

fun UserDto.toDbEntity() =
    User(
        userId = null,
        login = login,
        password = password
    )
