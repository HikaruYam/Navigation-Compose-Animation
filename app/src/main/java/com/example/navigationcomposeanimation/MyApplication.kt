package com.example.navigationcomposeanimation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigationcomposeanimation.ui.theme.NavigationComposeAnimationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApplication() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Navigation Animation",
                        textAlign = TextAlign.Center,
                    )
                },
            )
        },
    ) { innerPadding ->
        AppNavigation(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
@Preview
fun MyApplicationPreview() {
    NavigationComposeAnimationTheme {
        MyApplication()
    }
}
