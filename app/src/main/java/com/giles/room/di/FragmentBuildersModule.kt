package com.giles.room.di

import com.giles.room.ui.chooseMember.ChooseMemberFragment
import com.giles.room.ui.chooseMode.ChooseModeFragment
import com.giles.room.ui.common.BaseFragment
import com.giles.room.ui.securityCode.SecurityCodeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeBaseFragment(): BaseFragment

    @ContributesAndroidInjector
    abstract fun contributeChooseMemberFragment(): ChooseMemberFragment

    @ContributesAndroidInjector
    abstract fun contributeChooseModeFragment(): ChooseModeFragment

    @ContributesAndroidInjector
    abstract fun contributeSecurityCodeFragment(): SecurityCodeFragment

//
//    @ContributesAndroidInjector
//    abstract fun contributeSearchSuggestionDialogFragment(): SearchSuggestionDialogFragment



}