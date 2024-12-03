package com.example.actividades_1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    val PESO = "peso"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Intent basico
        val irBtn = binding.ir

        val intent = Intent(this, SecondaryActivity::class.java)

        irBtn.setOnClickListener {
            startActivity(intent)
        }


        // Intent con datos
        val irConDatos = binding.irConDatos

        val intent_con_extras = Intent(this, SecondaryActivity::class.java)

        // Datos posiblemente recogidos de un formulario
        val peso = 80.0

        irConDatos.setOnClickListener {
            intent.putExtra(PESO, peso)
            startActivity(intent)
        }
    }
}