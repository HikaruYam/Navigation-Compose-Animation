package com.example.navigationcomposeanimation

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationcomposeanimation.ui.screen.ExpandHorizonScreen
import com.example.navigationcomposeanimation.ui.screen.ExpandScreen
import com.example.navigationcomposeanimation.ui.screen.ExpandVerticalScreen
import com.example.navigationcomposeanimation.ui.screen.FadeScreen
import com.example.navigationcomposeanimation.ui.screen.HomeScreen
import com.example.navigationcomposeanimation.ui.screen.SlideHorizonScreen
import com.example.navigationcomposeanimation.ui.screen.SlideScreen
import com.example.navigationcomposeanimation.ui.screen.SlideVerticalScreen

@Composable
fun AppNavigation(
    modifier: Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.HOME.name,
        modifier = modifier
    ) {
        composable(route = Route.HOME.name) {
            HomeScreen(
                fadeNav = { navController.navigate(Route.FADE.name) },
                scaleNav = { navController.navigate(Route.SCALE.name) },
                slideNav = { navController.navigate(Route.SLIDE.name) },
                slideHorizonNav = { navController.navigate(Route.SLIDE_HORIZON.name) },
                slideVerticalNav = { navController.navigate(Route.SLIDE_VERTICAL.name) },
                expandNav = { navController.navigate(Route.EXPAND.name) },
                expandHorizonNav = { navController.navigate(Route.EXPAND_HORIZON.name) },
                expandVerticalNav = { navController.navigate(Route.EXPAND_VERTICAL.name) },
            )
        }

        composable(
            route = Route.FADE.name,
            enterTransition = {
                fadeIn(animationSpec = tween(durationMillis = 500), initialAlpha = 0f)
            },
            exitTransition = {
                fadeOut(animationSpec = tween(durationMillis = 500), targetAlpha = 0f)
            },
        ) {
            FadeScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.SCALE.name,
            enterTransition = {
                scaleIn(animationSpec = tween(durationMillis = 500), initialScale= 0f, transformOrigin = TransformOrigin.Center)
            },
            exitTransition = {
                scaleOut(animationSpec = tween(durationMillis = 500), targetScale = 0F, transformOrigin = TransformOrigin.Center)
            },
        ) {
            FadeScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.SLIDE.name,
            enterTransition = {
                slideIn(animationSpec = tween(durationMillis = 500)) { fullSize ->
                    IntOffset(fullSize.width / 2, fullSize.height / 2)
                }
            },
            exitTransition = {
                slideOut(animationSpec = tween(durationMillis = 500)){ fullSize ->
                    IntOffset(fullSize.width / 2, fullSize.height / 2)
                }
            },
        ) {
            SlideScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.SLIDE_HORIZON.name,
            enterTransition = {
                slideInHorizontally(animationSpec = tween(500)) { fullWidth -> fullWidth / 2 }
            },
            exitTransition = {
                slideOutHorizontally(animationSpec = tween(500)) { fullWidth -> -fullWidth  / 2}
            }
        ) {
            SlideHorizonScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.SLIDE_VERTICAL.name,
            enterTransition = {
                slideInVertically(animationSpec = tween(500)) { fullHeight -> fullHeight / 2 }
            },
            exitTransition = {
                slideOutVertically(animationSpec = tween(500)) { fullHeight -> -fullHeight / 2 }
            }
        ) {
            SlideVerticalScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.EXPAND.name,
            enterTransition = {
                expandIn(
                    animationSpec = tween(500),
                    expandFrom = Alignment.BottomEnd,
                    clip = true,
                ) { fullSize ->
                    IntSize(0, 0)
                }
            },
            exitTransition = {
                shrinkOut(
                    animationSpec = tween(500),
                    shrinkTowards = Alignment.BottomEnd,
                    clip = true,
                ) { fullSize ->
                    IntSize(0, 0)
                }
            }
        ) {
            ExpandScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.EXPAND_HORIZON.name,
            enterTransition = {
                expandHorizontally(
                    animationSpec = tween(500),
                    expandFrom = Alignment.End,
                    clip = true,
                ) { fullWidth ->
                    0
                }
            },
            exitTransition = {
                shrinkHorizontally(
                    animationSpec = tween(500),
                    shrinkTowards = Alignment.End,
                    clip = true,
                ) { fullWidth ->
                    0
                }
            }
        ) {
            ExpandHorizonScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }

        composable(
            route = Route.EXPAND_VERTICAL.name,
            enterTransition = {
                expandVertically(
                    animationSpec = tween(500),
                    expandFrom = Alignment.Bottom,
                    clip = true,
                ) { fullHeight ->
                    0
                }
            },
            exitTransition = {
                shrinkVertically(
                    animationSpec = tween(500),
                    shrinkTowards = Alignment.Bottom,
                    clip = true,
                ) { fullHeight ->
                    0
                }
            }
        ) {
            ExpandVerticalScreen(homeNav = { navController.navigate(Route.HOME.name) })
        }
    }
}

private enum class Route {
    HOME,
    FADE,
    SCALE,
    SLIDE,
    SLIDE_HORIZON,
    SLIDE_VERTICAL,
    EXPAND,
    EXPAND_HORIZON,
    EXPAND_VERTICAL,
}
