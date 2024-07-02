package ru.itis.summerpractise24_1

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ru.itis.summerpractise24_1.databinding.ItemMusicBinding

class MusicHolder(
    private val binding: ItemMusicBinding,
    private val glide: RequestManager,
    private val onClick: (Music) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(music: Music) {
        binding.run {
            tvSong.text = music.song
            tvSinger.text = music.singer

            glide
                .load(music.url)
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_music_note_24)
                .into(ivAlbum)

            root.setOnClickListener {
                onClick.invoke(music)


            }
        }
    }
}