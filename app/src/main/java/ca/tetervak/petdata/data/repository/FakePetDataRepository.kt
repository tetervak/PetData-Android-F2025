package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.data.local.fakePetList
import ca.tetervak.petdata.domain.Pet
import javax.inject.Inject

class FakePetDataRepository @Inject constructor(
): PetDataRepository {

    override suspend fun getAllPets(): List<Pet> = fakePetList

    override suspend fun getPetById(id: Int): Pet? = fakePetList.find { it.id == id }
}