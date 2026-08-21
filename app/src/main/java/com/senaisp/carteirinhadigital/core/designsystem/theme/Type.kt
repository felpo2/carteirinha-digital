package com.senaisp.carteirinhadigital.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

import com.senaisp.carteirinhadigital.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val appFontFamily = FontFamily(
    Font(
        googleFont = GoogleFont("Poppins"),
        fontProvider = provider,
    )
)
val baseline = Typography()

val AppTypography = Typography(
    displayLarge = baseline.displayLarge.copy(
        fontFamily = appFontFamily
    ),
    displayMedium = baseline.displayMedium.copy(
        fontFamily = appFontFamily
    ),
    displaySmall = baseline.displaySmall.copy(
        fontFamily = appFontFamily
    ),

    headlineLarge = baseline.headlineLarge.copy(
        fontFamily = appFontFamily
    ),
    headlineMedium = baseline.headlineMedium.copy(
        fontFamily = appFontFamily
    ),
    headlineSmall = baseline.headlineSmall.copy(
        fontFamily = appFontFamily
    ),

    titleLarge = baseline.titleLarge.copy(
        fontFamily = appFontFamily
    ),
    titleMedium = baseline.titleMedium.copy(
        fontFamily = appFontFamily
    ),
    titleSmall = baseline.titleSmall.copy(
        fontFamily = appFontFamily
    ),

    bodyLarge = baseline.bodyLarge.copy(
        fontFamily = appFontFamily
    ),
    bodyMedium = baseline.bodyMedium.copy(
        fontFamily = appFontFamily
    ),
    bodySmall = baseline.bodySmall.copy(
        fontFamily = appFontFamily
    ),

    labelLarge = baseline.labelLarge.copy(
        fontFamily = appFontFamily
    ),
    labelMedium = baseline.labelMedium.copy(
        fontFamily = appFontFamily
    ),
    labelSmall = baseline.labelSmall.copy(
        fontFamily = appFontFamily
    ),
)