package com.arsenosov.data

import com.arsenosov.data.computers.Cabinet
import com.arsenosov.data.computers.details.Mouse
import org.litote.kmongo.*

class DbService {
    private val client = KMongo.createClient()
    private val userDatabase = client.getDatabase("user")
    private val cabinetDatabase = client.getDatabase("cabinet")

    private val userCollection = userDatabase.getCollection<User>()
    private val cabinetCollection = cabinetDatabase.getCollection<Cabinet>()
    private val mouseCollection = cabinetDatabase.getCollection<Mouse>()

    fun add(user: User?): Id<User>? {
        userCollection.insertOne(user)
        return user?.userId
    }

    fun getAllUsers() = userCollection.find().toList()

    fun userExists(login: String?) = userCollection.findOne(User::login eq login) != null

    fun deleteUser(id: Id<User>?) = userCollection.deleteOne(User::userId eq id)

    fun userByLogin(login: String?) = userCollection.findOne(User::login eq login)

    fun add(cabinet: Cabinet?): Id<Cabinet>? {
        cabinetCollection.insertOne(cabinet)
        return cabinet?.id
    }

    fun cabinetExists(name: String?) = (cabinetCollection.findOne(Cabinet::name eq name) != null).also { println(Cabinet::name eq name) }

    fun getAllCabinets() = cabinetCollection.find().toList()

    fun add(mouse: Mouse): Id<Mouse>? {
        mouseCollection.insertOne(mouse)
        return mouse.id
    }

    fun getUserById(id: String?): Id<User>? = userCollection.findOne()?.userId
    fun getAllMouses() = mouseCollection.find().toList()
}