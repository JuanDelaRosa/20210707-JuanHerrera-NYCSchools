package com.juandelarosa.nycschools.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.juandelarosa.nycschools.databinding.CardViewItemBinding
import com.juandelarosa.nycschools.network.responses.HighSchool

class MainAdapter(val click: (HighSchool)-> Unit) : RecyclerView.Adapter<MainAdapter.NYCViewHolder>() {
    var schools : ArrayList<HighSchool> = arrayListOf()
    lateinit var binding : CardViewItemBinding


    fun setData(list: List<HighSchool>){
        schools = list as ArrayList<HighSchool>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NYCViewHolder {
        binding = CardViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NYCViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NYCViewHolder, position: Int) {
        val school = schools[position]

        holder.binding.name.text = school.Name
        holder.binding.root.setOnClickListener{ click(school)}
    }

    override fun getItemCount(): Int {
        return schools.count()
    }

    class NYCViewHolder(val binding : CardViewItemBinding) : RecyclerView.ViewHolder(binding.root)
}