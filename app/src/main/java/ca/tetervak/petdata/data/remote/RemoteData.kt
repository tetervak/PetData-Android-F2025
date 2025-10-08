package ca.tetervak.petdata.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class RemoteData(
    val pets: List<RemotePet>
)