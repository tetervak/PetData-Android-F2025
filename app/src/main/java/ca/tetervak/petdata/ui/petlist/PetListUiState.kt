package ca.tetervak.petdata.ui.petlist

import ca.tetervak.petdata.domain.Pet

sealed interface PetListUiState {
    object Loading: PetListUiState
    data class Success(val pets: List<Pet>): PetListUiState
    object Error: PetListUiState
}
