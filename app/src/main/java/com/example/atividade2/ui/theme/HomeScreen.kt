// package com.example.atividade2.screens // Uncomment this in your project
package com.example.atividade2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Composable que representa a tela inicial da aplicação.
 * É uma tela de boas-vindas simples com algumas informações sobre o app.
 */
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Adiciona um padding geral à coluna
        verticalArrangement = Arrangement.Center, // Centraliza os itens verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centraliza os itens horizontalmente
    ) {
        // Texto de boas-vindas com um estilo de título grande do tema.
        Text(
            text = "Bem-vindo ao seu App de Músicas!",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold, // Deixa o texto em negrito
            color = MaterialTheme.colorScheme.primary, // Usa a cor primária do tema
            modifier = Modifier.padding(bottom = 16.dp) // Adiciona um padding inferior
        )
        // Texto descritivo sobre a funcionalidade do app.
        Text(
            text = "Explore diferentes categorias de música para cada momento do seu dia.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant, // Usa uma cor secundária para o texto
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Use a barra de navegação inferior para navegar entre as categorias.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        // Você pode adicionar mais elementos UI aqui, como botões ou imagens.
    }
}
