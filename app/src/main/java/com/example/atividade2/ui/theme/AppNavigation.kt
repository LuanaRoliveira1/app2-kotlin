// package com.example.atividade2.navigation // Uncomment this in your project
package com.example.atividade2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.atividade2.ui.theme.MusicDataSource
import com.example.atividade2.screens.HomeScreen
import com.example.atividade2.screens.MusicCategoryScreen

/**
 * Define as rotas (telas) da aplicação.
 * Cada objeto representa uma tela com seu caminho de rota e um ícone opcional para a navegação.
 */
sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Home : Screen("home", "Início", Icons.Default.Home)
    object SadMusic : Screen("sad_music", "Músicas Tristes", Icons.Default.Favorite)
    object PartyMusic : Screen("party_music", "Músicas para Festa", Icons.Default.Headphones)
    object ShowerMusic : Screen("shower_music", "Músicas para Banho", Icons.Default.Spa)
    object TravelMusic : Screen("travel_music", "Músicas para Viagem", Icons.Default.TravelExplore)
}

/**
 * Composable principal que gerencia a navegação da aplicação.
 * Ele configura o NavHost e a barra de navegação inferior (BottomNavigation).
 */
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Lista de itens de navegação que aparecerão na BottomNavigation.
    // Inclui as categorias de música para fácil acesso.
    val bottomNavigationItems = remember {
        listOf(
            Screen.SadMusic,
            Screen.PartyMusic,
            Screen.ShowerMusic,
            Screen.TravelMusic
        )
    }

    // Scaffold fornece a estrutura básica de layout para a tela,
    // permitindo a fácil inclusão de TopAppBar, BottomAppBar, FloatingActionButton, etc.
    Scaffold(
        bottomBar = {
            // NavigationBar é o componente do Material Design para navegação inferior.
            NavigationBar {
                // Obtém o estado atual da pilha de navegação para determinar qual item está selecionado.
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                // Itera sobre os itens de navegação definidos.
                bottomNavigationItems.forEach { screen ->
                    // NavigationBarItem é um item individual na barra de navegação inferior.
                    NavigationBarItem(
                        icon = {
                            screen.icon?.let {
                                // CORREÇÃO: Acessando 'title' corretamente como 'screen.title'
                                Icon(it, contentDescription = screen.title)
                            }
                        },
                        // CORREÇÃO: Acessando 'title' corretamente como 'screen.title'
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            // Navega para a rota do item clicado.
                            // popUpTo e restoreSaveState garantem que a navegação se comporta
                            // de forma consistente, evitando múltiplas instâncias da mesma tela.
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Evita que múltiplas cópias da mesma rota sejam lançadas
                                launchSingleTop = true
                                // Restaura o estado salvo ao re-selecionar o mesmo item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        // NavHost é o contêiner para as diferentes telas da aplicação,
        // gerenciando a transição entre elas.
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route, // Define a tela inicial como "home"
            // CORREÇÃO: Usando 'Modifier.padding' diretamente
            modifier = Modifier.padding(innerPadding) // Aplica o padding do Scaffold
        ) {
            // Define o composable para a tela inicial.
            composable(Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            // Define o composable para a tela de Músicas Tristes.
            // Ele passa a lista de músicas tristes da MusicDataSource.
            composable(Screen.SadMusic.route) {
                MusicCategoryScreen(
                    // CORREÇÃO: Acessando 'title' corretamente como 'Screen.SadMusic.title'
                    categoryTitle = Screen.SadMusic.title,
                    songs = MusicDataSource.sadSongs
                )
            }
            // Define o composable para a tela de Músicas para Festa.
            composable(Screen.PartyMusic.route) {
                MusicCategoryScreen(
                    // CORREÇÃO: Acessando 'title' corretamente como 'Screen.PartyMusic.title'
                    categoryTitle = Screen.PartyMusic.title,
                    songs = MusicDataSource.partySongs
                )
            }
            // Define o composable para a tela de Músicas para Banho.
            composable(Screen.ShowerMusic.route) {
                MusicCategoryScreen(
                    // CORREÇÃO: Acessando 'title' corretamente como 'Screen.ShowerMusic.title'
                    categoryTitle = Screen.ShowerMusic.title,
                    songs = MusicDataSource.showerSongs
                )
            }
            // Define o composable para a tela de Músicas para Viagem.
            composable(Screen.TravelMusic.route) {
                MusicCategoryScreen(
                    // CORREÇÃO: Acessando 'title' corretamente como 'Screen.TravelMusic.title'
                    categoryTitle = Screen.TravelMusic.title,
                    songs = MusicDataSource.travelSongs
                )
            }
        }
    }
}
