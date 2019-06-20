package com.giles.room.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.giles.room.api.ApiService
import com.giles.room.data.db.ClockDao
import com.giles.room.data.db.DeviceEmployeeDao
import com.giles.room.data.db.DeviceLoginDao
import com.giles.room.data.db.RoomDb
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(ViewModelModule::class))
class AppModule {
    private val application: Application

    constructor(application: Application) {
        this.application = application

    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return this.application
    }

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }


    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client : OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        return Retrofit.Builder()
            .baseUrl("http://192.168.78.887/")
//                .baseUrl("http://192.168.10.29")
            .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)   //show log
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): RoomDb {
        return Room
            .databaseBuilder(app, RoomDb::class.java, "room.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDeviceLoginDao(db: RoomDb): DeviceLoginDao {
        return db.deviceLoginDao()
    }

    @Singleton
    @Provides
    fun provideDeviceEmployeeDao(db: RoomDb): DeviceEmployeeDao {
        return db.deviceEmployeeDao()
    }

    @Singleton
    @Provides
    fun provideClockDao(db: RoomDb): ClockDao {
        return db.clockDao()
    }
}