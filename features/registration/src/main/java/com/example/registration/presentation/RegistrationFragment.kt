package com.example.registration.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.common.presentation.lazyViewModel
import com.example.common.presentation.showToast
import com.example.registration.R
import com.example.registration.databinding.FragmentRegistrationBinding
import com.example.registration.di.RegistrationComponentHolder
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment: Fragment(R.layout.fragment_registration) {

    private var binding: FragmentRegistrationBinding? = null

    private val viewModel: RegistrationViewModel by lazyViewModel {
        RegistrationComponentHolder.get(requireContext())
            .registrationViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegistrationBinding.bind(view)

        binding?.setListeners()

        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observeViewModel() {
        with(viewModel) {
            isLoading.observe(viewLifecycleOwner) {
                binding?.switchLoading(it)
            }
            message.observe(viewLifecycleOwner) {
                it?.let { showToast(getString(it)) }
            }
            usernameTextInputError.observe(viewLifecycleOwner) {
                binding?.etLayoutUsername?.showError(it)
            }
            nameTextInputError.observe(viewLifecycleOwner) {
                binding?.etLayoutName?.showError(it)
            }
        }
    }

    private fun FragmentRegistrationBinding.setListeners() {
        btnFinishRegistration.setOnClickListener {
            viewModel.finishRegistration(etUsername.text.toString(), etName.text.toString())
        }
    }

    private fun TextInputLayout.showError(@StringRes errorRes: Int?) {
        error = errorRes?.let { getString(it) }
    }

    private fun FragmentRegistrationBinding.switchLoading(status: Boolean) {
        if (status) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}