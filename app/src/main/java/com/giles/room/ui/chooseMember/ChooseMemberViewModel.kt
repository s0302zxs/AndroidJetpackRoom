package com.giles.room.ui.chooseMember

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ChooseMemberViewModel : ViewModel{
    private val mChooseMemberRepository: ChooseMemberRepository
    private var mCompositeDisposable : CompositeDisposable

    @Inject
    constructor(chooseMemberRepository: ChooseMemberRepository, compositeDisposable : CompositeDisposable){
        mChooseMemberRepository = chooseMemberRepository
        mCompositeDisposable = compositeDisposable

    }


}
