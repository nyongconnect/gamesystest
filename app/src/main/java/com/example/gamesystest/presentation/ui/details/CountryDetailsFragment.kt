package com.example.gamesystest.presentation.ui.details

import android.view.Gravity
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesystest.R
import com.example.gamesystest.databinding.FragmentCountryDetailsBinding
import com.example.gamesystest.presentation.adapters.CountryDetailAdapter
import com.example.gamesystest.presentation.base.BaseFragment
import com.example.gamesystest.presentation.extensions.displayImage

class CountryDetailsFragment: BaseFragment<FragmentCountryDetailsBinding>() {

    private val args : CountryDetailsFragmentArgs by navArgs()

    private val viewModel: CountryDetailsViewModel by activityViewModels()

    override fun getViewBinding(): FragmentCountryDetailsBinding = FragmentCountryDetailsBinding.inflate(layoutInflater)

    lateinit var detailAdapter: CountryDetailAdapter

    override fun setUp() {
        binding.collapsingToolbarLayout.title = args.country.name
        binding.collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(requireContext(), R.color.toolbar_color))
        binding.collapsingToolbarLayout.expandedTitleGravity = Gravity.BOTTOM
        binding.collapsingToolbarLayout.collapsedTitleGravity = Gravity.CENTER
        binding.expandedImage.displayImage(args.country.alpha2Code.lowercase().replace("-", "-"), requireContext())

        detailAdapter = CountryDetailAdapter(requireContext())
        binding.included.informationList.layoutManager = LinearLayoutManager(requireContext())
        binding.included.informationList.adapter = detailAdapter
        viewModel.loadInformation(args.country)
    }

    override fun observeData() {
        viewModel.lifeData.observe(viewLifecycleOwner) {
            detailAdapter.update(it.list)
        }
    }
}