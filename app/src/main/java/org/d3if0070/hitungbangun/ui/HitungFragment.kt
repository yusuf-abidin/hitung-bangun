package org.d3if0070.hitungbangun.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.databinding.FragmentHitungBinding
import org.d3if0070.hitungbangun.model.HasilHitung

class HitungFragment : Fragment() {

    private lateinit var binding: FragmentHitungBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity())[MainViewModel::class.java]

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_about){
            findNavController().navigate(
                R.id.action_hitungFragment_to_aboutFragment
            )
            return true
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View {

        binding = FragmentHitungBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnHitung.setOnClickListener{ hitungPP()}
        binding.btnReset.setOnClickListener { reset() }
        binding.shareButton.setOnClickListener { shareData() }

        binding.buttonRumus.setOnClickListener {
            it.findNavController().navigate(
                R.id.action_hitungFragment_to_rumusFragment
            )
        }

        viewModel.getHasilHitung().observe(requireActivity(), {showResult(it)})
    }

    private fun shareData(){
        val message = getString(R.string.template_bagikan,
        binding.editTextpanjang.text,
        binding.editTextlebar.text,
        binding.hasilKeliling.text,
        binding.hasilLuas.text)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, message)
        if (shareIntent.resolveActivity(
                requireActivity().packageManager) != null){
            startActivity(shareIntent)
        }
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

        binding.butttonGroup.visibility = View.VISIBLE
    }

    private fun reset(){
        binding.editTextlebar.setText("")
        binding.editTextpanjang.setText("")
        binding.hasilLuas.setText("50")
        binding.hasilKeliling.setText("30 cm")

    }

}