package com.juandelarosa.nycschools.featureGetHighSchoolSAT.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juandelarosa.nycschools.app.LayoutUtils
import com.juandelarosa.nycschools.app.NYCApp
import com.juandelarosa.nycschools.databinding.ActivityInfoBinding
import com.juandelarosa.nycschools.featureGetHighSchoolSAT.viewmodel.InfoViewModel
import com.juandelarosa.nycschools.featureGetHighSchools.model.HighSchool


class InfoActivity : AppCompatActivity() {
    private val binding: ActivityInfoBinding by lazy { ActivityInfoBinding.inflate(layoutInflater) }
    private val vm: InfoViewModel by lazy { InfoViewModel.InfoViewModelFactory((application as NYCApp).getHighSchoolSAT)
        .create(InfoViewModel::class.java) }

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
        val coordenates = intent.extras?.get("coordenates") as String
        val website = intent.extras?.get("website") as String
        vm.prepareUI(HighSchool(id,name,overview,location,coordenates, phone, email, website))
        vm.getSAT()

        vm.error.observe(this, {
            LayoutUtils.showSnack(binding.root, it)
        })

        binding.phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${phone.replace("-","")}")
            startActivity(Intent.createChooser(intent,"Phone Call"))
        }
        binding.email.setOnClickListener {
            val uri = Uri.parse("mailto:$email")
                .buildUpon()
                .appendQueryParameter("subject", "Information please")
                .build()
            val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
            startActivity(Intent.createChooser(emailIntent, "Email"))
        }
        binding.website.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://$website"))
            startActivity(browserIntent)
        }
        binding.location.setOnClickListener {
            val navigationIntentUri =
                Uri.parse("google.navigation:q=$coordenates") //creating intent with latlng

            val mapIntent = Intent(Intent.ACTION_VIEW, navigationIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}