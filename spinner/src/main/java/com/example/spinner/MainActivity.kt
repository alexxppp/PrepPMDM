package com.example.spinner

import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinner.databinding.ActivityMainBinding

/**
 * Pasos para crear un spinner
 * - 1. Crear proyecto con empty views activity
 * - 2. Añadir <Spinner> en el layout
 * - 3. Crear la lista de datos que queremos mostrar en el spinner
 * - 4. Hacer binding del spinner
 * - 5. Crear el adapter y asignarlo al spinner
 * - 6. Cambiar el texto del TextView en función del item seleccionado
 */

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

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

        // Paso 3
        val items = listOf("Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6", "Elemento 7")

        // Opcional
        val randomItems = items.shuffled().take(3)

        // Paso 4
        val spinner: Spinner = binding.spinner

        // Paso 5
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, randomItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Paso 6, refuerzo
        val textView: TextView = binding.tw

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Actualiza el TextView con el item seleccionado
                textView.text = randomItems[position]
            }

            // Obligatorio pero no necesario
            override fun onNothingSelected(parentView: AdapterView<*>) {
                // No hacer nada
            }
        }


    }
}