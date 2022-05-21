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
import org.d3if0070.hitungbangun.model.hitungBangun

class HitungViewModel(private val db: HitungDao): ViewModel() {

    private val hasilHitung = MutableLiveData<HasilHitung?>()

    fun hitungPP(panjang : Float, lebar : Float){
       val dataHitung = HitungEntity(
           panjang= panjang,
           lebar = lebar
       )
        hasilHitung.value = dataHitung.hitungBangun()

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                db.insert(dataHitung)
            }
        }

    }

    fun getHasilHitung(): LiveData<HasilHitung?> = hasilHitung
}