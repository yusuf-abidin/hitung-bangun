package org.d3if0070.hitungbangun.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HitungDao {
    @Insert
    fun insert(hitung: HitungEntity)

    @Query("SELECT * FROM perhitungan ORDER BY id DESC LIMIT 1")
    fun getLastPerhitungan(): LiveData<HitungEntity>
}