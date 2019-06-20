package com.giles.room.di

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.giles.room.RoomApp
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

object AppInjector {

    fun init(roomApp: RoomApp) {

        DaggerAppComponent.builder()
            .appModule(AppModule(roomApp))
            .build()
            .inject(roomApp)

        roomApp
            .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity,
                                               savedInstanceState: Bundle?) {
                    handleActivity(activity)
                }

                override fun onActivityStarted(activity: Activity) {

                }

                override fun onActivityResumed(activity: Activity) {

                }

                override fun onActivityPaused(activity: Activity) {

                }

                override fun onActivityStopped(activity: Activity) {

                }

                override fun onActivitySaveInstanceState(activity: Activity,
                                                         outState: Bundle?) {

                }

                override fun onActivityDestroyed(activity: Activity) {

                }
            })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is Injectable || activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
            object : FragmentManager.FragmentLifecycleCallbacks() {
                override fun onFragmentPreAttached(fm: FragmentManager, f: Fragment, context: Context) {
//                    super.onFragmentPreAttached(fm, f, context)
                    if (f is Injectable) {
                        AndroidSupportInjection.inject(f)
                    }
                }

            }, true)
    }
}