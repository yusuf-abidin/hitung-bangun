package org.d3if0070.hitungbangun.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [HitungEntity::class], version = 1, exportSchema = false)
abstract class HitungDb : RoomDatabase(){
    abstract val dao:HitungDao

    companion object{

        @Volatile
        private var INSTANCE: HitungDb? = null

        fun getInstance(context: Context): HitungDb {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HitungDb::class.java,
                        "hitung.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}