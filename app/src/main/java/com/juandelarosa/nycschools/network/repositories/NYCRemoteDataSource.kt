package com.juandelarosa.nycschools.network.repositories

import com.juandelarosa.nycschools.featureGetHighSchoolSAT.model.HighSchoolSAT
import com.juandelarosa.nycschools.featureGetHighSchools.model.HighSchool
import com.juandelarosa.nycschools.network.NYCService
import com.juandelarosa.nycschools.network.common.Exceptions
import com.juandelarosa.nycschools.network.common.Result
import com.juandelarosa.nycschools.network.mappers.NYCMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Repository dedicated to interacting with the API
class NYCRemoteDataSource (private val service: NYCService, private val mapper: NYCMapper) {
    suspend fun getHomeFeeds(): Result<List<HighSchool>> =
        withContext(Dispatchers.IO){
            try{
                val response = service.getHighSchools()
                if(response.isSuccessful){
                    return@withContext Result.Success(mapper.fromResponse(response.body()))
                }
                else
                    return@withContext Result.Error(Exception(Exceptions.NotAvailable))
            }catch (e:Exception){
                return@withContext Result.Error(Exception(Exceptions.NoInternet))
            }
        }

    suspend fun getHSSAT(id: String): Result<HighSchoolSAT> =
        withContext(Dispatchers.IO){
            try{
                val response = service.getHighSchoolSAT(id)
                if(response.isSuccessful && response.body()!="[]\n"){
                    return@withContext Result.Success(mapper.fromSATResponse(response.body()))
                }
                else
                    return@withContext Result.Error(Exception(Exceptions.NotAvailable))
            }catch (e:Exception){
                return@withContext Result.Error(Exception(Exceptions.NoInternet))
            }
        }
}