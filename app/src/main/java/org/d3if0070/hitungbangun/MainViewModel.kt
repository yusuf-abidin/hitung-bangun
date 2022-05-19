package org.d3if0070.hitungbangun

import androidx.lifecycle.ViewModel
import org.d3if0070.hitungbangun.model.HasilHitung

class MainViewModel: ViewModel() {

    fun hitungPP(panjang : Float, lebar : Float) : HasilHitung {
        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        return HasilHitung(keliling, luas)
    }
}