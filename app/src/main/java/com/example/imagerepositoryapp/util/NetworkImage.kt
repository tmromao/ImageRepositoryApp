package com.example.imagerepositoryapp.util

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.imagerepositoryapp.ui.theme.ShimmerHighlight
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun NetworkImage(
    url: String,
    contentScale: ContentScale = ContentScale.Crop,
    modifier: Modifier = Modifier
) {
    CoilImage(
        imageModel = url,
        shimmerParams = ShimmerParams(
            baseColor = MaterialTheme.colors.background,
            highlightColor = ShimmerHighlight,
            dropOff = .65f
        ),
        modifier = modifier, failure = {
            Text(
                text = "Image request failed",
                style = MaterialTheme.typography.body2
            )
        }
    )
}