package cs.med.mtz.moises.lyrics.api

import cs.med.mtz.moises.lyrics.api.model.GetLyricSong
import cs.med.mtz.moises.lyrics.api.model.GetSuggestedSongs
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    /**
     *
     */
    @GET("suggest/{value}")
    suspend fun getSuggestSongs(
        @Path("value") value: String
    ): GetSuggestedSongs

    /**
     *
     */
    @GET("v1/{artist}/{song}")
    suspend fun getLyricSong(
        @Path("artist") artist: String,
        @Path("song") song: String
    ): GetLyricSong

}