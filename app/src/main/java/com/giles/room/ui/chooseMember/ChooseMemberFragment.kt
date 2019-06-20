package com.giles.room.ui.chooseMember

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import com.giles.room.databinding.ChooseMemberFragmentBinding
import com.giles.room.di.Injectable
import com.giles.room.ui.common.BaseFragment
import com.giles.room.ui.common.SharedViewModel
import com.giles.room.viewModel.RoomViewModelFactory
import timber.log.Timber
import javax.inject.Inject

class ChooseMemberFragment : BaseFragment(), Injectable {
    private var mBinding: ChooseMemberFragmentBinding? = null

    @Inject
    lateinit var factory: RoomViewModelFactory

    private lateinit var chooseMemberViewModel: ChooseMemberViewModel
    private lateinit var sharedViewModel: SharedViewModel

    companion object {
        val TAG = "ChooseMemberFragment"
        fun newInstance() = ChooseMemberFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = ChooseMemberFragmentBinding.inflate(inflater, container, false)

        return mBinding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        chooseMemberViewModel = ViewModelProviders.of(this, factory).get(ChooseMemberViewModel::class.java)
        sharedViewModel = ViewModelProviders.of(this, factory).get(SharedViewModel::class.java)

        mBinding?.viewModel = chooseMemberViewModel

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume")
    }


}