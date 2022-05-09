package com.nnss.dev.homelands.ui.activity

import android.annotation.SuppressLint
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.nnss.dev.homelands.commons.base.BaseActivity
import com.nnss.dev.homelands.commons.utils.COUNTRY_NAME
import com.nnss.dev.homelands.commons.utils.UIDialog
import com.nnss.dev.homelands.databinding.ActivityDetailsBinding
import com.nnss.dev.homelands.ui.fragment.DetailsFragment

class DetailsActivity : BaseActivity<ActivityDetailsBinding>({ ActivityDetailsBinding.inflate(it) }),
    DetailsFragment.FragmentListener{
    private var countryName: String? = null

    @SuppressLint("CheckResult")
    override fun initViews() {
        loader = UIDialog.loader(this)
        countryName = intent.getStringExtra(COUNTRY_NAME)

        binding.btnBack.setOnClickListener {
            onBackPressed()
            finish()
        }
    }

    override fun showError(title: String, message: String) {

    }

    override fun getName(): String? {
        return countryName
    }

    override fun showLoader(show: Boolean) {
        if (show) {
            loader?.show()
        } else {
            loader?.dismiss()
        }
    }

}