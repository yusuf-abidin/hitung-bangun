package org.d3if0070.hitungbangun.ui.bangundatar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ColorStateListInflaterCompat.inflate
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3if0070.hitungbangun.BangunDatar
import org.d3if0070.hitungbangun.databinding.FragmentAboutBinding.inflate
import org.d3if0070.hitungbangun.databinding.FragmentBangunDatarBinding
import org.d3if0070.hitungbangun.databinding.FragmentHistoryBinding.inflate
import org.d3if0070.hitungbangun.databinding.FragmentRumusBinding.inflate
import org.d3if0070.hitungbangun.network.ApiStatus

class BangunDatarFragment : Fragment() {
    private val viewModel: BangunDatarViewModel by lazy {
        ViewModelProvider(this)[BangunDatarViewModel::class.java]
    }

    private lateinit var binding :FragmentBangunDatarBinding
    private lateinit var myAdapter: BangunDatarAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =FragmentBangunDatarBinding.inflate(layoutInflater, container, false)
        myAdapter = BangunDatarAdapter()
        with(binding.recyclerView){
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData().observe(viewLifecycleOwner) {
            myAdapter.updateData(it)
        }
        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
    }

    private fun updateProgress(status: ApiStatus){
        when(status){
            ApiStatus.LOADING ->{
                binding.progressBar.visibility = View.VISIBLE
            }
            ApiStatus.SUCCESS ->{
                binding.progressBar.visibility = View.GONE
            }
            ApiStatus.FAILED ->{
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }
}