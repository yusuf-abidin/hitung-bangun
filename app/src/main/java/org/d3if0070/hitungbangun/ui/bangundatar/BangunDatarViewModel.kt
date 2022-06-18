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
        retreiveData()
    }

    private fun retreiveData(){
        viewModelScope.launch ( Dispatchers.IO){
            try {
                data.postValue(BangunDatarApi.service.getBangunDatar())
            }catch (e: Exception){
                Log.d("BangunDatarView", "Failure: ${e.message}")
        } }
    }


    fun getData(): LiveData<List<BangunDatar>> = data
}