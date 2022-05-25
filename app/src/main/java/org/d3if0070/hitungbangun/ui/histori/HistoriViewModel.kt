package org.d3if0070.hitungbangun.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if0070.hitungbangun.db.HitungDao

class HistoriViewModel(private val db:HitungDao) : ViewModel() {
    val data = db.getLastPerhitungan()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }

}
