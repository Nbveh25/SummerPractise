package ru.itis.summerpractise24_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractise24_1.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {
    private var binding: FragmentMusicBinding? = null
    private var adapter: MusicAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)

        initAdapter()
    }

    private fun initAdapter() {
        binding?.run {
            adapter = MusicAdapter(
                list = MusicRepository.musics,
                glide = Glide.with(this@MusicFragment),
                onClick = {
                    findNavController().navigate(
                        R.id.action_musicFragment_to_danzaKuduroFragment,
                        DanzaKuduroFragment.bundle(it.id)
                    )
                }
            )

            rvMusic.adapter = adapter
            rvMusic.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
