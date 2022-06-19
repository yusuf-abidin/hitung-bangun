package org.d3if0070.hitungbangun.ui.bangundatar

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Update
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0070.hitungbangun.BangunDatar
import org.d3if0070.hitungbangun.MainActivity
import org.d3if0070.hitungbangun.R
import org.d3if0070.hitungbangun.network.ApiStatus
import org.d3if0070.hitungbangun.network.BangunDatarApi
import org.d3if0070.hitungbangun.network.UpdateWorker
import java.lang.Exception
import java.util.concurrent.TimeUnit

class BangunDatarViewModel : ViewModel() {
    private val data = MutableLiveData<List<BangunDatar>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retreiveData()
    }

    private fun retreiveData(){
        viewModelScope.launch ( Dispatchers.IO){
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(BangunDatarApi.service.getBangunDatar())
                status.postValue(ApiStatus.SUCCESS)
            }catch (e: Exception){
                Log.d("BangunDatarView", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
        } }
    }


    fun getData(): LiveData<List<BangunDatar>> = data

    fun getStatus() : LiveData<ApiStatus> = status

    fun scheduleAdapter(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(app).enqueueUniqueWork(
            MainActivity.CHANNEL_ID,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}