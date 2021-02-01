package cs.med.mtz.moises.lyrics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cs.med.mtz.moises.lyrics.api.ApiService
import cs.med.mtz.moises.lyrics.api.Song
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
    private val service: ApiService = retrofit.create(ApiService::class.java)

    /* */
    private val nameMutableLiveData: MutableLiveData<String> = MutableLiveData()
    val nameLiveData: LiveData<String> get() = nameMutableLiveData

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
    fun executeLoadSongs() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(2_500)
            val songs: List<Song> = listOf(
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata"),
                Song(1, "Sinmigo"),
                Song(2, "Rata flaca"),
                Song(3, "La suata")
            )
            songsMutableLiveData.postValue(songs)
        }
    }


//    CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val songs = service.getAllPosts("sinmigo")
//            Log.e("MAIN/RES", songs.toString())
//        } catch (exception: Exception) {
//            Log.e("MAIN/ERR", exception.message.toString())
//        }
//    }


}