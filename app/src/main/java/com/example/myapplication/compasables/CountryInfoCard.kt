package com.example.countryinfoapp.compasables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.countryinfoapp.data.CountryInfo

@Composable
fun CountryInfoCard(countryInfo: CountryInfo) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(2.dp)
    ) {
        val (flag, commonName, nationalCapital, officialName, region, subRegion, currencySymbol, tld, mobileCode, currency) = createRefs()

        val topGuideLine = createGuidelineFromTop(2.dp)
        val startGuideLine = createGuidelineFromStart(2.dp)
        val endGuideLine = createGuidelineFromEnd(2.dp)
        val bottomGuideLine = createGuidelineFromBottom(2.dp)

//        Image(
//            painter = painterResource(countryInfo.flag),
//            contentDescription = "",
//            contentScale = ContentScale.Fit,
//            modifier = Modifier
//                .fillMaxWidth(0.3f)
//                .height(80.dp)
//                .padding(2.dp)
//                .constrainAs(flag) {
//                    top.linkTo(topGuideLine)
//                    start.linkTo(startGuideLine)
//                }
//
//        )

        AsyncImage(
            model = countryInfo.flag,
            contentDescription = countryInfo.commonName,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(80.dp)
                .padding(2.dp)
                .constrainAs(flag) {
                    top.linkTo(topGuideLine)
                    start.linkTo(startGuideLine)
                }
        )

        Text(
            text = countryInfo.commonName,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(2.dp)
                .constrainAs(commonName) {
                    top.linkTo(flag.bottom)
                    start.linkTo(startGuideLine)
                    end.linkTo(flag.end)
                },
            fontSize = 19.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.nationalCapital,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(nationalCapital) {
                    top.linkTo(commonName.bottom)
                    start.linkTo(startGuideLine)
                    end.linkTo(flag.end)
                },
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.officialName,
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .wrapContentHeight()
                .constrainAs(officialName) {
                    top.linkTo(topGuideLine)
                    start.linkTo(flag.end)
                },
            fontSize = 17.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.region,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(region) {
                    top.linkTo(officialName.bottom)
                    start.linkTo(flag.end)
                    end.linkTo(endGuideLine)
                },
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.subRegion,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .constrainAs(subRegion) {
                    top.linkTo(region.bottom)
                    start.linkTo(flag.end)
                    end.linkTo(endGuideLine)
                },
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.currency,
            modifier = Modifier
                .fillMaxWidth(0.1f)
                .wrapContentHeight()
                .padding(2.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.LightGray, radius = this.size.minDimension
                    )
                }
                .constrainAs(currencySymbol) {
                    top.linkTo(flag.bottom)
                    start.linkTo(flag.end)
                    bottom.linkTo(bottomGuideLine)
                },
            fontSize = 13.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = countryInfo.tld,
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(tld) {
                    bottom.linkTo(bottomGuideLine)
                    end.linkTo(endGuideLine)
                },
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )

        Text(
            text = countryInfo.mobileCode,
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(mobileCode) {
                    top.linkTo(currencySymbol.top)
                    bottom.linkTo(tld.top)
                    end.linkTo(endGuideLine)
                },
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = countryInfo.currencySymbol,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .wrapContentHeight()
                .padding(2.dp)
                .constrainAs(currency) {
                    start.linkTo(currencySymbol.end)
                    end.linkTo(mobileCode.start)
                    bottom.linkTo(bottomGuideLine)
                    top.linkTo(currencySymbol.top)
                },
            fontSize = 11.sp,
            textAlign = TextAlign.Center
        )
    }
}