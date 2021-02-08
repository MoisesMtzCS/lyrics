package cs.med.mtz.moises.lyrics

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.med.mtz.moises.lyrics.api.ApiService
import cs.med.mtz.moises.lyrics.api.model.dto.LyricDto
import cs.med.mtz.moises.lyrics.api.model.dto.SongDto
import cs.med.mtz.moises.lyrics.domain.entity.Lyric
import cs.med.mtz.moises.lyrics.domain.entity.Song
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* */
class MainViewModel : ViewModel() {


    /* */
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.lyrics.ovh/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    /* */
    private val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)


    /* */
    private val nameMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val nameLiveData: MutableLiveData<String> get() = nameMutableLiveData

    /* */
    private val songsMutableLiveData: MutableLiveData<List<Song>> = MutableLiveData()
    val songsLiveData: LiveData<List<Song>> get() = songsMutableLiveData


    /**
     *
     */
    fun executeNameLoad() {
        viewModelScope.launch {
            delay(1_000)
            nameMutableLiveData.postValue("Roberto")
            delay(1_000)
            nameMutableLiveData.postValue("Roberto Mtz")
            delay(1_000)
            nameMutableLiveData.postValue("Roberto Mtz Med")
        }
    }

    /**
     *
     */
    fun executeLoadSongs(valueSong: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response = service.getSuggestSongs(valueSong)
                val songsDto: List<SongDto> = response.data
                val songs: List<Song> = songsDto.map { it.toSong() }
                Log.e("MAIN/RES", songs.toString())
                songsMutableLiveData.postValue(songs)
            } catch (exception: Exception) {
                Log.e("MAIN/ERR", exception.message.toString())
            }


        }
    }

    fun executeLyricsSongs(artist: String, songName: String) {
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response = service.getLyricSong(artist, songName)
                val lyrics: String = response.lyrics
                nameMutableLiveData.postValue(lyrics)

            } catch (exception: Exception) {
                Log.e("MAIN/ERR", exception.message.toString())
            }
        }


    }


}