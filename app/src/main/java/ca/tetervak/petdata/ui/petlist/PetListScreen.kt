package ca.tetervak.petdata.ui.petlist

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import ca.tetervak.petdata.R
import ca.tetervak.petdata.ui.comon.ErrorScreenContent
import ca.tetervak.petdata.ui.comon.LoadingScreenContent
import ca.tetervak.petdata.ui.comon.PetDataTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetListScreen(
    modifier: Modifier = Modifier,
    viewModel: PetListViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit = {}
){
    val state: State<PetListUiState> = viewModel.uiState
    val uiState: PetListUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PetDataTopAppBar(
                title = stringResource(R.string.list_title),
                onReloadButtonClick = viewModel::reloadData,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        when(uiState){
            is PetListUiState.Loading -> LoadingScreenContent()
            is PetListUiState.Error -> ErrorScreenContent(
                onRetry = viewModel::reloadData
            )
            is PetListUiState.Success -> ListScreenContent(
                petList = uiState.pets,
                onItemClick = onItemClick,
                modifier = modifier.padding(innerPadding)
            )
        }
    }
}

