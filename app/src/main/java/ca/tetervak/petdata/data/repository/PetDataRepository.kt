package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.domain.Pet

interface PetDataRepository {

    fun getAllPets(): List<Pet>
    fun getPetById(id: Int): Pet?
}