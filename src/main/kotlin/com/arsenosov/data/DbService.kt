package com.arsenosov.data

import com.arsenosov.data.computers.Computer
import com.arsenosov.data.computers.ComputerDto
import com.arsenosov.data.computers.details.*
import com.arsenosov.data.organisations.Cabinet
import com.arsenosov.data.organisations.Organisation
import com.arsenosov.data.organisations.User
import org.litote.kmongo.*
import org.litote.kmongo.util.idValue

class DbService {
    private val client = KMongo.createClient()
    private val userDatabase = client.getDatabase("user")
    private val computerDatabase = client.getDatabase("computer")

    private val organisationCollection = userDatabase.getCollection<Organisation>()
    private val userCollection = userDatabase.getCollection<User>()
    private val cabinetCollection = userDatabase.getCollection<Cabinet>()
    private val computerCollection = computerDatabase.getCollection<Computer>()
    private val caseCollection = computerDatabase.getCollection<Case>()
    private val mouseCollection = computerDatabase.getCollection<Mouse>()
    private val cpuCollection = computerDatabase.getCollection<CPU>()
    private val gpuCollection = computerDatabase.getCollection<GPU>()
    private val keyboardCollection = computerDatabase.getCollection<Keyboard>()
    private val monitorCollection = computerDatabase.getCollection<Monitor>()
    private val motherboardCollection = computerDatabase.getCollection<Motherboard>()
    private val powerUnitCollection = computerDatabase.getCollection<PowerUnit>()
    private val ramCollection = computerDatabase.getCollection<RAM>()
    private val storageCollection = computerDatabase.getCollection<Storage>()

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

    fun add(organisation: Organisation?): Id<Organisation>? {
        organisationCollection.insertOne(organisation)
        return organisation?.id
    }

    fun remove(id: Id<Organisation>?) = organisationCollection.deleteOne(Organisation::id eq id)

    fun getAllOrganisations() = organisationCollection.find().toList()

    fun add(mouse: Mouse): Id<Mouse>? {
        mouseCollection.insertOne(mouse)
        return mouse.id
    }

    fun remove(id: Id<Mouse>?) = mouseCollection.deleteOne(Mouse::id eq id)

    fun getUserById(id: String?): Id<User>? = userCollection.findOne()?.userId
    fun getAllMouses() = mouseCollection.find().toList()
    fun getAllComputers() = computerCollection.find().toList()

    fun add(computer: Computer?): Id<Computer>? {
        computerCollection.insertOne(computer)
        return computer?.id
    }

    fun remove(id: Id<Computer>?) = computerCollection.deleteOne(Computer::id eq id)

    fun getAllCPUs() = cpuCollection.find().toList()

    fun add(detail: CPU?): Id<CPU>? {
        cpuCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<CPU>?) = cpuCollection.deleteOne(CPU::id eq id)

    fun getAllGPUs() = gpuCollection.find().toList()

    fun add(detail: GPU?): Id<GPU>? {
        gpuCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<GPU>?) = gpuCollection.deleteOne(GPU::id eq id)

    fun getAllKeyboards() = keyboardCollection.find().toList()

    fun add(detail: Keyboard?): Id<Keyboard>? {
        keyboardCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<Keyboard>?) = keyboardCollection.deleteOne(Keyboard::id eq id)

    fun getAllMonitors() = monitorCollection.find().toList()

    fun add(detail: Monitor?): Id<Monitor>? {
        monitorCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<Monitor>?) = monitorCollection.deleteOne(Monitor::id eq id)

    fun getAllMotherboards() = motherboardCollection.find().toList()

    fun add(detail: Motherboard?): Id<Motherboard>? {
        motherboardCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<Motherboard>?) = motherboardCollection.deleteOne(Motherboard::id eq id)

    fun update(computer: ComputerDto) = computerCollection.findOneAndUpdate(computer.id eq idValue, computer)

    fun getAllPowerUnits() = powerUnitCollection.find().toList()

    fun add(detail: PowerUnit?): Id<PowerUnit>? {
        powerUnitCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<PowerUnit>?) = powerUnitCollection.deleteOne(PowerUnit::id eq id)

    fun getAllRAMs() = ramCollection.find().toList()

    fun add(detail: RAM?): Id<RAM>? {
        ramCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<RAM>?) = ramCollection.deleteOne(RAM::id eq id)

    fun getAllStorage() = storageCollection.find().toList()

    fun add(detail: Storage?): Id<Storage>? {
        storageCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<Storage>?) = storageCollection.deleteOne(Storage::id eq id)

    fun getAllCases() = caseCollection.find().toList()

    fun add(detail: Case?): Id<Case>? {
        caseCollection.insertOne(detail)
        return detail?.id
    }

    fun remove(id: Id<Case>?) = caseCollection.deleteOne(Case::id eq id)
}