package com.arsenosov.data

//import com.arsenosov.data.computers.Cabinet
import org.litote.kmongo.*

class DbService {
    private val client = KMongo.createClient()
    private val userDatabase = client.getDatabase("user")
    private val cabinetDatabase = client.getDatabase("cabinet")
    private val userCollection = userDatabase.getCollection<User>()
    //private val cabinetCollection = cabinetDatabase.getCollection<Cabinet>()

    fun add(user: User): Id<User>? {
        userCollection.insertOne(user)
        return user.userId
    }

    fun getAllUsers() = userCollection.find().toList()

    fun userExists(login: String?) = userCollection.findOne(User::login eq login) != null

    fun deleteUser(id: Id<User>?) = userCollection.deleteOne(User::userId eq id)

    fun userByLogin(login: String?) = userCollection.findOne(User::login eq login)
}