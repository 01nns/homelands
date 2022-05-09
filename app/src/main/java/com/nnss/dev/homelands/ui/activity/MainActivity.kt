package com.nnss.dev.homelands.ui.activity

import android.os.Looper
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.nnss.dev.homelands.commons.base.BaseActivity
import com.nnss.dev.homelands.commons.utils.MainDestination
import com.nnss.dev.homelands.commons.utils.UIDialog
import com.nnss.dev.homelands.data.remote.model.RestCountriesResponse
import com.nnss.dev.homelands.databinding.ActivityMainBinding
import com.nnss.dev.homelands.ui.fragment.AllFragment
import timber.log.Timber
import java.util.logging.Handler

class MainActivity : BaseActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }),
    AllFragment.FragmentListener {
    override fun initViews() {
        loader = UIDialog.loader(this)
    }

    override fun showError(title: String, message: String) {
        Timber.e(message)
    }

}