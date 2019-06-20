package com.giles.room.ui.main

import android.arch.lifecycle.ViewModel
import com.giles.room.data.model.ClockData
import com.giles.room.data.model.DeviceLoginData
import com.giles.room.data.model.NetworkState
import com.giles.room.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber
import timber.log.Timber
import javax.inject.Inject

class MainViewModel : ViewModel{
    private val mMainRepository: MainRepository
    private var mCompositeDisposable : CompositeDisposable

    var initialLoad = SingleLiveEvent<NetworkState>()

    var deviceLoginData = SingleLiveEvent<DeviceLoginData>()



    @Inject
    constructor(mainRepository: MainRepository, compositeDisposable : CompositeDisposable){
        mMainRepository = mainRepository
        mCompositeDisposable = compositeDisposable

    }

    fun saveClockData(clockData: ClockData?){
        initialLoad.value = NetworkState.LOADING
        val disposableSubscriber = object : DisposableSubscriber<Long>() {
            override fun onNext(value: Long) {
                Timber.d("saveClockData onNext value = $value")

            }

            override fun onError(e: Throwable) {
                Timber.d("saveClockData onError e = $e")
                initialLoad.value = NetworkState.error(e.message)
            }

            override fun onComplete() {
                Timber.d("saveClockData onComplete")
                initialLoad.value = NetworkState.LOADED
            }
        }

        mCompositeDisposable?.add(mMainRepository?.saveClockData(clockData)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSubscriber))
    }

    fun getClockData(){
        initialLoad.value = NetworkState.LOADING
        val disposableSubscriber = object : DisposableSubscriber<Array<ClockData>>() {
            override fun onNext(value: Array<ClockData>) {
                Timber.d("getClockData onNext value = $value")
                Timber.d("getClockData onNext value.size = ${value.size}")

            }

            override fun onError(e: Throwable) {
                Timber.d("getClockData onError e = $e")
                initialLoad.value = NetworkState.error(e.message)
            }

            override fun onComplete() {
                Timber.d("getClockData onComplete")
                initialLoad.value = NetworkState.LOADED
            }
        }

        mCompositeDisposable?.add(mMainRepository?.getClockData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableSubscriber))
    }


    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }
}