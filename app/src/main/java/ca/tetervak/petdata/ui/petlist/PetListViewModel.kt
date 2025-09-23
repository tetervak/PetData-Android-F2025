package ca.tetervak.petdata.ui.petlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.data.repository.FakePetDataRepository
import ca.tetervak.petdata.data.repository.PetDataRepository

class PetListViewModel: ViewModel()  {

    private val repository: PetDataRepository = FakePetDataRepository()

    private val _uiState: MutableState<PetListUiState> =
        mutableStateOf(PetListUiState(pets = repository.getAllPets()))
    val uiState: State<PetListUiState> = _uiState
}