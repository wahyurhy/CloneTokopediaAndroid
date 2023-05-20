package com.wahyurhy.marketplace.ui.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.wahyurhy.marketplace.R
import com.wahyurhy.marketplace.databinding.ActivityLoginBinding
import com.wahyurhy.marketplace.utils.Prefs
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModel()

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }

    private fun setData() {
        viewModel.text.observe(this) {
            binding.edtEmail.setText(it)
        }

        binding.btnMasuk.setOnClickListener {
            viewModel.ubahData()
        }
    }

    fun testing() {
        val s = Prefs(this)
        if (s.getIsLogin()) {
            binding.tvStatus.text = getString(R.string.sudah_login)
            binding.btnLogin.visibility = View.GONE
            binding.btnLogout.visibility = View.VISIBLE
        } else {
            binding.tvStatus.text = getString(R.string.belum_login)
            binding.btnLogin.visibility = View.VISIBLE
            binding.btnLogout.visibility = View.GONE
        }

        binding.btnLogin.setOnClickListener {
            s.setIsLogin(true)
            onBackPressedDispatcher.onBackPressed()
        }

        binding.btnLogout.setOnClickListener {
            s.setIsLogin(false)
            onBackPressedDispatcher.onBackPressed()
        }
    }
}