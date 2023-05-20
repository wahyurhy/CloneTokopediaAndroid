package com.wahyurhy.marketplace.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wahyurhy.marketplace.core.data.source.remote.request.LoginRequest
import com.wahyurhy.marketplace.databinding.ActivityLoginBinding
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

            val body = LoginRequest(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )

            viewModel.login(body).observe(this) {

            }
        }
    }
}