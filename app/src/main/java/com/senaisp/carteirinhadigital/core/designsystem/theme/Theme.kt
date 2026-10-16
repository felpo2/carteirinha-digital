package com.senaisp.carteirinhadigital.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,

    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,

    secondary = secondaryDark,
    onSecondary = onSecondaryDark,

    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,

    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,

    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,

    background = backgroundDark,
    onBackground = onBackgroundDark,

    surface = surfaceDark,
    onSurface = onSurfaceDark,

    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,

    outline = outlineDark,
    outlineVariant = outlineVariantDark,

    error = errorDark,
    onError = onErrorDark,

    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,

    scrim = scrimDark,

    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,

    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,

    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark
)

private val lightScheme = darkScheme

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun CarteirinhaDigital(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colorScheme = when {

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}