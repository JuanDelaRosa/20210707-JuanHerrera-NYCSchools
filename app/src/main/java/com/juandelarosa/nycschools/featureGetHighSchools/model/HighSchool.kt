package com.juandelarosa.nycschools.featureGetHighSchools.model

///Info to use in UI
data class HighSchool(
    val id : String,
    val Name : String,
    val overview: String,
    val location: String,
    val coordenates: String,
    val phone: String,
    val email: String,
    val website: String
)

