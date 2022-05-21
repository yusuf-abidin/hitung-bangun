package org.d3if0070.hitungbangun.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "hitung")
data class HitungEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0L,
    var tanggal : Long = System.currentTimeMillis(),
    var panjang : Float,
    var lebar : Float

)