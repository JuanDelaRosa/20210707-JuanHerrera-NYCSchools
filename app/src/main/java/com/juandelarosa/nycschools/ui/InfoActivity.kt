package com.juandelarosa.nycschools.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juandelarosa.nycschools.app.NYCApp
import com.juandelarosa.nycschools.databinding.ActivityInfoBinding
import com.juandelarosa.nycschools.network.responses.HighSchool

class InfoActivity : AppCompatActivity() {
    private val binding: ActivityInfoBinding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    private val vm: InfoViewModel by lazy { InfoViewModel.InfoViewModelFactory((application as NYCApp).getHighSchoolSAT).create(InfoViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.vm = vm
        binding.lifecycleOwner = this
        val id = intent.extras?.get("id") as String
        val name = intent.extras?.get("name") as String
        val overview = intent.extras?.get("overview") as String
        val email = intent.extras?.get("email") as String
        val phone = intent.extras?.get("phone") as String
        val location = intent.extras?.get("location") as String
        val website = intent.extras?.get("website") as String
        vm.prepareUI(HighSchool(id,name,overview,location, phone, email, website))
        vm.getSAT()
    }
}