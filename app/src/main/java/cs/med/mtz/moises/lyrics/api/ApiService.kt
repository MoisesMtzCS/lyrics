package cs.med.mtz.moises.lyrics.api

import cs.med.mtz.moises.lyrics.Post
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    /**
     *
     */
    @GET("suggest/{value}")
    suspend fun getSuggestSongs(
        @Path("value") value: String
    ): GetAllPosts

    /**
     *
     */
    @GET("TODO")
    suspend fun getSongDetails(
        @Path("name") name: String
    ): GetSongDetails

    /**
     *
     */
    @GET("suggest/{artist}/{song}")
    suspend fun getAllPostsDummy(
        @Path("artist") artist: String,
        @Path("song") song: String
    ): GetAllPosts

    @GET("suggest/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

    @POST("suggest/{id}")
    fun editPostById(@Path("id") id: Int, @Body post: Post?): Call<Post>

}