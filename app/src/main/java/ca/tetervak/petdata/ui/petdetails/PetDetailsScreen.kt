package ca.tetervak.petdata.ui.petdetails

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
fun PetDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: PetDetailsViewModel = hiltViewModel(),
    onNavigateBack: (() -> Unit)? = null
) {
    val state: State<PetDetailsUiState> = viewModel.uiState
    val uiState: PetDetailsUiState = state.value

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            PetDataTopAppBar(
                title = stringResource(R.string.list_title),
                scrollBehavior = scrollBehavior,
                onReloadButtonClick = viewModel::reloadData,
                onNavigateBack = onNavigateBack
            )
        }
    ) { innerPadding ->

        when (uiState) {
            is PetDetailsUiState.Loading -> {
                LoadingScreenContent(
                    modifier = modifier.padding(innerPadding)
                )
            }

            is PetDetailsUiState.Error -> {
                ErrorScreenContent(
                    onRetry = viewModel::reloadData,
                    modifier = modifier.padding(innerPadding)
                )
            }

            is PetDetailsUiState.Success ->
                DetailsScreenContent(
                    pet = uiState.pet,
                    modifier = modifier.padding(innerPadding)
                )
        }


    }
}

