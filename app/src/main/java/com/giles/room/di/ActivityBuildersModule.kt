package com.giles.room.di

import com.giles.room.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    abstract fun contributeMainActivity(): MainActivity

}