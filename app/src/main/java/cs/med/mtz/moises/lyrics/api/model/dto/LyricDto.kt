package cs.med.mtz.moises.lyrics.api.model.dto

import cs.med.mtz.moises.lyrics.domain.entity.Lyric

data class LyricDto(
    val lyrics: String
) {

    /**
     *
     */
    fun toLyric(): Lyric =
        Lyric(
            lyrics = lyrics
        )

}