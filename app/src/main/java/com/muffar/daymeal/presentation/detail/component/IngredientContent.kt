package com.muffar.daymeal.presentation.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muffar.daymeal.R
import com.muffar.daymeal.domain.model.Ingredient

@Composable
fun IngredientContent(
    modifier: Modifier = Modifier,
    ingredients: List<Ingredient>?,
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        ingredients?.let {
            item {
                Text(
                    text = stringResource(R.string.main_ingredient),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(14.dp))
            }
            items(it) { ingredient ->
                if (ingredient.ingredient?.isNotEmpty() == true) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "• ${ingredient.ingredient}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                lineHeight = 16.sp
                            ),
                            modifier = Modifier.weight(.5f)
                        )
                        Text(
                            text = ": ${ingredient.measure}",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Medium,
                                lineHeight = 16.sp
                            ),
                            modifier = Modifier.weight(.5f)
                        )
                    }
                }
            }
        }
    }
}