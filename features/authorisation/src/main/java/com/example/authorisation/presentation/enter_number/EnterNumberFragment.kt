package com.example.authorisation.presentation.enter_number

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.authorisation.R
import com.example.authorisation.databinding.FragmentEnterNumberBinding
import com.example.authorisation.di.AuthorisationComponentHolder
import com.example.authorisation.di.AuthorisationDependencies
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.presentation.lazyViewModel
import com.example.common.presentation.showToast


class EnterNumberFragment : Fragment(R.layout.fragment_enter_number) {

    private var binding: FragmentEnterNumberBinding? = null

    private val viewModel: EnterNumberViewModel by lazyViewModel {
        ComponentDependenciesProvider.get<AuthorisationDependencies>(requireContext())
            .enterNumberViewModel()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        AuthorisationComponentHolder.get(requireContext())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEnterNumberBinding.bind(view)

        binding?.setListeners()

        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observeViewModel() {
        with(viewModel) {
            message.observe(viewLifecycleOwner) {
                it?.let { showToast(getString(it)) }
            }
            textInputError.observe(viewLifecycleOwner) {
                it?.let { binding?.showInputTextError(getString(it)) }
            }
            isLoading.observe(viewLifecycleOwner) {
                binding?.switchLoading(it)
            }
        }
    }

    private fun FragmentEnterNumberBinding.showInputTextError(errorText: String?) {
        etPhoneLayout.error = errorText
    }

    private fun FragmentEnterNumberBinding.setListeners() {
        btnGetCode.setOnClickListener {
            viewModel.getAuthorisationCode(etPhone.text.toString())
        }
    }

    private fun FragmentEnterNumberBinding.switchLoading(status: Boolean) {
        if (status) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}