package com.juandelarosa.nycschools.ui

import androidx.lifecycle.*
import com.juandelarosa.nycschools.network.responses.HighSchool
import com.juandelarosa.nycschools.network.responses.HighSchoolSAT
import com.juandelarosa.nycschools.usercases.GetHighSchoolSATUserCase
import kotlinx.coroutines.launch

class InfoViewModel(private val userCase: GetHighSchoolSATUserCase) : ViewModel() {

    private val _highSchoolSAT = MutableLiveData<HighSchoolSAT>()
    val highSchoolSAT = _highSchoolSAT

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isNotInternet = MutableLiveData<Boolean>()
    val isNotInternet: LiveData<Boolean> = _isNotInternet


    private val _highSchool = MutableLiveData<HighSchool>()
    val highSchool = _highSchool

    //Try to request the API information
    fun getSAT(){
        viewModelScope.launch {
            val lstRes = HighSchoolSAT(
                "01M292",
            "29",
            "355",
            "404",
            "363",
                "HENRY STREET SCHOOL FOR INTERNATIONAL STUDIES"
            )
            _highSchoolSAT.postValue(lstRes)
            /*when(val result = userCase.invoke(highSchool.id)){
                is Result.Success ->{
                    //Notify the observer that the information was received
                    _highSchoolSAT.postValue(result.data)
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

    fun prepareUI(highSchool: HighSchool) {
        this.highSchool.postValue(highSchool)
    }

    class InfoViewModelFactory(private val userCase: GetHighSchoolSATUserCase) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return InfoViewModel(userCase) as T
        }
    }
}