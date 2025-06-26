// Certifique-se de que este arquivo está em app/src/main/java/com/example/atividade2/ui/theme/MusicDataSource.kt
package com.example.atividade2.ui.theme // MANTENDO A ORGANIZAÇÃO SOLICITADA

import com.example.atividade2.data.Music // Certifique-se de que a classe Music esteja no pacote 'data'

/**
 * Objeto singleton que fornece dados de exemplo para as categorias de música.
 * As URLs são de músicas royalty-free do SoundHelix.com, ideais para teste e desenvolvimento.
 */
object MusicDataSource {

    // URLs de músicas de exemplo do SoundHelix.com (royalty-free e acessíveis)
    private const val SOUNDHELIX_SONG_1 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
    private const val SOUNDHELIX_SONG_2 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3"
    private const val SOUNDHELIX_SONG_3 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-3.mp3"
    private const val SOUNDHELIX_SONG_4 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-4.mp3"
    private const val SOUNDHELIX_SONG_5 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-5.mp3"
    private const val SOUNDHELIX_SONG_6 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-6.mp3"
    private const val SOUNDHELIX_SONG_7 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-7.mp3"
    private const val SOUNDHELIX_SONG_8 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-8.mp3"
    private const val SOUNDHELIX_SONG_9 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-9.mp3"
    private const val SOUNDHELIX_SONG_10 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-10.mp3"
    private const val SOUNDHELIX_SONG_11 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-11.mp3"
    private const val SOUNDHELIX_SONG_12 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-12.mp3"
    private const val SOUNDHELIX_SONG_13 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-13.mp3"
    private const val SOUNDHELIX_SONG_14 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-14.mp3"
    private const val SOUNDHELIX_SONG_15 = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-15.mp3"

    val sadSongs = listOf(
        Music("s1", "Melancolia Profunda", "SoundHelix", SOUNDHELIX_SONG_1),
        Music("s2", "Ecos da Saudade", "SoundHelix", SOUNDHELIX_SONG_2),
        Music("s3", "Lágrimas Silenciosas", "SoundHelix", SOUNDHELIX_SONG_3),
        Music("s4", "Caminho da Reflexão", "SoundHelix", SOUNDHELIX_SONG_4),
        Music("s5", "Solidão do Coração", "SoundHelix", SOUNDHELIX_SONG_5)
    )

    val partySongs = listOf(
        Music("p1", "Batida Contagiante", "SoundHelix", SOUNDHELIX_SONG_6),
        Music("p2", "Ritmo de Balada", "SoundHelix", SOUNDHELIX_SONG_7),
        Music("p3", "Energia Máxima", "SoundHelix", SOUNDHELIX_SONG_8),
        Music("p4", "Pista Fervendo", "SoundHelix", SOUNDHELIX_SONG_9),
        Music("p5", "Noite Sem Fim", "SoundHelix", SOUNDHELIX_SONG_10)
    )

    val showerSongs = listOf(
        Music("sh1", "Manhã Refrescante", "SoundHelix", SOUNDHELIX_SONG_11),
        Music("sh2", "Canto no Banho", "SoundHelix", SOUNDHELIX_SONG_12),
        Music("sh3", "Água Quente e Música", "SoundHelix", SOUNDHELIX_SONG_13),
        Music("sh4", "Momento Relax", "SoundHelix", SOUNDHELIX_SONG_14),
        Music("sh5", "Harmonia no Chuveiro", "SoundHelix", SOUNDHELIX_SONG_15)
    )

    val travelSongs = listOf(
        Music("t1", "Estrada Aberta", "SoundHelix", SOUNDHELIX_SONG_1), // Reutilizando para exemplo
        Music("t2", "Aventura em Paisagens", "SoundHelix", SOUNDHELIX_SONG_2), // Reutilizando para exemplo
        Music("t3", "Desbravando Horizontes", "SoundHelix", SOUNDHELIX_SONG_3), // Reutilizando para exemplo
        Music("t4", "Viajando Pelo Som", "SoundHelix", SOUNDHELIX_SONG_4), // Reutilizando para exemplo
        Music("t5", "Destino Desconhecido", "SoundHelix", SOUNDHELIX_SONG_5)  // Reutilizando para exemplo
    )
}