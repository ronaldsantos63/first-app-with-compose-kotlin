package com.ronaldsantos.composemvvm

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    val image = painterResource(id = R.drawable.header)
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val imageModifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                painter = image,
                contentDescription = "Header",
                contentScale = ContentScale.Crop,
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "A day wandering through the sandhills in Shark Fin Cove, and a few of the sights I saw",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = typography.h6
            )
            Text(
                text = "Davenport, California",
                style = typography.body2
            )
            Text(
                text = "December 2018",
                style = typography.body2
            )
        }
    }
}

@Preview(device = Devices.PIXEL_2, showSystemUi = true, showBackground = false)
@Composable
fun PreviewNewsStory(){
    NewsStory()
}