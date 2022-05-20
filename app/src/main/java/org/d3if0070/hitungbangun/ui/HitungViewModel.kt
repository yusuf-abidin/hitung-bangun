package org.d3if0070.hitungbangun.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if0070.hitungbangun.model.HasilHitung

class MainViewModel: ViewModel() {

    private val hasilHitung = MutableLiveData<HasilHitung?>()

    fun hitungPP(panjang : Float, lebar : Float){
        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        hasilHitung.value = HasilHitung(keliling, luas)
    }

    fun getHasilHitung(): LiveData<HasilHitung?> = hasilHitung
}