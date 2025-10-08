package ca.tetervak.petdata.data.repository

import ca.tetervak.petdata.data.remote.PetDataApi
import ca.tetervak.petdata.data.remote.RemoteData
import ca.tetervak.petdata.data.remote.RemotePet
import ca.tetervak.petdata.data.remote.imageFolder
import ca.tetervak.petdata.domain.Pet
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemotePetDataRepository @Inject constructor(
    private val petDataApi: PetDataApi
): PetDataRepository {

    override suspend fun getAllPets(): List<Pet> =
        withContext(Dispatchers.IO) {
            val remoteData: RemoteData = petDataApi.getRemoteData()
            remoteData.pets.map { remotePet -> remotePet.toPet() }
        }

    override suspend fun getPetById(id: Int): Pet? {
        return getAllPets().find { pet -> pet.id == id }
    }
}

fun RemotePet.toPet() = Pet(
    id = this.id,
    name = this.name,
    petKind = this.petKind,
    age = this.age,
    imageUrl = imageFolder + this.image
)