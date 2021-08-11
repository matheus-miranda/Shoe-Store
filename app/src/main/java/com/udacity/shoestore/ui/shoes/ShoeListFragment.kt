package com.udacity.shoestore.ui.shoes

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.DataStorePref
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import kotlinx.coroutines.launch

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val sharedShoeViewModel by activityViewModels<SharedShoeViewModel>()
    private lateinit var dataStorePref: DataStorePref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.viewModel = sharedShoeViewModel
        dataStorePref = DataStorePref(requireContext())

        sharedShoeViewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            for (shoe in shoeList) {
                DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater,
                    R.layout.shoe_item,
                    binding.llShoeList,
                    true
                ).apply { this.shoe = shoe }
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        sharedShoeViewModel.clearList() // Clear shoe list when user logs out

        // When user logs out, save the value to the DataStore
        viewLifecycleOwner.lifecycleScope.launch {
            dataStorePref.savaToDataStore(DataStorePref.KEY, false)
        }

        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}
