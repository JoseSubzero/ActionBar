package com.example.actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.actionbar.databinding.ActivityResultBinding

class ActivityResult : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}