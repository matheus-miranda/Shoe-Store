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
        _shoeList.value = getList()
    }

    private fun getList(): List<Shoe> {
        return ShoeDataSource.getList()
    }

    fun addShoe(shoe: Shoe) {
        ShoeDataSource.addShoe(shoe)
    }
}