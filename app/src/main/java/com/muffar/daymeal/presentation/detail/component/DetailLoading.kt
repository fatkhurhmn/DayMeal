package com.muffar.daymeal.presentation.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muffar.daymeal.ui.common.Shimmering

@Composable
fun DetailLoading() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Shimmering(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Shimmering(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Shimmering(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }
}