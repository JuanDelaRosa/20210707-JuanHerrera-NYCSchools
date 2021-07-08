package com.juandelarosa.nycschools.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juandelarosa.nycschools.R
import com.juandelarosa.nycschools.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {

    }
}