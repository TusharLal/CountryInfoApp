package com.example.countryinfoapp.compasables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countryinfoapp.data.CountryInfo

@Composable
fun CountryInfoCardd(countryInfo: CountryInfo) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentHeight(align = Alignment.Top)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.outline),
        shadowElevation = 2.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .weight(0.2f)
            ) {
                Image(
                    painter = painterResource(id = countryInfo.flag),
                    contentDescription = "Country flag image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(2.dp)
                )
                Text(
                    text = countryInfo.commonName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 19.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.nationalCapital,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .weight(0.8f)
            ) {
                Text(
                    text = countryInfo.officialName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.region,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = countryInfo.subRegion,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    fontSize = 11.sp,
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = countryInfo.currencySymbol,
                        modifier = Modifier
                            .fillMaxWidth(0.1f)
                            .wrapContentHeight()
                            .padding(2.dp)
                            .drawBehind {
                                drawCircle(
                                    color = Color.LightGray, radius = this.size.maxDimension
                                )
                            },
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = countryInfo.currency,
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .wrapContentHeight()
                            .padding(2.dp),
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(0.3f)
                            .padding(2.dp), horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = countryInfo.mobileCode,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = countryInfo.tld,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 11.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}