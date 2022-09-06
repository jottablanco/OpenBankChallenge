package com.jorgereyes.openbankchallenge.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.jorgereyes.openbankchallenge.R
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.databinding.FragmentHeroDetailBinding
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HeroDetailFragment : Fragment() {

  private lateinit var binding: FragmentHeroDetailBinding
  private lateinit var viewModel: HeroViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_hero_detail, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentHeroDetailBinding.bind(view)
    val args: HeroDetailFragmentArgs by navArgs()
    val hero = args.selectedHero

    viewModel = (activity as MainActivity).viewModel
    binding.icCarousel.addData(getMediaDataSet(hero))
    binding.tvHeroName.text = hero.characterName
    binding.tvDescription.text = hero.characterDescription.ifEmpty {
      getString(R.string.description_placeholder)
    }
    binding.fabSaveHero.setOnClickListener {
      viewModel.saveFavoriteCharacters(transformObject(hero))
      val snackbar = Snackbar.make(view, "${hero.characterName} was recruited for your Heroes team!", Snackbar.LENGTH_SHORT)
      snackbar.anchorView = binding.fabSaveHero
      snackbar.show()
    }
  }

  private fun getMediaDataSet(hero: Result): MutableList<CarouselItem> {
    val mediaList = mutableListOf<CarouselItem>()
    mediaList.add(
      CarouselItem(imageUrl = hero.characterThumbnail.path.plus(IMAGE_SIZE).plus(hero.characterThumbnail.extension))
    )
    mediaList.add(
      CarouselItem(R.mipmap.ic_marvel_logo)
    )
    mediaList.add(
      CarouselItem(R.mipmap.ic_awesome_logo)
    )
    return mediaList
  }

  private fun transformObject(hero: Result): FavoriteCharacter {
    return FavoriteCharacter(
      favoriteCharacterId = hero.characterId,
      favoriteCharacterDescription = hero.characterDescription,
      favoriteCharacterModified = hero.characterModified,
      favoriteCharacterName = hero.characterName,
      favoriteCharacterResourceURI = hero.characterResourceURI,
      favoriteCharacterThumbnail = hero.characterThumbnail
    )
  }

  companion object {
    const val IMAGE_SIZE = "/standard_fantastic."
  }
}
