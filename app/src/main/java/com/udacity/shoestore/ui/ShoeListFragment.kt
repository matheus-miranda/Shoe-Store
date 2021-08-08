package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel by activityViewModels<ShoeListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            for (shoe in shoeList) {
                DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater,
                    R.layout.shoe_item,
                    binding.llShoeList,
                    true
                ).apply { this.shoe = shoe }
            }
        })

        return binding.root
    }
}