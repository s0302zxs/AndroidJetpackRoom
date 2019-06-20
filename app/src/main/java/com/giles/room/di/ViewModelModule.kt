package com.giles.room.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.giles.room.ui.chooseMember.ChooseMemberViewModel
import com.giles.room.ui.chooseMode.ChooseModeViewModel
import com.giles.room.ui.common.SharedViewModel
import com.giles.room.ui.main.MainViewModel
import com.giles.room.ui.securityCode.SecurityCodeViewModel
import com.giles.room.viewModel.RoomViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: RoomViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel::class)
    abstract fun bindSharedViewModel(sharedViewModel: SharedViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChooseMemberViewModel::class)
    abstract fun bindChooseMemberViewModel(chooseMemberViewModel: ChooseMemberViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChooseModeViewModel::class)
    abstract fun bindChooseModeViewModel(chooseModeViewModel: ChooseModeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SecurityCodeViewModel::class)
    abstract fun bindSecurityCodeViewModel(securityCodeViewModel: SecurityCodeViewModel): ViewModel

}