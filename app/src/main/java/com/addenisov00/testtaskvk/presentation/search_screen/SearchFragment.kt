package com.addenisov00.testtaskvk.presentation.search_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.addenisov00.domain.models.GiffItem
import com.addenisov00.testtaskvk.R
import com.addenisov00.testtaskvk.common.Constants
import com.addenisov00.testtaskvk.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private val viewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
        observeImages()
//        viewModel.searchGiffs("cheeseburgers")

    }

    private fun observeImages() {
        lifecycleScope.launchWhenStarted {
            viewModel.giffsList.collect {
                adapter.submitList(it)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.isLoadingGiffs.collect {
                binding.pBarSearching.visibility = if (it) View.VISIBLE else View.GONE
                binding.swipeToRefresh.isRefreshing = it
            }
        }
    }

    private fun setUI() {
        adapter = SearchAdapter(object : SearchAdapter.Listener {
            override fun onClick(item: GiffItem) {
                val itemToDetails = bundleOf(Constants.GIFF_DETAILS_KEY to item)
                findNavController().navigate(
                    R.id.action_searchFragment_to_detailsFragment,
                    itemToDetails
                )
            }
        })

        binding.rcGiffs.adapter = adapter
        binding.rcGiffs.layoutManager = GridLayoutManager(requireContext(), 2)

        binding.btnFind.setOnClickListener {
            viewModel.searchGiffs(binding.editTextTextPersonName.text.toString())
        }
        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.searchGiffs(binding.editTextTextPersonName.text.toString())
        }
    }
}