package cs.med.mtz.moises.lyrics

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cs.med.mtz.moises.lyrics.domain.entity.Song
import kotlinx.android.synthetic.main.activity_lyrics_song.*
import kotlinx.android.synthetic.main.activity_main.*

/* */
class MainActivity : AppCompatActivity() {

    /* */
    private val value: String
        get() = valueText.text.toString()

    /* */
    private lateinit var mainViewModel: MainViewModel

    /* */
    private val songs: ArrayList<Song> = ArrayList()

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = MainViewModel()
        setupViews()
        observeViewModel()
        //execute()
        searchOnClick()
    }

    /**
     *
     */
    private fun setupViews() {
        setupClickListeners()
        setupSongsRecyclerView()
    }

    /**
     *
     */
    private fun setupClickListeners() {
        searchButton.setOnClickListener(this::onActionButtonClickLister)
    }

    /**
     *
     */
    private fun setupSongsRecyclerView() {
        val songAdapter = SongAdapter(songs)
        rvSongs.adapter = songAdapter
        rvSongs.layoutManager = LinearLayoutManager(this)
    }

    /**
     *
     */

    private fun observeViewModel() {
//        mainViewModel.nameLiveData.observe(this, Observer<String> {
//            tvName.text = it
//        })

        mainViewModel.songsLiveData.observe(this, Observer<List<Song>> {
            songs.clear()
            songs.addAll(it)
            rvSongs.adapter?.notifyDataSetChanged()
        })
    }

    /**
     *
     */
    private fun execute() {
        // mainViewModel.executeLyricsSongs()
        // mainViewModel.executeNameLoad()


    }

    /**
     *
     */
    private fun onActionButtonClickLister(v: View) {
    }

    /**
     *
     */

    private fun searchOnClick() {
        searchButton.setOnClickListener {
            if (value.isNotBlank()) {
                mainViewModel.executeLoadSongs(value)

            }
        }
    }
}