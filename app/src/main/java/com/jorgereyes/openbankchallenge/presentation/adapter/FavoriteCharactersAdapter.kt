package com.jorgereyes.openbankchallenge.presentation.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.databinding.FavCharacterItemBinding

class FavoriteCharactersAdapter: RecyclerView.Adapter<FavoriteCharactersAdapter.FavoriteCharacterViewHolder>() {

  private val callback = object: DiffUtil.ItemCallback<FavoriteCharacter>() {
    override fun areItemsTheSame(oldItem: FavoriteCharacter, newItem: FavoriteCharacter): Boolean {
      return oldItem.favoriteCharacterId == newItem.favoriteCharacterId
    }

    override fun areContentsTheSame(oldItem: FavoriteCharacter, newItem: FavoriteCharacter): Boolean {
      return oldItem == newItem
    }
  }

  val differ = AsyncListDiffer(this, callback)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteCharacterViewHolder {
    val binding = FavCharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return FavoriteCharacterViewHolder(binding)
  }

  override fun onBindViewHolder(holder: FavoriteCharacterViewHolder, position: Int) {
    val favCharacter = differ.currentList[position]
    holder.bind(favCharacter)
  }

  override fun getItemCount(): Int {
    return differ.currentList.size
  }

  inner class FavoriteCharacterViewHolder(
    private val binding: FavCharacterItemBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(favoriteCharacter: FavoriteCharacter) {

      Glide.with(binding.ivHeroIcon.context)
        .load(
          Uri.parse(
            favoriteCharacter.favoriteCharacterThumbnail.path.plus(IMAGE_SIZE).plus(favoriteCharacter.favoriteCharacterThumbnail.extension)
          )
        )
        .into(binding.ivHeroIcon)

      binding.tvHeroName.text = favoriteCharacter.favoriteCharacterName

      binding.root.setOnClickListener {
        onItemClickListener?.let {
          it(favoriteCharacter)
        }
      }

    }
  }

  private var onItemClickListener: ((FavoriteCharacter) -> Unit)? = null

  fun setOnItemClickListener(listener: (FavoriteCharacter) -> Unit) {
    onItemClickListener = listener
  }

  companion object {
    const val IMAGE_SIZE = "/portrait_small."
  }
}
