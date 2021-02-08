package cs.med.mtz.moises.lyrics.api.model

import cs.med.mtz.moises.lyrics.api.model.dto.SongDto

data class GetSuggestedSongs(
    val data:List <SongDto>,
    val total: Int
)