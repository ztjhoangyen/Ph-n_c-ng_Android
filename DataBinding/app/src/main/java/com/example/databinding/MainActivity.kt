package com.example.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        val  objtest =  MainViewModel(
            name = "Ok lan dau test"
        )

        binding.mainViewModel = objtest

        setContentView(binding.root)
        openMyFragment()

    }

    fun openMyFragment(){
//        val fragment  = BlankFragment()
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentLayout, BlankFragment())
            .commit()
    }
}