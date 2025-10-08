package ca.tetervak.petdata.ui.petlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import ca.tetervak.petdata.data.repository.PetDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PetListViewModel @Inject constructor(
    private val repository: PetDataRepository
): ViewModel()  {

    private val _uiState: MutableState<PetListUiState> =
        mutableStateOf(PetListUiState(pets = repository.getAllPets()))
    val uiState: State<PetListUiState> = _uiState
}