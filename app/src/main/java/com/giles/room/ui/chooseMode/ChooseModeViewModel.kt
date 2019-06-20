package com.giles.room.ui.chooseMode

import android.arch.lifecycle.ViewModel
import android.view.View
import androidx.navigation.Navigation
import com.giles.room.R
import com.giles.room.data.model.NetworkState
import com.giles.room.utils.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

class ChooseModeViewModel : ViewModel{
    private var mCompositeDisposable : CompositeDisposable

    var initialLoad = SingleLiveEvent<NetworkState>()


    @Inject
    constructor(compositeDisposable : CompositeDisposable){
        mCompositeDisposable = compositeDisposable

    }

    fun showSecurity(view : View){
        Timber.d("showSecurity")
        Navigation.findNavController(view).navigate(R.id.showSecurityCodeFragment)
    }

}