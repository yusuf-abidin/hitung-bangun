package org.d3if0070.hitungbangun.ui.bangundatar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0070.hitungbangun.BangunDatar
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.network.BangunDatarApi
import java.lang.Exception

class BangunDatarViewModel : ViewModel() {
    private val data = MutableLiveData<List<BangunDatar>>()

    init {
    data.value =initData()
        retreiveData()

    }

    private fun retreiveData(){
        viewModelScope.launch ( Dispatchers.IO){
            try {
                val result = BangunDatarApi.service.getBangunDatar()
                Log.d("BangunDatarView", "Success: $result" )
            }catch (e: Exception){
                Log.d("BangunDatarView", "Failure: ${e.message}")
        } }
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