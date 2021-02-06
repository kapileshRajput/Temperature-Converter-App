package com.example.thetempconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.thetempconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tempEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tempEditText = binding.tempEditText
    }


    //    Fahrenheit to Celsius Formula: (°F - 32) / 1.8 = °C
    fun convertToCelsius(view: View) {
        if (!editTextIsEmpty()) {
            val enteredValue = tempEditText.text.toString().toDouble()
            Toast.makeText(
                this,
                "$enteredValue Fahrenheit is ${String.format("%.2f",(enteredValue - 32) / 1.8)} Celsius.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    //    Celsius to Fahrenheit Formula: (°C * 1.8) + 32 = °F
    fun convertToFahrenheit(view: View) {
        if (!editTextIsEmpty()){
            val enteredValue = tempEditText.text.toString().toDouble()
            Toast.makeText(
                this,
                "$enteredValue Celsius is  ${String.format("%.2f",(enteredValue * 1.8) + 32)} Fahrenheit.",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun editTextIsEmpty(): Boolean{
        val str = tempEditText.text.toString()
        if(str.isNullOrEmpty()){
            Toast.makeText(this, "Please enter a value.", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }
}