package com.addenisov00.testtaskvk.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.addenisov00.testtaskvk.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}