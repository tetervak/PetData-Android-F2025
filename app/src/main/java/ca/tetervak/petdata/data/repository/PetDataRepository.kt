package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.domain.Pet

interface PetDataRepository {

    suspend fun getAllPets(): List<Pet>
    suspend fun getPetById(id: Int): Pet?
}