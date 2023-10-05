package com.muffar.daymeal.presentation.meals.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.daymeal.R
import com.muffar.daymeal.domain.model.Meal

@Composable
fun MealsItem(
    modifier: Modifier = Modifier,
    meal: Meal,
    onClick: (Meal) -> Unit,
) {
    val ctx = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable { onClick(meal) },
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(ctx)
                    .data(meal.image)
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_error)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(130.dp)
                    .align(Alignment.CenterHorizontally)
                    .graphicsLayer(
                        clip = true,
                        shape = MaterialTheme.shapes.small
                    )
            )
            Text(
                modifier = Modifier.padding(6.dp),
                text = meal.name ?: "",
                style = MaterialTheme.typography.labelLarge.copy(
                    lineHeight = 16.sp,
                    fontSize = 14.sp,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 2
            )
        }
    }
}