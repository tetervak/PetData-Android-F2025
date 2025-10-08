package ca.tetervak.petdata.ui.petdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.petdata.R
import ca.tetervak.petdata.domain.Pet
import ca.tetervak.petdata.ui.theme.PetDataTheme
import coil.compose.AsyncImage

@Composable
fun DetailsScreenContent(pet: Pet, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(32.dp)
            .fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Companion.CenterHorizontally,
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = pet.petKind.capitalize(Locale.Companion.current),
                    fontSize = 28.sp
                )
                Text(
                    text = pet.name,
                    fontSize = 28.sp
                )
            }

            AsyncImage(
                model = "file:///android_asset/images/${pet.image}",
                contentDescription = "${pet.petKind} ${pet.name}"
            )

            Text(
                text = pluralStringResource(id = R.plurals.years_old, pet.age, pet.age),
                fontSize = 24.sp
            )
        }
    }
}