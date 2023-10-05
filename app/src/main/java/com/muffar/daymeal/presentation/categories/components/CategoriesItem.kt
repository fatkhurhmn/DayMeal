package com.muffar.daymeal.presentation.categories.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.muffar.daymeal.R
import com.muffar.daymeal.domain.model.Category
import com.muffar.daymeal.ui.theme.DayMealTheme

@Composable
fun CategoriesItem(
    modifier: Modifier = Modifier,
    category: Category,
    onClick: (Category) -> Unit,
) {
    val ctx = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick(category) },
        shape = MaterialTheme.shapes.medium,
    ) {
        Box {
            AsyncImage(
                model = ImageRequest.Builder(ctx)
                    .data(category.image)
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_error)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = category.name,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.background,
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(color = MaterialTheme.colorScheme.scrim.copy(alpha = 0.3f))
                    .padding(vertical = 2.dp, horizontal = 8.dp),
            )
        }
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun CategoriesItemPreview() {
    DayMealTheme {
        CategoriesItem(
            category = Category(
                id = "",
                name = "Beef",
                description = "",
                image = "https://www.themealdb.com/images/category/beef.png"
            ),
            onClick = {}
        )
    }
}