package org.d3if0070.hitungbangun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if0070.hitungbangun.databinding.ActivityMainBinding
import org.d3if0070.hitungbangun.model.HasilHitung

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

        val result = hitungPP(
            panjang.toFloat(), lebar.toFloat()
        )

       showResult(result)

    }

    private fun hitungPP(panjang : Float, lebar : Float) : HasilHitung{
        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        return HasilHitung(keliling, luas)
    }

    private fun showResult(result: HasilHitung){
        binding.hasilKeliling.text = getString(R.string.hasilKeliling, result.keliling)
        binding.hasilLuas.text = getString(R.string.hasilLuas, result.luas)
    }

    private fun reset(){
        binding.editTextlebar.setText("")
        binding.editTextpanjang.setText("")
        binding.hasilLuas.setText("50")
        binding.hasilKeliling.setText("30 cm")

    }

}