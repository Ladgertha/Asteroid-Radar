package ru.ladgertha.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.ladgertha.asteroidradar.R
import ru.ladgertha.asteroidradar.adapter.AsteroidAdapter
import ru.ladgertha.asteroidradar.databinding.FragmentMainBinding
import ru.ladgertha.asteroidradar.interactor.GetAsteroidsListInteractor
import ru.ladgertha.asteroidradar.interactor.GetImageOfTheDayInteractor
import ru.ladgertha.asteroidradar.repository.RepositoryProvider
import ru.ladgertha.asteroidradar.utils.AsteroidsFilter

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val repositoryProvider by lazy {
        RepositoryProvider()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentMainBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val viewModelFactory = ViewModelFactory(
            GetAsteroidsListInteractor(repositoryProvider.getAsteroidRepository(requireContext())),
            GetImageOfTheDayInteractor(repositoryProvider.getImageOfTheDayRepository(requireContext()))
        )
            .create(MainViewModel::class.java)
        viewModel = viewModelFactory
        binding.viewModel = viewModel
        binding.asteroidRecyclerView.adapter =
            AsteroidAdapter(AsteroidAdapter.OnClickListener { asteroid ->
                viewModel.imageOfTheDay.value?.let { image ->
                    findNavController().navigate(
                        MainFragmentDirections.actionShowDetail(
                            asteroid,
                            image
                        )
                    )
                }
            })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filter = when (item.itemId) {
            R.id.show_week_menu -> AsteroidsFilter.WEEK
            R.id.show_saved_menu -> AsteroidsFilter.ALL
            R.id.show_today_menu -> AsteroidsFilter.TODAY
            else -> AsteroidsFilter.ALL
        }
        viewModel.updateAsteroidsListWithFilter(
            filter
        )
        return true
    }
}
