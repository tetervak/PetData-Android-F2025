package ca.tetervak.petdata.ui.petdetails

import ca.tetervak.petdata.domain.Pet

sealed interface PetDetailsUiState {
    object Loading: PetDetailsUiState
    data class Success(val pet: Pet): PetDetailsUiState
    object Error: PetDetailsUiState
}
