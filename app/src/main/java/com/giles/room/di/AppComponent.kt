package com.giles.room.di

import android.app.Application
import com.giles.room.RoomApp
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuildersModule::class))
interface AppComponent {

//    @Component.Builder
//    interface Builder {
//        @BindsInstance
//        fun application(application: MaterialfennecApp): Builder
//
//        fun build(): AppComponent
//    }

    fun application(): Application
    fun inject(app: RoomApp)
}