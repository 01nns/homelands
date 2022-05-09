package com.nnss.dev.homelands.ui.fragment

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.nnss.dev.homelands.commons.base.BaseFragment
import com.nnss.dev.homelands.commons.utils.*
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import com.nnss.dev.homelands.databinding.FragmentAllBinding
import com.nnss.dev.homelands.ui.activity.DetailsActivity
import com.nnss.dev.homelands.ui.adapter.CountriesAdapter
import com.nnss.dev.homelands.ui.adapter.CountriesGridAdapter
import com.nnss.dev.homelands.ui.fragment.viewmodel.AllFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AllFragment :
    BaseFragment<FragmentAllBinding, AllFragmentViewModel>({
        FragmentAllBinding.inflate(it)
    }) {

    private lateinit var countriesAdapter: CountriesAdapter
    private lateinit var countriesGridAdapter: CountriesGridAdapter

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
        countriesAdapter = CountriesAdapter(object : CountriesAdapter.OnSelectCountryListener {
            override fun onItemSelected(countryData: RestCountriesResponse?) {
                val intent = Intent(requireActivity(), DetailsActivity::class.java)
                intent.putExtra(COUNTRY_NAME, countryData?.name?.official)
                startActivity(intent)
            }

        })

        countriesGridAdapter = CountriesGridAdapter(object : CountriesGridAdapter.OnSelectCountryListener {
            override fun onItemSelected(countryData: RestCountriesResponse?) {
                val intent = Intent(requireActivity(), DetailsActivity::class.java)
                intent.putExtra(COUNTRY_NAME, countryData?.name?.official)
                startActivity(intent)
            }

        })

        with(ui){
            val linearLayoutManager = LinearLayoutManager(requireActivity())
            val gridLayoutManager = GridLayoutManager(requireActivity(), 2)

            rvCountries.apply {
                adapter = countriesAdapter
                layoutManager = linearLayoutManager
            }
            rvCountriesGrid.apply {
                adapter = countriesGridAdapter
                layoutManager = gridLayoutManager
            }

            btnListView.setOnClickListener {
                initCountries(true)
            }

            btnGridView.setOnClickListener {
                initCountries(false)
            }

        }

        viewModel.getAllCountries()


    }

    override fun subscribe() {
        with(viewModel){
            state.collectLA(viewLifecycleOwner) { result ->
                when(result.status){
                    Status.IDLE -> {}
                    Status.LOADING -> {
                        ui.viewShimmer.startShimmer()
                    }
                    Status.SUCCESS -> {
                        ui.viewShimmer.stopShimmer()
                        ui.viewShimmer.visibility = View.GONE
                        ui.rvCountries.visibility = View.VISIBLE
                        ui.rvCountriesGrid.visibility = View.GONE
                        result.data?.let { data ->
                            val sorted = data.sortedWith(compareBy { it.name?.official })
                            countriesAdapter.setItems(sorted)
                            countriesGridAdapter.setItems(sorted)
                        }
                        initCountries(true)
                    }
                    Status.ERROR -> {
                        listener.showError("Error", result.msg.toString())
                    }
                }
            }
        }
    }

    private fun initCountries(isListView: Boolean) {
       if (isListView){
           ui.rvCountries.visibility = View.VISIBLE
           ui.rvCountriesGrid.visibility = View.GONE
       } else {
           ui.rvCountries.visibility = View.GONE
           ui.rvCountriesGrid.visibility = View.VISIBLE
       }
    }

    interface FragmentListener {
        fun showError(title: String, message: String)
    }
}
