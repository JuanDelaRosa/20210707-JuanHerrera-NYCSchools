package com.juandelarosa.nycschools.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
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
        binding.mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.mRecyclerView.adapter = MainAdapter{
            val intent = Intent(this,InfoActivity::class.java)
            intent.putExtra("id", it.id)
            intent.putExtra("name", it.Name)
            intent.putExtra("overview", it.overview)
            intent.putExtra("email", it.email)
            intent.putExtra("phone", it.phone)
            intent.putExtra("location", it.location)
            intent.putExtra("website", it.website)
            startActivity(intent)
        }
        vm.getHighSchoolList()
        vm.highSchools.observe(this, {highSchool ->
            highSchool?.let {
                (binding.mRecyclerView.adapter as MainAdapter).setData(it)
            }
        })
    }
}