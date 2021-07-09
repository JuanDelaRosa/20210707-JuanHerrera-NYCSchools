package com.juandelarosa.nycschools.app

import com.juandelarosa.nycschools.network.NetworkModule
import com.juandelarosa.nycschools.network.mappers.NYCMapper
import com.juandelarosa.nycschools.network.repositories.NYCRemoteDataSource


//Object dedicated to building the service repository
object ServiceLocator {
    private val networkModule by lazy {
        NetworkModule()
    }
    @Volatile
    var repository: NYCRemoteDataSource? = null

    fun provideRepository() : NYCRemoteDataSource{
        synchronized(this){
            return repository ?: createRepository()
        }
    }

    private fun createRepository(): NYCRemoteDataSource {
        val newRepo =
                NYCRemoteDataSource(
                    networkModule.createAPI("https://data.cityofnewyork.us/resource/"),
                    NYCMapper()
                )
        repository = newRepo
        return newRepo
    }
}