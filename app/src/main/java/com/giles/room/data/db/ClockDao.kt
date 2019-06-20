package com.giles.room.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.giles.room.data.model.ClockData
import io.reactivex.Flowable

@Dao
abstract class ClockDao{
    @Insert(onConflict = OnConflictStrategy.ROLLBACK)
    abstract fun insertClockData(clockData: ClockData?) : Long

    @Query("SELECT * FROM ClockData")
    abstract fun getClockData(): Flowable<Array<ClockData>>



}