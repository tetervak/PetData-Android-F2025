package ca.tetervak.petdata.ui.petlist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.petdata.data.repository.PetDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PetListViewModel @Inject constructor(
    private val repository: PetDataRepository
) : ViewModel() {

    private val _uiState: MutableState<PetListUiState> =
        mutableStateOf(PetListUiState.Loading)
    val uiState: State<PetListUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            // fake 2s delay
            delay(2000)

            _uiState.value = try {
                PetListUiState.Success(repository.getAllPets())
            } catch (_: Exception) {
                PetListUiState.Error
            }
        }
    }

    fun reloadData(){
        _uiState.value = PetListUiState.Loading
        loadData()
    }
}