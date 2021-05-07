package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var map: Map<String,Int>
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.spinner.adapter=adapter()
        binding.spinner.onItemSelectedListener
    }
    fun adapter():ArrayAdapter<CharSequence>{
        val adapter=ArrayAdapter.createFromResource(this,R.array.names,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return adapter
    }
    fun map():Map<String,Int>{
        val map= mapOf("yumeko" to R.drawable.yumeko,"mary" to R.drawable.mary,"ririka" to R.drawable.ririka,"runa" to R.drawable.runa,"kirari" to R.drawable.kirari,"midari" to R.drawable.midari,"itsuki" to R.drawable.itsuki)
        return map
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val mapHere=map()
        val str=parent?.getItemAtPosition(position).toString().toLowerCase()
        Log.e("YEET","did some fucking thing happened?")
        binding.imageView.setImageResource(mapHere[str] as Int)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
         Log.e("YEET","No it Did'nt")
    }
}