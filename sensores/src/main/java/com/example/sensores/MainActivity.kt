package com.example.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sensores.databinding.ActivityMainBinding

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

        // Obtener lista de sensores
        val sensorList = obtenerListaSensores()

        poblarContenedor(sensorList)

    }

    // Funcion basica para obtener lista de sensores
    private fun obtenerListaSensores() : List<Sensor> {
        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return sensorManager.getSensorList(Sensor.TYPE_ALL)
    }

    // Funcion basica para mostrar los sensores
    private fun poblarContenedor(sensorList : List<Sensor>) {
        val contenedor = binding.contenedor
        var textContenedor = ""

        for (sensor in sensorList) {
            textContenedor += "Sensor, Name: ${sensor.name}, Type: ${sensor.type}\n"
        }

        contenedor.text = textContenedor
    }
}