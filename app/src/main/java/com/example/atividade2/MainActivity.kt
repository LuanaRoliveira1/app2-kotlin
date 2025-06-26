// package com.example.atividade2// ESTE DEVE SER O SEU PAPACAPOTE PRINCIPAL E EXATO - Uncomment this in your project
package com.example.atividade2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
// Importação do seu tema - o nome e caminho exatos que você confirmou em Theme.kt
import com.example.atividade2.ui.theme.Atividade2Theme
import com.example.atividade2.navigation.AppNavigation // Importa a navegação principal

/**
 * MainActivity é o ponto de entrada principal da aplicação Android.
 * Ela configura o tema da aplicação e o sistema de navegação Compose.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplica o seu tema a toda a aplicação Compose.
            // O tema 'Atividade2Theme' define as cores, tipografia e formas para a UI.
            Atividade2Theme {
                // Surface é um container que usa a cor de fundo do tema.
                // O modifier fillMaxSize() garante que ele preenche toda a tela disponível.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // AppNavigation é o composable que contém todo o sistema de navegação
                    // da aplicação, definindo as rotas e as telas.
                    AppNavigation()
                }
            }
        }
    }
}
