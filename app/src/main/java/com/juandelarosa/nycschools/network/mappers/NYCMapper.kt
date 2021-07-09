package com.juandelarosa.nycschools.network.mappers

import com.google.gson.Gson
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.model.HighSchoolSAT
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.response.HighSchoolSATResult
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.response.HsSAT
import com.juandelarosa.nycschools.featureGetHighSchools.model.HighSchool
import com.juandelarosa.nycschools.featureGetHighSchools.response.HSItem
import com.juandelarosa.nycschools.featureGetHighSchools.response.HighSchoolResult

//Class dedicated to mapping the response of the server in clean information, free of nulls and ready to use
class NYCMapper {
    fun fromResponse(response : String?) : List<HighSchool>{
        //Hack to use api response as a GSON correctly
        val responseNew = response.toString().replaceFirst("[{","{\"hs\":[{").replace("}]","}]}")
        val resp = Gson().fromJson(responseNew, HighSchoolResult::class.java)
        return resp.hs?.let { list ->
            list.map {
                createHighSchool(it)
            }
        } ?: emptyList()
    }




    private fun createHighSchool(hs : HSItem?) : HighSchool = if(hs==null)
        HighSchool("","","","","","","","")
    else {
        HighSchool(
            hs.dbn ?:"",
            hs.school_name ?:"",
            hs.overview_paragraph ?:"",
            hs.location?.substring(0,hs.location.lastIndexOf("(")) ?:"",
            "${hs.latitude},${hs.longitude}",
            hs.phone_number ?:"",
            hs.school_email ?:"",
            hs.website ?:""
        )
    }

    private fun createHighSchoolSAT(hs : HighSchoolSATResult?) : HighSchoolSAT {
         return hs?.let { result ->
            result.hs?.let {
                if(it.isNotEmpty()){
                    HighSchoolSAT(
                        it[0].dbn ?: "",
                        it[0].num_of_sat_test_takers ?: "",
                        it[0].sat_critical_reading_avg_score ?: "",
                        it[0].sat_math_avg_score ?: "",
                        it[0].sat_writing_avg_score ?: "",
                        it[0].school_name ?: ""
                    )
                }else HighSchoolSAT("", "", "", "", "", "")
            }
        } ?: HighSchoolSAT("", "", "", "", "", "")
    }

    fun fromSATResponse(response: String?) : HighSchoolSAT {
        //Hack to use api response as a GSON correctly
        val responseNew = response.toString().replaceFirst("[{","{\"hs\":[{").replace("}]","}]}")
        val resp = Gson().fromJson(responseNew, HighSchoolSATResult::class.java)
        return createHighSchoolSAT(resp)
    }
}