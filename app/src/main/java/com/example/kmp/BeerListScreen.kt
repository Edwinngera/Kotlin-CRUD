package com.example.kmp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.kmp.ui.theme.Beer
import okhttp3.internal.wait


@Composable
fun BeerListScreen(viewModel: BeerViewModel = viewModel()) {
    val beers = viewModel.beers.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {

        items(beers.value.size)
        {
            index->
            val beer = beers.value[index]
            BeerCard(beer = beer)
        }

    }
}

@Composable
fun BeerCard(beer: Beer){

    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)) {

        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically)
            {

            Image(
                painter =  rememberAsyncImagePainter(beer.image),
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = beer.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = beer.price, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Rating: ${beer.rating.average} (${beer.rating.reviews} reviews)", style = MaterialTheme.typography.bodySmall)
                }

            }



    }



}












