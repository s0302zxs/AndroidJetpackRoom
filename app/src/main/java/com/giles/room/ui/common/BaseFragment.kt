package com.giles.room.ui.common

import android.os.Bundle
import android.support.v4.app.Fragment
import com.giles.room.di.Injectable

open class BaseFragment : Fragment(), Injectable {

/*
* IF NEDD
* */

//    @Inject
//    lateinit var mPreferencesHelper: PreferencesHelper
//
//    @Inject
//    lateinit var mErrorDialog:ErrorDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}