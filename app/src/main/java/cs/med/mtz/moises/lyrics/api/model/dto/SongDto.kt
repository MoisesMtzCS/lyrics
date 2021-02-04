package cs.med.mtz.moises.lyrics.api.model.dto

import cs.med.mtz.moises.lyrics.domain.entity.Song

data class SongDto(
    val id: Long,
    val title: String,
    val title_short: String,
    val album: AlbumDto
) {

    /**
     *
     */
    fun toSong(): Song =
        Song(
            id = id,
            title = "$title - $title_short",
            imageUrl = album.cover_medium
        )

}
