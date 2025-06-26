// package com.example.atividade2.ui.theme // Uncomment this in your project
package com.example.atividade2.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Esquema de cores claro para o tema.
// Define as cores primárias, secundárias, de fundo, etc., para o modo claro.
private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    onPrimary = OnPrimaryLight,
    primaryContainer = PrimaryContainerLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    secondary = SecondaryLight,
    onSecondary = OnSecondaryLight,
    secondaryContainer = SecondaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    tertiary = TertiaryLight,
    onTertiary = OnTertiaryLight,
    tertiaryContainer = TertiaryContainerLight,
    onTertiaryContainer = OnTertiaryContainerLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    surfaceVariant = SurfaceVariantLight,
    onSurfaceVariant = OnSurfaceVariantLight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    scrim = ScrimLight,
    inverseSurface = InverseSurfaceLight,
    inverseOnSurface = InverseOnSurfaceLight,
    inversePrimary = InversePrimaryLight,
    surfaceDim = SurfaceDimLight,
    surfaceBright = SurfaceBrightLight,
    surfaceContainerLowest = SurfaceContainerLowestLight, // Corrigido: sem 'Light' no nome do parâmetro
    surfaceContainerLow = SurfaceContainerLowLight,       // Corrigido
    surfaceContainer = SurfaceContainerLight,             // Corrigido
    surfaceContainerHigh = SurfaceContainerHighLight,     // Corrigido
    surfaceContainerHighest = SurfaceContainerHighestLight, // Corrigido
)

// Esquema de cores escuro para o tema.
// Define as cores primárias, secundárias, de fundo, etc., para o modo escuro.
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    onPrimary = OnPrimaryDark,
    primaryContainer = PrimaryContainerDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    secondary = SecondaryDark,
    onSecondary = OnSecondaryDark,
    secondaryContainer = SecondaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    tertiary = TertiaryDark,
    onTertiary = OnTertiaryDark,
    tertiaryContainer = TertiaryContainerDark,
    onTertiaryContainer = OnTertiaryContainerDark,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    surfaceVariant = SurfaceVariantDark,
    onSurfaceVariant = OnSurfaceVariantDark,
    outline = OutlineDark,
    outlineVariant = OutlineVariantDark,
    scrim = ScrimDark,
    inverseSurface = InverseSurfaceDark,
    inverseOnSurface = InverseOnSurfaceDark,
    inversePrimary = InversePrimaryDark,
    surfaceDim = SurfaceDimDark,
    surfaceBright = SurfaceBrightDark,
    surfaceContainerLowest = SurfaceContainerLowestDark, // Corrigido: sem 'Dark' no nome do parâmetro
    surfaceContainerLow = SurfaceContainerLowDark,       // Corrigido
    surfaceContainer = SurfaceContainerDark,             // Corrigido (removida a duplicação anterior)
    surfaceContainerHigh = SurfaceContainerHighDark,     // Corrigido
    surfaceContainerHighest = SurfaceContainerHighestDark, // Corrigido
)

/**
 * Composable que aplica o tema Material Design 3 à sua aplicação.
 * Ele escolhe o esquema de cores apropriado (claro/escuro) com base nas configurações do sistema
 * ou na capacidade de cores dinâmicas (Android 12+).
 */
@Composable
fun Atividade2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Detecta se o sistema está no modo escuro
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, // Habilita cores dinâmicas para Android 12+
    content: @Composable () -> Unit // O conteúdo da UI a ser aplicado ao tema
) {
    // Escolhe o esquema de cores a ser usado.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // Se as cores dinâmicas estão ativadas e a versão do Android é 12 (S) ou superior,
            // usa cores dinâmicas do papel de parede do usuário.
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme // Se não há cores dinâmicas e o tema é escuro, usa o DarkColorScheme.
        else -> LightColorScheme // Caso contrário, usa o LightColorScheme.
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        // SideEffect é usado para executar efeitos colaterais que não são parte da composição,
        // como a configuração da barra de status da janela.
        SideEffect {
            val window = (view.context as Activity).window
            // Define a cor da barra de status.
            window.statusBarColor = colorScheme.primary.toArgb()
            // Controla a aparência dos ícones da barra de status (claro/escuro) para melhor contraste.
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    // Aplica o MaterialTheme com o esquema de cores e tipografia definidos.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Define a tipografia da aplicação (ver Type.kt)
        content = content // O conteúdo da UI que será tematizado
    )
}
