package org.d3if0070.hitungbangun.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if0070.hitungbangun.db.HitungDao

class HistoriViewModel(db:HitungDao) : ViewModel() {
    val data = db.getLastPerhitungan()
}