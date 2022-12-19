package com.example.couplescalculator.Model

import com.google.gson.annotations.SerializedName

data class Percentage(
    @SerializedName("fname")
    val yourName: String,

    @SerializedName("sname")
    val partnerName: String,

    @SerializedName("percentage")
    val percentage: Int,

    @SerializedName("result")
    val result: String

)
