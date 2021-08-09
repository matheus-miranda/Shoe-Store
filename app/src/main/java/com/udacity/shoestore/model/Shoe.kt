package com.udacity.shoestore.model

import androidx.databinding.BaseObservable

data class Shoe(
    var name: String,
    var size: String,
    var company: String,
    var description: String
) : BaseObservable()