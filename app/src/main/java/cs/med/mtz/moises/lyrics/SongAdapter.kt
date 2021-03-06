package cs.med.mtz.moises.lyrics

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import cs.med.mtz.moises.lyrics.api.ApiService
import cs.med.mtz.moises.lyrics.api.model.dto.LyricDto
import cs.med.mtz.moises.lyrics.domain.entity.Lyric
import cs.med.mtz.moises.lyrics.domain.entity.Song
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/* */
class SongAdapter(
    private val songs: List<Song>
) : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    /* */
    class SongViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        /* */
        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)
        val ivCover: ImageView = itemView.findViewById(R.id.iv_cover)


        // TODO: Implementar la imagen

    }

    /**
     *
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_song, parent, false)
        return SongViewHolder(view)
    }

    /**
     *
     */
    override fun getItemCount(): Int = songs.size


    /**
     *
     */
    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song: Song = songs[position]
        holder.tvTitle.text = song.title
        Glide.with(holder.itemView)
            .load(song.imageUrl)
            .into(holder.ivCover)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, LyricsSongActivity::class.java).apply {
                putExtra("ARTIST", song.artist)
                putExtra("SONG_NAME", song.title)
            }
            startActivity(context, intent, null)
        }

    }



    /**
     *+
     */


}