package com.jorgereyes.openbankchallenge.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorgereyes.openbankchallenge.R
import com.jorgereyes.openbankchallenge.data.model.FavoriteCharacter
import com.jorgereyes.openbankchallenge.data.model.Result
import com.jorgereyes.openbankchallenge.data.util.Resource
import com.jorgereyes.openbankchallenge.databinding.FragmentFavoriteHeroesBinding
import com.jorgereyes.openbankchallenge.presentation.adapter.FavoriteCharactersAdapter
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModel

class FavoriteHeroesFragment : Fragment() {

  private lateinit var viewModel: HeroViewModel
  private lateinit var favoriteCharactersAdapter: FavoriteCharactersAdapter
  private lateinit var binding: FragmentFavoriteHeroesBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_favorite_heroes, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentFavoriteHeroesBinding.bind(view)
    viewModel = (activity as MainActivity).viewModel
    favoriteCharactersAdapter = (activity as MainActivity).favCharacterAdapter

    favoriteCharactersAdapter.setOnItemClickListener {
      val bundle = Bundle().apply {
        putSerializable("selected_hero", transformObject(it))
      }
      findNavController().navigate(R.id.action_savedFragment_to_detailsFragment, bundle)
    }

    viewModel.getFavoriteCharacters().observe(viewLifecycleOwner) {
      favoriteCharactersAdapter.differ.submitList(it)
    }

    initRecyclerView()
  }

  private fun transformObject(favoriteCharacter: FavoriteCharacter): Result {
    return Result(
      characterId = favoriteCharacter.favoriteCharacterId,
      characterDescription = favoriteCharacter.favoriteCharacterDescription,
      characterModified = favoriteCharacter.favoriteCharacterModified,
      characterName = favoriteCharacter.favoriteCharacterName,
      characterResourceURI = favoriteCharacter.favoriteCharacterResourceURI,
      characterThumbnail = favoriteCharacter.favoriteCharacterThumbnail
    )
  }

  private fun initRecyclerView() {
    binding.rvHeroes.apply {
      adapter = favoriteCharactersAdapter
      layoutManager = GridLayoutManager(activity, 2)
    }
  }
}
