package ru.itis.summerpractise24_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ru.itis.summerpractise24_1.databinding.FragmentStopBinding

class StopFragment : Fragment(R.layout.fragment_stop) {
    private lateinit var binding: FragmentStopBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStopBinding.bind(view)
        val id = arguments?.getInt(ID)
        binding.run {
            backButton.setOnClickListener {
                findNavController().navigateUp()
            }
            val song = MusicRepository.musics.find { it.id == id }
            if (song != null) {
                tvTitle.text = song.song
                author.text = song.singer
                tvShortDescription.text = song.shortDescription
                tvDescription.text = song.description
                Glide.with(view)
                    .load(song.url)
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.ic_music_note_24)
                    .into(ivAlbum)
            }
        }
    }

    companion object {
        private const val ID = "id"
        fun bundle(id: Int) = bundleOf(ID to id)
    }
}
