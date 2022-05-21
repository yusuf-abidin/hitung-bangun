package org.d3if0070.hitungbangun.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0070.hitungbangun.db.HitungDao
import org.d3if0070.hitungbangun.db.HitungEntity
import org.d3if0070.hitungbangun.model.HasilHitung

class HitungViewModel(private val db: HitungDao): ViewModel() {

    private val hasilHitung = MutableLiveData<HasilHitung?>()
    val data = db.getLastPerhitungan()

    fun hitungPP(panjang : Float, lebar : Float){
        val keliling = 2 * (panjang + lebar)
        val luas = panjang * lebar

        hasilHitung.value = HasilHitung(keliling, luas)

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val dataPerhitungan = HitungEntity(
                    panjang = panjang,
                    lebar = lebar
                )
                db.insert(dataPerhitungan)
            }
        }

    }

    fun getHasilHitung(): LiveData<HasilHitung?> = hasilHitung
}