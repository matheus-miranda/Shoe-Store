package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.datasource.ShoeDataSource
import com.udacity.shoestore.model.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> get() = _shoeList

    init {
        // Add example shoe when the app starts
        addShoe(Shoe("Air Force 1", 10.5, "Nike", "Nike Shoes"))
        addShoe(Shoe("Nano X1", 9.0, "Rebook", "Rebook Shoes"))
        _shoeList.value = getList()
    }

    private fun getList(): List<Shoe> {
        return ShoeDataSource.getList()
    }

    fun addShoe(shoe: Shoe) {
        ShoeDataSource.addShoe(shoe)
    }
}