package com.juandelarosa.nycschools.usercases

import com.juandelarosa.nycschools.network.repositories.NYCRemoteDataSource

//User case to consume the information from the api service
class GetHighSchoolSATUserCase(private val repository: NYCRemoteDataSource) {
    suspend operator fun invoke(id: String) = repository.getHSSAT(id)
}