package com.wahyurhy.clonetokopedia.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wahyurhy.clonetokopedia.R
import com.wahyurhy.clonetokopedia.databinding.ActivityLoginBinding
import com.wahyurhy.clonetokopedia.utils.Prefs

class LoginActivity : AppCompatActivity() {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val s = Prefs(this)
        if (s.getIsLogin()) {
            binding.titleLoginForm.text = "Sudah Berhasil Login"
            binding.btnLogout.visibility = View.VISIBLE
            binding.btnLogin.visibility = View.GONE
        } else {
            binding.titleLoginForm.text = "Halaman Login"
            binding.btnLogout.visibility = View.GONE
            binding.btnLogin.visibility = View.VISIBLE
        }
        binding.btnLogin.setOnClickListener {
            s.setIsLogin(true)
            onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            s.setIsLogin(false)
            onBackPressed()
        }
    }
}