package com.giles.room.ui.securityCode

import android.arch.lifecycle.ViewModel
import com.giles.room.data.model.DeviceLoginData
import com.giles.room.data.model.NetworkState
import com.giles.room.utils.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber
import timber.log.Timber
import javax.inject.Inject

class SecurityCodeViewModel : ViewModel{
    private val mSecurityCodeRepository: SecurityCodeRepository
    private var mCompositeDisposable : CompositeDisposable

    var initialLoad = SingleLiveEvent<NetworkState>()

    var deviceLoginData = SingleLiveEvent<DeviceLoginData>()

    @Inject
    constructor(securityCodeRepository: SecurityCodeRepository, compositeDisposable : CompositeDisposable){
        mSecurityCodeRepository = securityCodeRepository
        mCompositeDisposable = compositeDisposable

    }

    fun verify(securityCode : String?){
        //test
        initialLoad.value = NetworkState.LOADING

        val disposableObserver = object : DisposableSubscriber<Boolean>() {
            override fun onNext(value: Boolean) {
                Timber.d("verify onNext value = $value")


            }

            override fun onError(e: Throwable) {
                Timber.d("loadDeviceLoginFromDb onError e = $e")
                initialLoad.value = NetworkState.error(e.message)
            }

            override fun onComplete() {
                Timber.d("loadDeviceLoginFromDb onComplete")
                initialLoad.value = NetworkState.LOADED
            }
        }

        mCompositeDisposable?.add(mSecurityCodeRepository?.verify(securityCode)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(disposableObserver))


    }


    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.clear()
    }

}