package ca.tetervak.petdata.ui.petdetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.data.repository.FakePetDataRepository
import ca.tetervak.petdata.data.repository.PetDataRepository

class PetDetailsViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val repository: PetDataRepository = FakePetDataRepository()
    private val petId: Int = checkNotNull(savedStateHandle["petId"])

    private val _uiState: MutableState<PetDetailsUiState> =
        mutableStateOf(PetDetailsUiState(pet = repository.getPetById(petId)!!))
    val uiState: State<PetDetailsUiState> = _uiState
}