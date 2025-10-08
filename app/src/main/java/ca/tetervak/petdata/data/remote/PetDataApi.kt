package ca.tetervak.petdata.data.remote

import retrofit2.http.GET

interface PetDataApi {

    @GET("pets.json")
    suspend fun getRemoteData(): RemoteData
}