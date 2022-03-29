package org.d3if0070.hitungbangun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.d3if0070.hitungbangun.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener{ hitungPP()}
    }

    private fun hitungPP(){
        Log.d("MainActivity", "Tombol diklik!")
    }
}