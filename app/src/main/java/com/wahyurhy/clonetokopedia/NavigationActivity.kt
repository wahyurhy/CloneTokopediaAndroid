package com.wahyurhy.clonetokopedia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wahyurhy.clonetokopedia.databinding.ActivityNavigationBinding
import com.wahyurhy.clonetokopedia.ui.login.LoginActivity
import com.wahyurhy.clonetokopedia.utils.Prefs

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)

        navView.setupWithNavController(navController)

        // click to notification bottom bar
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_notifications) {
                val s = Prefs(this)
                if (s.getIsLogin()) {
                    Log.d("TAG", "Sudah Login")
                    navController.navigate(it.itemId)
                } else {
                    Log.d("TAG", "Belum Login")
                    val intentLogin = Intent(this@NavigationActivity, LoginActivity::class.java)
                    startActivity(intentLogin)
                }

            } else {
                navController.navigate(it.itemId)
                Log.d("TAG", "onCreate: yang lain id${it.itemId}")
            }

            return@setOnItemSelectedListener true
        }
    }
}