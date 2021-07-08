package com.juandelarosa.nycschools.ui

import androidx.lifecycle.*
import com.juandelarosa.nycschools.network.responses.HighSchool
import com.juandelarosa.nycschools.usercases.GetHighSchoolsUserCase
import kotlinx.coroutines.launch
import com.juandelarosa.nycschools.network.common.Result
import com.juandelarosa.nycschools.network.responses.HighSchoolSAT
import com.juandelarosa.nycschools.usercases.GetHighSchoolSATUserCase

class InfoViewModel(private val userCase: GetHighSchoolSATUserCase) : ViewModel() {

    private val _highSchool = MutableLiveData<HighSchoolSAT>()
    val highSchool = _highSchool

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isNotInternet = MutableLiveData<Boolean>()
    val isNotInternet: LiveData<Boolean> = _isNotInternet

    //Try to request the API information
    fun getHighSchoolSAT(){
        viewModelScope.launch {
            val lstRes = HighSchoolSAT(
                "01M292",
            "HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES",
            "29",
            "355",
            "404",
            "363")
            _highSchool.postValue(lstRes)
            /*when(val result = userCase.invoke()){
                is Result.Success ->{
                    //Notify the observer that the information was received
                    _highSchools.postValue(result.data)
                    _isNotInternet.value = false
                }
                is Result.Error ->{
                    //Notify the observer that the information is not received
                    _error.postValue(result.exception.message)
                    _isNotInternet.value = true
                }
            }*/
        }
    }

    class InfoViewModelFactory(private val userCase: GetHighSchoolSATUserCase) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return InfoViewModel(userCase) as T
        }
    }
}