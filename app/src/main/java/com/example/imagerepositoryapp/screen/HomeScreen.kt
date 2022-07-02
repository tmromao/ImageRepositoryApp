package com.example.imagerepositoryapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.imagerepositoryapp.Image
import com.example.imagerepositoryapp.util.NetworkImage

@Composable
fun HomeScreen(
    image: Image,
    selectImage: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable(onClick = { selectImage(image.id) }),
        color = MaterialTheme.colors.background,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout {
            val (imagePic, title, height) = createRefs()
            NetworkImage(url = image.imageUrl, modifier = Modifier
                .constrainAs(imagePic) {
                    centerHorizontallyTo(parent)
                    top.linkTo(parent.top)
                }
                .aspectRatio(.8f)
            )
            Text(text = image.title,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(imagePic.bottom)
                    }
                    .padding(8.dp))

            Text(text = image.height,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(height) {
                        centerHorizontallyTo(parent)
                        top.linkTo(title.bottom)
                    }
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 12.dp)
            )
        }

    }

}