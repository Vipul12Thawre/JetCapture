package com.vips.jetcapture.uiComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vips.jetcapture.R
import com.vips.jetcapture.ui.theme.Blue
import com.vips.jetcapture.ui.theme.Grey
import com.vips.jetcapture.ui.theme.Grey30
import com.vips.jetcapture.ui.theme.appFontFamily

@Composable
fun ProfileCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(40.dp),
        shape = RoundedCornerShape(22.dp),
        elevation = 4.dp
    ) {
        Column(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(40.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .shadow(
                        elevation = 20.dp,
                        shape = CircleShape,
                        clip = true
                    )
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.my_name), style = TextStyle(
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    lineHeight = 20.sp
                )
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "ANDROID ENGINEER", style = TextStyle(
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 20.sp
                ), color = Grey
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Works in", style = TextStyle(
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    lineHeight = 20.sp
                ), color = if(!isSystemInDarkTheme()) Blue else Grey30
            )

            Text(
                text = "Testbook.com", style = TextStyle(
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    lineHeight = 20.sp,
                    textDecoration = TextDecoration.Underline
                ), color  = if(!isSystemInDarkTheme()) Blue else Grey30
            )

            Spacer(modifier = Modifier.height(30.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {

                Image(
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                )


            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Techie | Fitness freak | UI/UX lover | Blogger", style = TextStyle(
                    fontFamily = appFontFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    lineHeight = 20.sp
                )
            )

        }
    }
}

@Preview
@Composable
fun Preview() {
    ProfileCard()
}


