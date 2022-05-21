package org.d3if0070.hitungbangun.model

import org.d3if0070.hitungbangun.db.HitungEntity

fun HitungEntity.hitungBangun(): HasilHitung {
    val keliling = 2 * (panjang + lebar)
    val luas = panjang * lebar

    return HasilHitung(keliling, luas)
}