package com.juandelarosa.nycschools.featureGetHighSchools.usercase

import com.juandelarosa.nycschools.network.repositories.NYCRemoteDataSource

//User case to consume the information from the api service
class GetHighSchoolsUserCase(private val repository: NYCRemoteDataSource) {
    suspend operator fun invoke() = repository.getHomeFeeds()
}