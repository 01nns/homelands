package com.nnss.dev.homelands.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.nnss.dev.homelands.commons.base.BaseFragment
import com.nnss.dev.homelands.commons.utils.*
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import com.nnss.dev.homelands.databinding.FragmentAllBinding
import com.nnss.dev.homelands.databinding.FragmentDetailsBinding
import com.nnss.dev.homelands.ui.activity.DetailsActivity
import com.nnss.dev.homelands.ui.adapter.CountriesAdapter
import com.nnss.dev.homelands.ui.fragment.viewmodel.AllFragmentViewModel
import com.nnss.dev.homelands.ui.fragment.viewmodel.DetailsFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import kotlin.math.roundToInt

class DetailsFragment :
    BaseFragment<FragmentDetailsBinding, DetailsFragmentViewModel>({
        FragmentDetailsBinding.inflate(it)
    }) {

    private lateinit var listener: FragmentListener
    override val viewModel: DetailsFragmentViewModel by viewModel()
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
        viewModel.getCountryByName(listener.getName())
    }

    @SuppressLint("SetTextI18n")
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
                            val mData = it[0]
                           Glide.with(requireActivity()).load(mData.flags?.png).into(ui.imgFlag)
                            ui.txtCountryName.text = listener.getName()
                            ui.txtCapital.text = "Capital: ${mData.capital?.get(0) ?: "N/A"}"
                            ui.txtRegion.text = "Region: ${mData.region ?: "N/A"}"
                            ui.txtSubRegion.text = "Sub-Region: ${mData.subregion ?: "N/A"}"
                            ui.txtArea.text = "Land Area: ${mData.area ?: "N/A"}"
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
        fun showError(title: String, message: String)
        fun getName() : String?
        fun showLoader(show: Boolean)
    }
}
