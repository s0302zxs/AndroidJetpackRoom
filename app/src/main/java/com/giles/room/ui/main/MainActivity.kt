package com.giles.room.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.giles.room.data.model.ClockData
import com.giles.room.di.Injectable
import com.giles.room.ui.common.SharedViewModel
import com.giles.room.viewModel.RoomViewModelFactory
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, Injectable {
    private var mBinding : com.giles.room.databinding.ActivityMainBinding? = null

    @Inject
    lateinit var factory: RoomViewModelFactory

    private lateinit var mainViewModel: MainViewModel
    private lateinit var sharedViewModel: SharedViewModel

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, com.giles.room.R.layout.activity_main)
        setSupportActionBar(mBinding?.toolbar)


        mainViewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        sharedViewModel = ViewModelProviders.of(this, factory).get(SharedViewModel::class.java)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        //mBinding?.toolbar?.title = "AAAAAAAAA"
    }

    fun setSubTitle(title : String){
        mBinding?.toolbar?.title = title
    }

    fun saveClockData(clockData: ClockData?){
        mainViewModel.saveClockData(clockData)
    }

    fun getClockData(){
        mainViewModel.getClockData()
    }


    override fun supportFragmentInjector() = dispatchingAndroidInjector





}
