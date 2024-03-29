package com.wahyurhy.marketplace

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.wahyurhy.marketplace.databinding.ActivityNavigationBinding
import com.wahyurhy.marketplace.ui.login.LoginActivity
import com.wahyurhy.marketplace.utils.Prefs

class NavigationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_keranjang, R.id.navigation_notifications
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setOnItemSelectedListener {

            if (it.itemId == R.id.navigation_notifications) {
                val s = Prefs(this)
                if (s.getIsLogin()) {
                    Log.d("NavigationActivity", "Sudah Login")
                    navController.navigate(it.itemId)
                } else {
                    Log.d("NavigationActivity", "Belum Login, pindah ke menu login")
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            } else {
                Log.d("NavigationActivity", "onCreate: yang lain ${it.itemId}")
                navController.navigate(it.itemId)
            }

            return@setOnItemSelectedListener true
        }
    }
}