package com.juandelarosa.nycschools.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juandelarosa.nycschools.R
import com.juandelarosa.nycschools.app.NYCApp
import com.juandelarosa.nycschools.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val vm: MainViewModel by lazy { MainViewModel.MainViewModelFactory((application as NYCApp).getHighSchool).create(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        vm.getHighSchoolList()
        vm.highSchools.observe(this, {highSchool ->
            highSchool?.let {
                /*LayoutUtils.removeSplashScreen(binding.logo)
                (binding.feeds.adapter as CardAdapter).setData(it)
                vm.saveBackup(cards)*/
            }
        })
    }
}