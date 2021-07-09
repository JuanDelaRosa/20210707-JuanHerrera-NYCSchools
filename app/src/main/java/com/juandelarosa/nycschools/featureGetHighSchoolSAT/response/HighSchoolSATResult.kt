package com.juandelarosa.nycschools.featureGetHighSchoolSAT.response

import com.google.gson.annotations.SerializedName

///Response from service
data class HighSchoolSATResult (
    @SerializedName("hs") val hs : List<HsSAT>?
)

data class HsSAT (
    @SerializedName("dbn") val dbn : String?,
    @SerializedName("school_name") val school_name : String?,
    @SerializedName("num_of_sat_test_takers") val num_of_sat_test_takers : String?,
    @SerializedName("sat_critical_reading_avg_score") val sat_critical_reading_avg_score : String?,
    @SerializedName("sat_math_avg_score") val sat_math_avg_score : String?,
    @SerializedName("sat_writing_avg_score") val sat_writing_avg_score : String?
)