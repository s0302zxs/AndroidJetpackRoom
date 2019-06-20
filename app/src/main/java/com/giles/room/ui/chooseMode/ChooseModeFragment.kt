package com.giles.room.ui.chooseMode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.giles.room.databinding.ChooseModeFragmentBinding
import com.giles.room.di.Injectable
import com.giles.room.ui.common.BaseFragment
import com.giles.room.viewModel.RoomViewModelFactory
import javax.inject.Inject

class ChooseModeFragment : BaseFragment(), Injectable {
    private var mBinding: ChooseModeFragmentBinding? = null

    @Inject
    lateinit var factory: RoomViewModelFactory

    companion object {
        val TAG = "ChooseMemberFragment"
        fun newInstance() = ChooseModeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ChooseModeFragmentBinding.inflate(inflater, container, false)
        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}