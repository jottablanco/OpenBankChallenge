package com.jorgereyes.openbankchallenge.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jorgereyes.openbankchallenge.R
import com.jorgereyes.openbankchallenge.data.util.Resource
import com.jorgereyes.openbankchallenge.databinding.FragmentHeroDashboardBinding
import com.jorgereyes.openbankchallenge.presentation.adapter.HeroAdapter
import com.jorgereyes.openbankchallenge.presentation.viewModel.HeroViewModel

class HeroDashboardFragment : Fragment() {

  private lateinit var viewModel: HeroViewModel
  private lateinit var heroesAdapter: HeroAdapter
  private lateinit var binding: FragmentHeroDashboardBinding

  private var page = 1
  private var isScrolling = false
  private var isLoading = false
  private var isLastPage = false
  private var pages = 0

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_hero_dashboard, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = FragmentHeroDashboardBinding.bind(view)
    viewModel = (activity as MainActivity).viewModel
    heroesAdapter = (activity as MainActivity).heroAdapter

    heroesAdapter.setOnItemClickListener {
      val bundle = Bundle().apply {
        putSerializable("selected_hero", it)
      }
      findNavController().navigate(R.id.action_dashboardFragment_to_detailsFragment, bundle)
    }

    initRecyclerView()
    viewHeroesList()
  }

  private fun initRecyclerView() {
    binding.rvHeroes.apply {
      adapter = heroesAdapter
      layoutManager = LinearLayoutManager(activity)
      addOnScrollListener(this@HeroDashboardFragment.onScrollListener)
    }
  }

  private fun viewHeroesList() {
    viewModel.getHeroesList()
    viewModel.heroesData.observe(viewLifecycleOwner) { response ->
      when (response) {
        is Resource.Success -> {
          hideProgressBar()
          response.data?.let {
            heroesAdapter.differ.submitList(it.data.results)
            pages = if (it.data.count % 20 == 0) {
              it.data.count / 20
            } else {
              it.data.count / 20 + 1
            }
            isLastPage = page == pages
          }
        }
        is Resource.Error -> {
          hideProgressBar()
          response.message.let {
            Toast.makeText(activity, "Seems like JARVIS is not responding: $it", Toast.LENGTH_LONG).show()
          }
        }
        is Resource.Loading -> {
          showProgressBar()
        }
      }
    }
  }

  // ----------------------------- Scroll Utils
  private val onScrollListener = object : RecyclerView.OnScrollListener() {
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
      super.onScrollStateChanged(recyclerView, newState)
      if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
        isScrolling = true
      }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
      super.onScrolled(recyclerView, dx, dy)
      val layoutManager = binding.rvHeroes.layoutManager as LinearLayoutManager
      val sizeOfTheCurrentList = layoutManager.itemCount
      val visibleItems = layoutManager.childCount
      val topPosition = layoutManager.findFirstVisibleItemPosition()

      val hasReachedToEnd = topPosition + visibleItems >= sizeOfTheCurrentList
      val shouldPaginate = !isLoading && !isLastPage && hasReachedToEnd && isScrolling
      if (shouldPaginate) {
        page++
        viewModel.getHeroesList()
        isScrolling = false
      }
    }
  }

  // --------------------------- View Common Methods
  private fun showProgressBar() {
    isLoading = true
    binding.progressBar.visibility = View.VISIBLE
  }

  private fun hideProgressBar() {
    isLoading = false
    binding.progressBar.visibility = View.INVISIBLE
  }
}
