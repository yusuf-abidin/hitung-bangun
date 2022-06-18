package org.d3if0070.hitungbangun.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0070.hitungbangun.BangunDatar
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/yusuf-abidin/api/main/Bangun%20Datar/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface BangunDatarApiService {
    @GET("bangun-datar.json")
    suspend fun getBangunDatar(): List<BangunDatar>
}

object BangunDatarApi{
    val service: BangunDatarApiService by lazy {
        retrofit.create(BangunDatarApiService::class.java)
    }

    fun getBangunDatarUrl(nama : String): String {
        return "$BASE_URL$nama.jpg"
    }
}

enum class ApiStatus {LOADING, SUCCESS, FAILED}