package com.example.myapplication.compasables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.countryinfoapp.compasables.CountryCardWithConstraintLayout
import com.example.countryinfoapp.data.Country

@Composable
fun CountryInfoCardComp(country: Country) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(width = 2.dp, color = Color.Black)
            .wrapContentHeight(align = Alignment.Top),
        color = MaterialTheme.colorScheme.surface,
        shadowElevation = 2.dp
    ) {
        CountryCardWithConstraintLayout(country)
    }
}