package org.d3if0070.hitungbangun.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.databinding.FragmentHitungBinding
import org.d3if0070.hitungbangun.model.HasilHitung

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View {

        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnHitung.setOnClickListener{ hitungPP()}
        binding.btnReset.setOnClickListener { reset() }
        viewModel.getHasilHitung().observe(requireActivity(), {showResult(it)})
    }


    private fun hitungPP(){

        val panjang = binding.editTextpanjang.text.toString()
        if(TextUtils.isEmpty(panjang)){
            Toast.makeText(context, R.string.panjang_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val lebar = binding.editTextlebar.text.toString()
        if (TextUtils.isEmpty(lebar)){
            Toast.makeText(context, R.string.lebar_invalid, Toast.LENGTH_LONG).show()
            return
        }

        viewModel.hitungPP(
            panjang.toFloat(), lebar.toFloat()
        )
    }

    private fun showResult(result: HasilHitung?){

        if (result == null) return

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