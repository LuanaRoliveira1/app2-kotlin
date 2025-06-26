// package com.example.atividade2.data // Uncomment this in your project
package com.example.atividade2.data

/**
 * Data class que representa uma única música.
 * @param id Um identificador único para a música.
 * @param title O título da música.
 * @param artist O artista da música.
 * @param audioUrl A URL do arquivo de áudio da música.
 */
data class Music(
    val id: String,
    val title: String,
    val artist: String,
    val audioUrl: String
)
