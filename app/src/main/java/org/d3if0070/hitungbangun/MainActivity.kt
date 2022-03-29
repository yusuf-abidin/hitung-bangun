package org.d3if0070.hitungbangun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0070.hitungbangun.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener{ hitungPP()}
        binding.btnReset.setOnClickListener { reset() }
    }


    private fun hitungPP(){

        val panjang = binding.editTextpanjang.text.toString()
        if(TextUtils.isEmpty(panjang)){
            Toast.makeText(this, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val lebar = binding.editTextlebar.text.toString()
        if (TextUtils.isEmpty(lebar)){
            Toast.makeText(this, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val keliling = 2 * (panjang.toFloat() + lebar.toFloat())
        val luas = panjang.toFloat() * lebar.toFloat()

        binding.hasilKeliling.text = getString(R.string.hasilKeliling, keliling)
        binding.hasilLuas.text = getString(R.string.hasilLuas, luas)

    }

    private fun reset(){
        binding.editTextlebar.setText("")
        binding.editTextpanjang.setText("")
    }


}