package com.giles.room.ui.common

import android.arch.lifecycle.ViewModel
import com.giles.room.data.model.ClockData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedViewModel : ViewModel{
    private var mCompositeDisposable : CompositeDisposable


    companion object {

    }

    /****************  Clock data ***************************/
    var clockData : ClockData? = null

    @Inject
    constructor(compositeDisposable : CompositeDisposable){
        mCompositeDisposable = compositeDisposable

    }






}