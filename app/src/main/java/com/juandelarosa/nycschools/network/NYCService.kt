package com.juandelarosa.nycschools.network

import com.juandelarosa.nycschools.network.responses.HighSchoolResult
import retrofit2.Response
import retrofit2.http.GET

interface NYCService {
    @GET("s3k6-pzi2.json")
    suspend fun getHighSchools() : Response<HighSchoolResult>
}