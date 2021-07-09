package com.juandelarosa.nycschools.featureGetHighSchoolSAT.model

///Info to use in UI
data class HighSchoolSAT(
    val id: String,
    val numOfSatTestTakers: String,
    val criticalReadingAvgScore: String,
    val mathAvgScore: String,
    val writingAvgScore: String,
    val Name: String
)