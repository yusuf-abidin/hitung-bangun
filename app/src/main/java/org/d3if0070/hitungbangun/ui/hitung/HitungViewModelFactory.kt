package org.d3if0070.hitungbangun.ui.hitung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0070.hitungbangun.db.HitungDao

class HitungViewModelFactory(
    private val db: HitungDao
) : ViewModelProvider.Factory {
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HitungViewModel::class.java)){
            return HitungViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}