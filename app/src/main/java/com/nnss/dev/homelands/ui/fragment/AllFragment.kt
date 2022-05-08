package com.nnss.dev.homelands.ui.fragment

import android.content.Context
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nnss.dev.homelands.commons.base.BaseFragment
import com.nnss.dev.homelands.commons.utils.MainDestination
import com.nnss.dev.homelands.commons.utils.Status
import com.nnss.dev.homelands.commons.utils.collectLA
import com.nnss.dev.homelands.databinding.FragmentAllBinding
import com.nnss.dev.homelands.ui.adapter.CountriesAdapter
import com.nnss.dev.homelands.ui.fragment.viewmodel.AllFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllFragment :
    BaseFragment<FragmentAllBinding, AllFragmentViewModel>({
        FragmentAllBinding.inflate(it)
    }) {

    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var listener: FragmentListener
    override val viewModel: AllFragmentViewModel by viewModel()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            listener = context
        }
    }

    override fun backPressCallback(): OnBackPressedCallback {
        return object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.finish()
            }
        }
    }

    override fun initViews() {
        countriesAdapter = CountriesAdapter()
        with(ui.rvCountries){
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = countriesAdapter
        }

        viewModel.getAllCountries()
    }

    override fun subscribe() {
        with(viewModel){
            state.collectLA(viewLifecycleOwner) { result ->
                when(result.status){
                    Status.IDLE -> {}
                    Status.LOADING -> {
                        listener.showLoader(true)
                    }
                    Status.SUCCESS -> {
                        listener.showLoader(false)
                        result.data?.let {
                            countriesAdapter.setItems(it)
                        }
                    }
                    Status.ERROR -> {
                        listener.showLoader(false)
                        listener.showError("Error", result.msg.toString())
                    }
                }
            }
        }
    }

    interface FragmentListener {
        fun showLoader(show: Boolean)
        fun showError(title: String, message: String)
        fun navigateTo(navController: NavController, destination: MainDestination)
    }
}
