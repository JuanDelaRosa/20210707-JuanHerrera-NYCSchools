package com.juandelarosa.nycschools.app

import android.app.Application
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.usercase.GetHighSchoolSATUserCase
import com.juandelarosa.nycschools.featureGetHighSchools.usercase.GetHighSchoolsUserCase
import com.juandelarosa.nycschools.network.repositories.NYCRemoteDataSource

//User cases that are available in this application
class NYCApp: Application() {
    private  val repository: NYCRemoteDataSource
        get() = ServiceLocator.provideRepository()

    val getHighSchool: GetHighSchoolsUserCase
        get() = GetHighSchoolsUserCase(repository)

    val getHighSchoolSAT: GetHighSchoolSATUserCase
        get() = GetHighSchoolSATUserCase(repository)
}