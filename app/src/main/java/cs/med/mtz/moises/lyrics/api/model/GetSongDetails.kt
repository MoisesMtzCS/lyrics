package cs.med.mtz.moises.lyrics.api.model

/* */
data class GetSongDetails(
    val id: Int,
    val title: String,
    val cover: String,
    val lyrics: String
)