package com.example.navigationcomposeanimation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationcomposeanimation.ui.theme.NavigationComposeAnimationTheme

@Composable
fun FadeScreen(
    homeNav: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray.copy(alpha = 0.5f)),
    ) {
        Text("Fade Screen.")
        Button(
            onClick = homeNav,
        ) {
            Text(text = "Home Screen")
        }
    }
}

@Preview
@Composable
fun FadeScreenPreview() {
    NavigationComposeAnimationTheme {
        FadeScreen(
            homeNav = {}
        )
    }
}
