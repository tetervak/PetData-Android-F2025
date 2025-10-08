package ca.tetervak.petdata.ui.petdetails

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.petdata.data.repository.PetDataRepository
import ca.tetervak.petdata.domain.Pet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetDetailsViewModel @Inject constructor(
    private val repository: PetDataRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val petId: Int = checkNotNull(savedStateHandle["petId"])

    private val _uiState: MutableState<PetDetailsUiState> =
        mutableStateOf(PetDetailsUiState.Loading)
    val uiState: State<PetDetailsUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // fake 2s delay
            delay(2000)

            _uiState.value =
                try {
                    val pet: Pet? = repository.getPetById(petId)
                    if (pet != null) {
                        PetDetailsUiState.Success(pet = pet)
                    } else {
                        PetDetailsUiState.Error
                    }
                } catch (_: Exception) {
                    PetDetailsUiState.Error
                }
        }
    }

    fun reloadData(){
        _uiState.value = PetDetailsUiState.Loading
        loadData()
    }
}