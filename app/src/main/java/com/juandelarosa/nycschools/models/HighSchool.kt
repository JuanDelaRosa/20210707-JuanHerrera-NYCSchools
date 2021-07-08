package com.juandelarosa.nycschools.network.responses

data class HighSchool(
    val id : String,
    val Name : String,
    val overview: String,
    val location: String,
    val phone: String,
    val email: String,
    val website: String
)

