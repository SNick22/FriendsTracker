package com.example.splash.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.presentation.lazyViewModel
import com.example.common.presentation.showToast
import com.example.splash.R
import com.example.splash.SplashRouter
import com.example.splash.databinding.FragmentSplashBinding
import com.example.splash.di.SplashComponentHolder
import com.example.splash.di.SplashDependencies
import com.example.splash.domain.IsSignedInUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class SplashFragment : Fragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by lazyViewModel {
        ComponentDependenciesProvider.get<SplashDependencies>(requireContext())
            .splashViewModel()
    }

    override fun onAttach(context: Context) {
        SplashComponentHolder.get(context)
            .inject(this)

        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()

        viewModel.openNextScreen()
    }

    private fun observeViewModel() {
        with(viewModel) {
            message.observe(viewLifecycleOwner) {
                it?.let { showToast(getString(it)) }
            }
        }
    }
}