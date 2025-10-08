package ca.tetervak.petdata.ui.comon

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.petdata.R
import ca.tetervak.petdata.ui.theme.PetDataTheme

@Composable
fun LoadingScreenContent(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 32.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.loading_data),
            fontSize = 36.sp,
            color = colorResource(id = R.color.green_500)
        )
        Text(
            text = stringResource(R.string.fake_delay),
            fontSize = 24.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenContentPreview(){
    PetDataTheme {
        LoadingScreenContent()
    }
}