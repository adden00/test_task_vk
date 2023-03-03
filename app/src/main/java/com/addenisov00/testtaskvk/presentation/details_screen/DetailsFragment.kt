package com.addenisov00.testtaskvk.presentation.details_screen

import android.os.Bundle
import android.provider.MediaStore.Images
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.addenisov00.domain.models.GiffItem
import com.addenisov00.testtaskvk.common.Constants
import com.addenisov00.testtaskvk.databinding.FragmentDetailsBinding
import com.addenisov00.testtaskvk.presentation.search_screen.SearchViewModel
import com.bumptech.glide.Glide

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.selectGif(arguments?.getSerializable(Constants.GIFF_DETAILS_KEY) as GiffItem)
        observeData()
        setUI()

    }

    private fun setUI() {
        binding.imGiff.setOnLongClickListener {
            saveImageToGallery()
            true
        }
    }

    private fun saveImageToGallery() {
        binding.imGiff.isDrawingCacheEnabled = true
        val b = binding.imGiff.drawingCache
        Images.Media.insertImage(requireActivity().contentResolver, b, "title.gif", "description")
        Toast.makeText(requireContext(), "Saved to gallery!", Toast.LENGTH_SHORT).show()
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.selectedGif.collect {
                it?.let { item ->
                    binding.includedDetailsInfo.tvName.text = item.title
                    binding.includedDetailsInfo.tvDescription.text = "description: ${item.slug}"
                    binding.includedDetailsInfo.tvRating.text = "rating: ${item.rating}"
                    Glide.with(binding.root.context).load(item.url).fitCenter().into(binding.imGiff)
                }
            }
        }
    }
}