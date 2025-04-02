package com.example.meetocure

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.meetocure.databinding.ActivityMainBinding
import com.example.meetocure.fragments.HomeFragment
import com.example.meetocure.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener {

            try {
                when (it.itemId) {
                    R.id.home -> {
                        loadFragment(HomeFragment())
                        true
                    }
                    R.id.search -> {
                        loadFragment(ProfileFragment())
                        true
                    } else -> {
                    R.id.profile
                    loadFragment(ProfileFragment())
                    true
                }
                }
            } catch (e : Exception) {
                throw e
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(com.google.android.material.R.id.container, fragment)
            transaction.commit()
        }
    }
}