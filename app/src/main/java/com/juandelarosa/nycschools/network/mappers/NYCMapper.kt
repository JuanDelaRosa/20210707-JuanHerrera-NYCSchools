package com.juandelarosa.nycschools.network.mappers

import com.juandelarosa.nycschools.featureGetHighSchoolSAT.model.HighSchoolSAT
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.response.HighSchoolSATResult
import com.juandelarosa.nycschools.featureGetHighSchools.model.HighSchool
import com.juandelarosa.nycschools.featureGetHighSchools.response.HighSchoolItemResult
import com.juandelarosa.nycschools.featureGetHighSchools.response.HighSchoolResult

//Class dedicated to mapping the response of the server in clean information, free of nulls and ready to use
class NYCMapper {
    fun fromResponse(response : HighSchoolResult?) : List<HighSchool>{
        return response?.let { list ->
            list.map {
                createHighSchool(it)
            }
        } ?: emptyList()
    }

    private fun createHighSchool(hs : HighSchoolItemResult?) : HighSchool = if(hs==null)
        HighSchool("","","","","","","")
    else {
        HighSchool(
            hs.dbn ?:"",
            hs.school_name ?:"",
            hs.overview_paragraph ?:"",
            hs.location ?:"",
            hs.phone_number ?:"",
            hs.school_email ?:"",
            hs.website ?:""
        )
    }

    private fun createHighSchoolSAT(hs : HighSchoolItemResult?) : HighSchool = if(hs==null)
        HighSchool("","","","","","","")
    else {
        HighSchool(
            hs.dbn ?:"",
            hs.school_name ?:"",
            hs.overview_paragraph ?:"",
            hs.location ?:"",
            hs.phone_number ?:"",
            hs.school_email ?:"",
            hs.website ?:""
        )
    }

    fun fromSATResponse(response: HighSchoolSATResult?) : HighSchoolSAT {
        return try {
            response?.let {
                HighSchoolSAT(
                    it[0].dbn ?: "",
                    it[0].num_of_sat_test_takers ?: "",
                    it[0].sat_critical_reading_avg_score ?: "",
                    it[0].sat_math_avg_score ?: "",
                    it[0].sat_writing_avg_score ?: "",
                    it[0].school_name ?: ""
                )
            } ?: HighSchoolSAT("", "", "", "", "", "")
        }catch (e:Exception){
            HighSchoolSAT("", "", "", "", "", "")
        }
    }
}