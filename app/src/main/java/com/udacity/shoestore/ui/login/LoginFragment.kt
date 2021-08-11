package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.DataStorePref
import com.udacity.shoestore.DataStorePref.Companion.KEY
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var dataStorePref: DataStorePref


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        // Read from DataStore to find out if user has logged in previously
        dataStorePref = DataStorePref(requireContext())
        viewLifecycleOwner.lifecycleScope.launch {
            val hasLoggedIn = dataStorePref.readFromDataStore(KEY)
            if (hasLoggedIn == true) {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment2())
            }
        }

        insertListeners()
        return binding.root
    }

    /**
     * Sets onClickListeners for buttons
     */
    private fun insertListeners() {
        binding.btnSignup.setOnClickListener {
            checkFields()
        }

        binding.btnLogin.setOnClickListener {
            checkFields()
        }
    }

    /**
     * Check if text fields are empty, if not, navigate to the next screen
     */
    private fun checkFields() {
        if (binding.etEmail.text.isNullOrBlank() || binding.etPassword.text.isNullOrEmpty())
            Toast.makeText(context, "Please fill out all the fields", Toast.LENGTH_SHORT).show()
        else
            navigateToWelcomeScreen(binding.etEmail.text.toString())
            savaToDataStore()
    }

    /**
     * When user enters valid login info, save to DataStore
     */
    private fun savaToDataStore() {
        viewLifecycleOwner.lifecycleScope.launch {
            dataStorePref.savaToDataStore(KEY, true)
        }
    }

    /**
     * Navigate to welcome screen and pass in the username
     * @param: email the e-mail that the user entered
     */
    private fun navigateToWelcomeScreen(email: String) {
        val user = email.substringBefore('@') // Get the string before the @ symbol
        findNavController().navigate(
            LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                user
            )
        )
    }
}