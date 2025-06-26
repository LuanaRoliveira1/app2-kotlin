

// package com.example.atividade2.screens // Uncomment this in your project
package com.example.atividade2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import com.example.atividade2.data.Music // Importa o modelo de dados Music

/**
 * Composable genérico para exibir uma lista de músicas em uma categoria específica.
 * Permite reproduzir músicas usando ExoPlayer e gerencia o estado de reprodução.
 *
 * @param categoryTitle O título da categoria de música (ex: "Músicas Tristes").
 * @param songs A lista de objetos Music a serem exibidos nesta categoria.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicCategoryScreen(categoryTitle: String, songs: List<Music>) {
    val context = LocalContext.current

    // Estado para o ExoPlayer. 'remember' o mantém vivo durante recomposições.
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
    }

    // Estado para a música atualmente selecionada para reprodução.
    var currentPlayingMusic by remember { mutableStateOf<Music?>(null) }
    // Estado para controlar se o player está reproduzindo.
    var isPlaying by remember { mutableStateOf(false) }

    // Gerencia o ciclo de vida do ExoPlayer.
    // 'DisposableEffect' é usado para configurar e limpar efeitos colaterais.
    DisposableEffect(Unit) {
        // Quando o composable é adicionado à composição:
        // Configura um listener para atualizar 'isPlaying' quando o estado do player muda.
        val listener = object : Player.Listener {
            override fun onIsPlayingChanged(currentIsPlaying: Boolean) {
                isPlaying = currentIsPlaying
            }

            @androidx.annotation.OptIn(UnstableApi::class)
            override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                // Se o item de mídia mudar (ex: próxima música na playlist),
                // tenta encontrar a música correspondente na lista e atualiza o estado.
                currentPlayingMusic = songs.find { it.audioUrl == mediaItem?.playbackProperties?.uri.toString() }
            }
        }
        exoPlayer.addListener(listener)

        // Bloco 'onDispose' é chamado quando o composable é removido da composição.
        // Libera os recursos do ExoPlayer para evitar vazamentos de memória.
        onDispose {
            exoPlayer.removeListener(listener)
            exoPlayer.release()
        }
    }

    // Observa mudanças em 'currentPlayingMusic' e 'isPlaying'.
    // Quando 'currentPlayingMusic' muda, o player é preparado com a nova música.
    // Quando 'isPlaying' muda, o player inicia ou pausa a reprodução.
    LaunchedEffect(currentPlayingMusic) {
        currentPlayingMusic?.let { music ->
            val mediaItem = MediaItem.fromUri(music.audioUrl)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
            exoPlayer.play() // Inicia a reprodução automaticamente ao selecionar uma nova música
            isPlaying = true
        }
    }

    // Efeito para controlar play/pause baseado no estado isPlaying
    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            exoPlayer.play()
        } else {
            exoPlayer.pause()
        }
    }


    Scaffold(
        // TopAppBar para exibir o título da categoria.
        topBar = {
            TopAppBar(
                title = { Text(text = categoryTitle) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Aplica o padding do Scaffold
                .background(MaterialTheme.colorScheme.surfaceVariant), // Cor de fundo da tela
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // LazyColumn para exibir a lista de músicas de forma eficiente.
            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(songs) { music ->
                    // Item individual da lista de músicas.
                    MusicItem(
                        music = music,
                        isPlaying = currentPlayingMusic?.id == music.id && isPlaying, // Verifica se esta música está tocando e se o player está ativo
                        onPlayPauseClick = {
                            if (currentPlayingMusic?.id == music.id) {
                                // Se a música clicada já é a atual, apenas alterna play/pause
                                isPlaying = !isPlaying
                            } else {
                                // Se é uma nova música, define como a atual e começa a tocar
                                currentPlayingMusic = music
                                isPlaying = true // Garante que começa a tocar
                            }
                        }
                    )
                }
            }
            // Exibe informações da música atualmente tocando na parte inferior da tela.
            currentPlayingMusic?.let { music ->
                MiniPlayer(
                    music = music,
                    isPlaying = isPlaying,
                    onPlayPauseClick = { isPlaying = !isPlaying }
                )
            }
        }
    }
}

/**
 * Composable para exibir um item individual na lista de músicas.
 * Inclui o título da música, artista e um botão de play/pause.
 */
@Composable
fun MusicItem(
    music: Music,
    isPlaying: Boolean,
    onPlayPauseClick: (Music) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp) // Padding ao redor do card
            .clickable { onPlayPauseClick(music) }, // Torna o card clicável para play/pause
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp), // Sombra para o card
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface) // Cor de fundo do card
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), // Padding interno do card
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Espaço entre o texto e o botão
        ) {
            Column(modifier = Modifier.weight(1f)) { // Coluna para título e artista, ocupando o espaço restante
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = music.artist,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            IconButton(
                onClick = { onPlayPauseClick(music) } // Botão de play/pause
            ) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pausar" else "Reproduzir",
                    tint = MaterialTheme.colorScheme.primary // Cor do ícone
                )
            }
        }
    }
}

/**
 * Composable para exibir um mini-player na parte inferior da tela quando uma música está tocando.
 */
@Composable
fun MiniPlayer(music: Music, isPlaying: Boolean, onPlayPauseClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.primary), // Cor de fundo do mini-player
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Tocando Agora:",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = music.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = music.artist,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }
            IconButton(onClick = onPlayPauseClick) {
                Icon(
                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                    contentDescription = if (isPlaying) "Pausar" else "Reproduzir",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}
