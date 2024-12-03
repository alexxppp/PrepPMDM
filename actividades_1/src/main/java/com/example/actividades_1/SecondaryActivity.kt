package com.example.actividades_1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades_1.databinding.ActivitySecondaryBinding

class SecondaryActivity : AppCompatActivity() {

    lateinit var binding : ActivitySecondaryBinding
    val PESO = "peso"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondaryBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Intent basico
        val volverBtn = binding.volver

        volverBtn.setOnClickListener {
            finish()
        }

        // Ver datos al hacer click
        val verBtn = binding.verDatos

        verBtn.setOnClickListener {
            val twPeso = binding.peso
            twPeso.text = intent.getDoubleExtra(PESO, 0.0).toString()
        }

    }
}