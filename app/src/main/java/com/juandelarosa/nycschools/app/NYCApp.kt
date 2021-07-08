package com.juandelarosa.nycschools.app

import android.app.Application
import com.juandelarosa.nycschools.network.repositories.NYCRemoteDataSource
import com.juandelarosa.nycschools.usercases.GetHighSchoolsUserCase

class NYCApp: Application() {
    private  val repository: NYCRemoteDataSource
        get() = ServiceLocator.provideRepository()

    val getHighSchool: GetHighSchoolsUserCase
        get() = GetHighSchoolsUserCase(repository)
}