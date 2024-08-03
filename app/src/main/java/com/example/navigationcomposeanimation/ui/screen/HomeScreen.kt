package com.example.navigationcomposeanimation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationcomposeanimation.ui.theme.NavigationComposeAnimationTheme

@Composable
fun HomeScreen(
    fadeNav: () -> Unit,
    scaleNav: () -> Unit,
    slideNav: () -> Unit,
    slideHorizonNav: () -> Unit,
    slideVerticalNav: () -> Unit,
    expandNav: () -> Unit,
    expandHorizonNav: () -> Unit,
    expandVerticalNav: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val modifier = Modifier.fillMaxWidth(0.4f)
        val navigations = listOf(fadeNav, scaleNav, slideNav, slideHorizonNav, slideVerticalNav, expandNav, expandHorizonNav, expandVerticalNav)
        val titles = listOf("Fade", "Scale", "Slide", "Slide Horizon", "Slide Vertical", "Expand", "Expand Horizon", "Expand Vertical")
        Text("Home Screen")
        LazyColumn(
            verticalArrangement = Arrangement.Center,
        ) {
            itemsIndexed(titles) { index, title ->
                Button(onClick = navigations[index]) {
                    Text(
                        title,
                        modifier = modifier,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    NavigationComposeAnimationTheme {
        HomeScreen(
            fadeNav = { },
            scaleNav = { },
            slideNav = { },
            slideHorizonNav = { },
            slideVerticalNav = { },
            expandNav = { },
            expandHorizonNav = { },
            expandVerticalNav = { },
        )
    }
}
