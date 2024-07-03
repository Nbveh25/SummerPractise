package ru.itis.summerpractise24_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractise24_1.databinding.ItemMusicBinding

class MusicAdapter(
    private val list: List<Music>,
    private val glide: RequestManager,
    private val onClick: (Music) -> Unit,
) : RecyclerView.Adapter<MusicHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MusicHolder = MusicHolder(
        binding = ItemMusicBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.onBind(list[position])
    }
}