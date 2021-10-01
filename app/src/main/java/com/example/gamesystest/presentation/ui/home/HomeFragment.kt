package com.example.gamesystest.presentation.ui.home

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesystest.R
import com.example.gamesystest.common.ConnectivityLiveData
import com.example.gamesystest.databinding.FragmentHomeBinding
import com.example.gamesystest.presentation.adapters.CountryAdapter
import com.example.gamesystest.presentation.base.BaseFragment
import com.example.gamesystest.presentation.extensions.makeGone
import com.example.gamesystest.presentation.extensions.makeVisible
import com.example.gamesystest.presentation.extensions.toastMessage
import com.example.gamesystest.utils.Resources
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var connectivityLiveData: ConnectivityLiveData

    private lateinit var countryAdapter: CountryAdapter

    private val viewModel: HomeViewModel by activityViewModels()

    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {
        connectivityLiveData = ConnectivityLiveData(requireActivity().application)
        binding.countryList.layoutManager = LinearLayoutManager(requireContext())

        countryAdapter = CountryAdapter(requireContext()) {
            val action = HomeFragmentDirections.actionHomeFragmentToCountryDetailsFragment(it)
            launchFragment(action)
        }
        binding.countryList.adapter = countryAdapter

        binding.swipeToRefresh.setProgressViewOffset( false, PROGRESS_OFFSET, PROGRESS_OFFSET )
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.onFragmentReady()
        }
    }

    override fun observeData() {
        connectivityLiveData.observe(viewLifecycleOwner) { isAvailable ->
            handleNetworkAvailability(isAvailable)
        }
        viewModel.countries.observe(viewLifecycleOwner) {
            when (it) {
                is Resources.Loading -> {
                    binding.progressBar.makeVisible()
                }
                is Resources.Failure -> {
                    binding.progressBar.makeGone()
                    requireContext().toastMessage(it.msg)
                }
                is Resources.Success -> {
                    binding.progressBar.makeGone()
                    countryAdapter.update(it.data)
                }
            }
        }
    }

    private fun handleNetworkAvailability(isAvailable: Boolean?) {
        when (isAvailable) {
            true -> {
                viewModel.onFragmentReady()
            }
            false -> {
                requireContext().toastMessage(getString(R.string.check_internet_connection))
            }
        }
    }

    companion object {
        const val PROGRESS_OFFSET = -200
    }
}