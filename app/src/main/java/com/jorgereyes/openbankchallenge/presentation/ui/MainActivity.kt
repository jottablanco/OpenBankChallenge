package com.jorgereyes.openbankchallenge.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.jorgereyes.openbankchallenge.R
import com.jorgereyes.openbankchallenge.databinding.ActivityMainBinding
import com.jorgereyes.openbankchallenge.presentation.adapter.FavoriteCharactersAdapter
import com.jorgereyes.openbankchallenge.presentation.adapter.HeroAdapter
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModel
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var factory: HeroViewModelFactory

  @Inject
  lateinit var heroAdapter: HeroAdapter

  @Inject
  lateinit var favCharacterAdapter: FavoriteCharactersAdapter

  lateinit var viewModel: HeroViewModel
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {

    val splashScreen = installSplashScreen()

    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
    val navController = navHostFragment.navController

    binding.bnvControls.setupWithNavController(navController)
    viewModel = ViewModelProvider(this, factory).get(HeroViewModel::class.java)
  }
}
