package com.udacity.shoestore.ui.shoes

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.datasource.ShoeDataSource
import com.udacity.shoestore.model.Shoe

class SharedShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<ArrayList<Shoe>>()
    val shoeList: LiveData<ArrayList<Shoe>> get() = _shoeList

    init {
        _shoeList.value = getList()
    }

    private fun getList(): ArrayList<Shoe> {
        return ShoeDataSource.getList()
    }

    fun addShoe(view: View, shoe: Shoe) {
        _shoeList.value?.add(shoe)
        view.findNavController().navigateUp()
    }

    fun onCancel(view: View) {
        view.findNavController().navigateUp()
    }
}