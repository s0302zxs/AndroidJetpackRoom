package com.giles.room.ui.securityCode

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import com.giles.room.data.model.ClockData
import com.giles.room.databinding.SecurityCodeFragmentBinding
import com.giles.room.di.Injectable
import com.giles.room.ui.common.BaseFragment
import com.giles.room.ui.common.SharedViewModel
import com.giles.room.ui.main.MainActivity
import com.giles.room.viewModel.RoomViewModelFactory
import timber.log.Timber
import javax.inject.Inject

class SecurityCodeFragment: BaseFragment(), Injectable {
    private var mBinding: SecurityCodeFragmentBinding? = null

    @Inject
    lateinit var factory: RoomViewModelFactory

    private lateinit var sharedViewModel: SharedViewModel
    private lateinit var securityCodeViewModel: SecurityCodeViewModel


    companion object {
        val TAG = "SecurityCodeFragment"
        fun newInstance() = SecurityCodeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        Timber.d("onCreate")
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = com.giles.room.databinding.SecurityCodeFragmentBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        sharedViewModel = ViewModelProviders.of(this, factory).get(SharedViewModel::class.java)
        securityCodeViewModel = ViewModelProviders.of(this, factory).get(SecurityCodeViewModel::class.java)

        mBinding?.footerBar?.btnLeft?.setOnClickListener{
            //test add clock info to db
            sharedViewModel.clockData = ClockData()

            sharedViewModel.clockData?.serial = 1
            sharedViewModel.clockData?.deviceToken = "testToken"
            sharedViewModel.clockData?.id = "057hd4c4-403a9-44-99"
            sharedViewModel.clockData?.securityCode = "0911222333"
            sharedViewModel.clockData?.deviceTime = "2019-06-18T13:06:10.30+0800"
            sharedViewModel.clockData?.type = "IN"
            sharedViewModel.clockData?.faceVerify = "SUCCEED"
            sharedViewModel.clockData?.liveness = "SUCCEED"
            sharedViewModel.clockData?.mode = 1


            (activity as MainActivity)?.saveClockData(sharedViewModel.clockData)
        }

        mBinding?.footerBar?.btnRight?.setOnClickListener{
            Timber.d("click btnRight")

            /**********Test get clock data******************/
            (activity as MainActivity)?.getClockData()

        }


    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")

        (activity as MainActivity)?.setSubTitle("I am Title")

    }
}