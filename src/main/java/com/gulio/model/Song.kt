package com.gulio.model

/**
 * Song model
 *
 * @property id Melon Song id
 * @property name Song name
 * @property artist Song artist
 * @property album Song album
 * @property albumArt Song album url image
 * @property likes Song likes
 */
class Song(
        var id: Int,
        var name: String,
        var artist: String,
        var album: String,
        var albumArt: String,
        var likes: Int,
) {
    override fun toString(): String {
        return "Song(id=$id, name='$name', artist='$artist', album='$album', likes=$likes, albumArt='$albumArt')"
    }
}
