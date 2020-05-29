package com.example.mvvmsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.R
import com.example.mvvmsample.databinding.ActivityMainBinding
import com.example.mvvmsample.ui.auth.AuthListener
import com.example.mvvmsample.ui.auth.AuthViewModel
import com.example.mvvmsample.util.Toast
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        Toast("Login started")
        progressBar.visibility = View.VISIBLE
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        //Toast("Login success")
        loginResponse.observe(this, Observer {
            progressBar.visibility = View.GONE
            Toast(it)
        })
    }

    override fun onFailure(message: String) {
        progressBar.visibility = View.GONE
        Toast(message)
     }
}
