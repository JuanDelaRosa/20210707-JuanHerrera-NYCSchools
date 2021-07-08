package com.juandelarosa.nycschools.network.responses

data class HighSchoolSAT(
    val id: String,
    val numOfSatTestTakers: String,
    val criticalReadingAvgScore: String,
    val mathAvgScore: String,
    val writingAvgScore: String,
    val Name: String
)