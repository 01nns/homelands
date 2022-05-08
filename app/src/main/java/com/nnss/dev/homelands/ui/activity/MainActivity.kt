package com.nnss.dev.homelands.ui.activity

import androidx.navigation.NavController
import com.nnss.dev.homelands.commons.base.BaseActivity
import com.nnss.dev.homelands.commons.utils.MainDestination
import com.nnss.dev.homelands.commons.utils.UIDialog
import com.nnss.dev.homelands.databinding.ActivityMainBinding
import com.nnss.dev.homelands.ui.fragment.AllFragment
import timber.log.Timber

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it)}), AllFragment.FragmentListener {
    override fun initViews() {
        loader = UIDialog.loader(this)
    }

    override fun showLoader(show: Boolean) {
       if (show) {
           loader?.show()
       } else {
           loader?.dismiss()
       }
    }

    override fun showError(title: String, message: String) {
        Timber.e(message)
    }

    override fun navigateTo(navController: NavController, destination: MainDestination) {

    }
}