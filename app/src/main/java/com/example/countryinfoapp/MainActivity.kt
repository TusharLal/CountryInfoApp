package com.example.countryinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.countryinfoapp.data.Country
import com.example.countryinfoapp.data.getCountryListFromJson
import com.example.countryinfoapp.compasables.MainScreen

class MainActivity : ComponentActivity() {

    private lateinit var countries:MutableList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countries = getCountryListFromJson(applicationContext)
        enableEdgeToEdge()
        setContent {
            MainScreen(countries)
        }
    }
}