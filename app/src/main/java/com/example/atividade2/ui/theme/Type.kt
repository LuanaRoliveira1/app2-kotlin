// package com.example.atividade2.ui.theme // Uncomment this in your project
package com.example.atividade2.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Define a tipografia para o tema Material Design 3.
// Você pode personalizar as famílias de fontes, pesos e tamanhos de texto aqui.
// Atualmente, usa as fontes padrão do sistema.

val Typography = Typography(
    // Estilo para títulos grandes, como os de cabeçalhos de tela.
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    // Estilo para títulos médios, como os de categorias ou seções.
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    // Estilo para o corpo do texto principal, para parágrafos e informações gerais.
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // Estilo para texto de corpo menor, para descrições ou notas.
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    // Estilo para legendas ou texto auxiliar muito pequeno.
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    // Estilo para rótulos de botões ou itens de navegação.
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    /* Outros estilos de tipografia podem ser adicionados aqui:
    displayLarge, displayMedium, displaySmall,
    headlineMedium, headlineSmall,
    titleLarge, titleSmall,
    labelLarge, labelMedium,
    bodySmall,
    */
)
