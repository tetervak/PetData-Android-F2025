package ca.tetervak.petdata.ui.petlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.tetervak.petdata.R
import ca.tetervak.petdata.domain.Pet
import coil.compose.AsyncImage

@Composable
fun ListScreenContent(
    petList: List<Pet>,
    modifier: Modifier,
    onItemClick: (Int) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp, horizontal = 16.dp
        ), modifier = modifier
    ) {
        items(petList) { pet ->
            PetListItem(pet, { onItemClick(pet.id) })
        }
    }

}

@Composable
fun PetListItem(pet: Pet, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ){
            AsyncImage(
                model = "file:///android_asset/images/${pet.image}",
                contentDescription = "${pet.petKind} ${pet.name}"
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Text(
                        text = pet.petKind.capitalize(Locale.current),
                        fontSize = 28.sp
                    )
                    Text(
                        text = pet.name,
                        fontSize = 28.sp
                    )
                }
                Text(
                    text = pluralStringResource(id = R.plurals.years_old, pet.age, pet.age),
                    fontSize = 24.sp
                )
            }
        }
    }
}

