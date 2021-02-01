package cs.med.mtz.moises.lyrics.api

data class GetAllPosts(
    val data: List<Song>,
    val total: Int
)