package org.d3if0070.hitungbangun.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HitungDao {
    @Insert
    fun insert(hitung: HitungEntity)

    @Query("SELECT * FROM hitung ORDER BY id DESC")
    fun getLastPerhitungan(): LiveData<List<HitungEntity>>

}