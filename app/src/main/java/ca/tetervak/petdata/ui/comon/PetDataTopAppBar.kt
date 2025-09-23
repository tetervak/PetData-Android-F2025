package ca.tetervak.petdata.ui.comon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import ca.tetervak.petdata.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDataTopAppBar(
    title: String,
    scrollBehavior: TopAppBarScrollBehavior,
    onHelpButtonClick: (() -> Unit)? = null,
    onNavigateBack: (() -> Unit)? = null
) = CenterAlignedTopAppBar(
    title = {
        Text(
            text = title,
            fontSize = 24.sp
        )
    },
    navigationIcon = {
        if (onNavigateBack != null) {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    },
    actions = {
        if (onHelpButtonClick != null){
            IconButton(
                onClick = onHelpButtonClick,
                colors = IconButtonDefaults.iconButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_help_outline_24),
                    contentDescription = stringResource(R.string.about)
                )
            }
        }
    },
    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary,
    ),
    scrollBehavior = scrollBehavior,
)