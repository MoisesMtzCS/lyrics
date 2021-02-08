package cs.med.mtz.moises.lyrics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import cs.med.mtz.moises.lyrics.api.ApiService
import cs.med.mtz.moises.lyrics.api.model.dto.LyricDto
import cs.med.mtz.moises.lyrics.domain.entity.Lyric
import kotlinx.android.synthetic.main.activity_lyrics_song.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LyricsSongActivity : AppCompatActivity() {
    /* */
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lyrics_song)
        mainViewModel = MainViewModel()
        observeViewModel()
        execute()

        // val songTitle = intent.extras?.getString("SONG_TITLE")
        val songName = intent.extras?.getString("SONG_NAME")


        val artist = intent.extras?.getString("ARTIST")
        titleTextView.text = artist


    }

    private fun observeViewModel() {
        mainViewModel.nameLiveData.observe(this, Observer<String> {
            lyricTextView.text = it
        })
    }

    private fun execute() {
        val artist = intent.extras?.getString("ARTIST")
        val songName = intent.extras?.getString("SONG_NAME")
        mainViewModel.executeLyricsSongs(artist!!, songName!!)

    }
}


