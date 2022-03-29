package org.d3if0070.hitungbangun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        val panjang = binding.editTextpanjang.text.toString().toFloat()
        val lebar = binding.editTextlebar.text.toString().toFloat()
        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        binding.hasilKeliling.text = getString(R.string.hasilKeliling, keliling)
        binding.hasilLuas.text = getString(R.string.hasilLuas, luas)

    }


}