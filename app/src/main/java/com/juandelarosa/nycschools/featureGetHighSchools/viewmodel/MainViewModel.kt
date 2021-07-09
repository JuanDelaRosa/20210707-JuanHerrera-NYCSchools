package com.juandelarosa.nycschools.featureGetHighSchools.viewmodel

import androidx.lifecycle.*
import com.juandelarosa.nycschools.featureGetHighSchools.model.HighSchool
import com.juandelarosa.nycschools.featureGetHighSchools.usercase.GetHighSchoolsUserCase
import kotlinx.coroutines.launch

//ViewModel of the main activity
class MainViewModel(private val userCase: GetHighSchoolsUserCase) : ViewModel() {

    private val _highSchools = MutableLiveData<List<HighSchool>>()
    val highSchools = _highSchools

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _isNotInternet = MutableLiveData<Boolean>()
    val isNotInternet: LiveData<Boolean> = _isNotInternet

    //Try to request the API information
    fun getHighSchoolList(){
        viewModelScope.launch {
            val lstRes = mutableListOf(
                HighSchool(
                    "02M260",
                    "Clinton School Writers & Artists, M.S. 260",
                    "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
                    "10 East 15th Street, Manhattan NY 10003 (40.736526, -73.992727)",
                    "212-524-4360",
                    "admissions@theclintonschool.net",
                    "www.theclintonschool.net"),
                HighSchool(
                    "21K728",
                    "Liberation Diploma Plus High School",
                    "The mission of Liberation Diploma Plus High School, in partnership with CAMBA, is to develop the student academically, socially, and emotionally. We will equip students with the skills needed to evaluate their options so that they can make informed and appropriate choices and create personal goals for success. Our year-round model (trimesters plus summer school) provides students the opportunity to gain credits and attain required graduation competencies at an accelerated rate. Our partners offer all students career preparation and college exposure. Students have the opportunity to earn college credit(s). In addition to fulfilling New York City graduation requirements, students are required to complete a portfolio to receive a high school diploma.",
                    "2865 West 19th Street, Brooklyn, NY 11224 (40.576976, -73.985413)",
                    "718-946-6812",
                    "scaraway@schools.nyc.gov",
                    "schools.nyc.gov/schoolportals/21/K728"),
                HighSchool(
                    "08X282",
                    "Women's Academy of Excellence",
                    "The WomenÂ’s Academy of Excellence is an all-girls public high school, serving grades 9-12. Our mission is to create a community of lifelong learners, to nurture the intellectual curiosity and creativity of young women and to address their developmental needs. The school community cultivates dynamic, participatory learning, enabling students to achieve academic success at many levels, especially in the fields of math, science, and civic responsibility. Our scholars are exposed to a challenging curriculum that encourages them to achieve their goals while being empowered to become young women and leaders. Our Philosophy is GIRLS MATTER!",
                    "456 White Plains Road, Bronx NY 10473 (40.815043, -73.85607)",
                    "718-542-0740",
                    "sburns@schools.nyc.gov",
                    "schools.nyc.gov/SchoolPortals/08/X282"),
                HighSchool(
                    "17K548",
                    "Brooklyn School for Music & Theatre",
                    "Brooklyn School for Music & Theatre (BSMT) uses our academic program to accommodate the intellectual, social, and emotional needs of creative high school students. Our vision is to provide a model professional environment where respect is mutual, ideas are shared, and learning is not limited to the classroom. We prepare students for higher education through our rigorous academic program while simultaneously allowing them to develop professional careers in the music and theatre industries.",
                    "883 Classon Avenue, Brooklyn NY 11225 (40.669805, -73.960689)",
                    "718-230-6250",
                    "prandaz@schools.nyc.gov",
                    "www.bkmusicntheatre.com"),
                HighSchool(
                    "27Q314",
                    "Epic High School - South",
                    "Epic High School Â– South, an outgrowth of the NYC Expanded Success Initiative (ESI), provides a rigorous, culturally relevant academic program that prepares students for the demands of college and careers. EpicÂ’s personalized approach to instruction challenges students to dream big and design their futures. It engages students in solving real-world problems and supports their individual progress and growth. Epic students graduate with confidence in their ability to transform the world around them.",
                    "121-10 Rockaway Boulevard, South Ozone Park NY 11420 (40.675021, -73.81673)",
                    "718-845-1290",
                    "info@epicschoolsnyc.org",
                    "www.epicschoolsnyc.org")
            )
            _highSchools.postValue(lstRes)
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

    class MainViewModelFactory(private val userCase: GetHighSchoolsUserCase) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(userCase) as T
        }
    }
}