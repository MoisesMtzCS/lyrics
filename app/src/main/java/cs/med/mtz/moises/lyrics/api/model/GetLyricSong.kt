package cs.med.mtz.moises.lyrics.api.model

import cs.med.mtz.moises.lyrics.api.model.dto.LyricDto
import cs.med.mtz.moises.lyrics.domain.entity.Lyric

data class GetLyricSong(
    val lyrics: String
)