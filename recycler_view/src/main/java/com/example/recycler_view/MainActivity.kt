package com.example.recycler_view

import CardAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view.databinding.ActivityMainBinding

/**
 * Pasos para crear un recycler view
 * - 1. Crear proyecto con empty views activity
 * - 2. Crear layout con la CardView
 * - 3. Crear la data class con los datos que queremos mostrar en el CardView
 * - 4. Crear la clase CardAdapter que extiende de RecyclerView.Adapter
 * - 5. Meter la clase CardViewHolder que extiende de RecyclerView.ViewHolder dentro de CardAdapter
 * - 6. Trabajar en el MainActivity
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

        // Crea la lista de elementos
        val listaElementos = listOf(
            Elemento(R.drawable.escudo, "Título 1", "Descripción del primer item"),
            Elemento(R.drawable.escudo, "Título 2", "Descripción del segundo item"),
            Elemento(R.drawable.escudo, "Título 3", "Descripción del tercer item"),
        )

        // Configura el RecyclerView
        val adapter = CardAdapter(listaElementos)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

    }
}