package com.example.mvvmsample.util

import android.content.Context
import android.widget.Toast

fun Context.Toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}