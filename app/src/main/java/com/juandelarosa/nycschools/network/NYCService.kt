package com.juandelarosa.nycschools.network

import com.juandelarosa.nycschools.network.responses.HighSchoolResult
import com.juandelarosa.nycschools.network.responses.HighSchoolSATResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NYCService {
    @GET("s3k6-pzi2.json")
    suspend fun getHighSchools() : Response<HighSchoolResult>
    @GET("f9bf-2cp4.json")
    suspend fun getHighSchoolSAT(@Query("dbn") dbn:String) : Response<HighSchoolSATResult>
}