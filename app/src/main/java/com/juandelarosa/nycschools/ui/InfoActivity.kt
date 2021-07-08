package com.juandelarosa.nycschools.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juandelarosa.nycschools.R
import com.juandelarosa.nycschools.app.NYCApp
import com.juandelarosa.nycschools.databinding.ActivityInfoBinding
import com.juandelarosa.nycschools.databinding.ActivityMainBinding

class InfoActivity : AppCompatActivity() {
    private val binding: ActivityInfoBinding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    private val vm: InfoViewModel by lazy { InfoViewModel.InfoViewModelFactory((application as NYCApp).getHighSchoolSAT).create(InfoViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        vm.getHighSchoolSAT()
        vm.highSchool.observe(this, {hs ->
            hs?.let {
                /*LayoutUtils.removeSplashScreen(binding.logo)
                (binding.feeds.adapter as CardAdapter).setData(it)
                vm.saveBackup(cards)*/
            }
        })
    }
}