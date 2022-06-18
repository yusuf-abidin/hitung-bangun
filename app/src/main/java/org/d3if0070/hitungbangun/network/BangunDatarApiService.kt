package org.d3if0070.hitungbangun.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/yusuf-abidin/api/main/Bangun%20Datar/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface BangunDatarApiService {
    @GET("bangun-datar.json")
    suspend fun getBangunDatar(): String
}

object BangunDatarApi{
    val service: BangunDatarApiService by lazy {
        retrofit.create(BangunDatarApiService::class.java)
    }
}