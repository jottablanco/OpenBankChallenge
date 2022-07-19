package com.jorgereyes.openbankchallenge.presentation.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.databinding.HeroListItemBinding

class HeroAdapter: RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

  private val callback = object : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
      return oldItem.characterId == newItem.characterId
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
      return oldItem == newItem
    }
  }

  val differ = AsyncListDiffer(this, callback)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
    val binding = HeroListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return HeroViewHolder(binding)
  }

  override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
    val hero = differ.currentList[position]
    holder.bind(hero)
  }

  override fun getItemCount(): Int {
    return differ.currentList.size
  }

  inner class HeroViewHolder(
    private val binding: HeroListItemBinding
  ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(hero: Result) {

      Glide.with(binding.ivHeroIcon.context)
        .load(Uri.parse(hero.characterThumbnail.path.plus(IMAGE_SIZE).plus(hero.characterThumbnail.extension)))
        .into(binding.ivHeroIcon)

      binding.tvHeroName.text = hero.characterName

      binding.root.setOnClickListener {
        onItemClickListener?.let {
          it(hero)
        }
      }
    }
  }

  private var onItemClickListener:((Result) -> Unit) ?= null

  fun setOnItemClickListener(listener : (Result)->Unit){
    onItemClickListener = listener
  }

  companion object {
    const val IMAGE_SIZE = "/portrait_small."
  }
}
