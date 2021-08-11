package com.udacity.shoestore.datasource

import com.udacity.shoestore.model.Shoe

object ShoeDataSource {

    private val shoeList = arrayListOf<Shoe>()

    fun getList() = shoeList
}