package org.d3if0070.hitungbangun.ui.bangundatar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0070.hitungbangun.BangunDatar
import org.d3if0070.hitungbangun.R

class BangunDatarViewModel : ViewModel() {
    private val data = MutableLiveData<List<BangunDatar>>()

    init {
    data.value =initData()
    }

    private fun initData(): List<BangunDatar>{
        return listOf(
            BangunDatar("Persegi", "4", "pxl", "pxl",  R.drawable.persegipanjang),
            BangunDatar("Persegi Panjang", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Jajar Genjang", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Layang-Layang", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Trapesium", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Segitiga", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Belah Ketupat", "4","pxl","pxl",    R.drawable.persegipanjang),
            BangunDatar("Lingkaran", "4","pxl","pxl",    R.drawable.persegipanjang)
        )
    }

    fun getData(): LiveData<List<BangunDatar>> = data
}