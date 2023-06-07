package com.example.authorisation.presentation.enter_authorisation_code

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.authorisation.R
import com.example.authorisation.databinding.FragmentEnterAuthorisationCodeBinding
import com.example.authorisation.databinding.FragmentEnterNumberBinding
import com.example.authorisation.di.AuthorisationComponentHolder
import com.example.authorisation.di.AuthorisationDependencies
import com.example.authorisation.presentation.enter_number.EnterNumberViewModel
import com.example.common.di.ComponentDependenciesProvider
import com.example.common.presentation.BaseScreen
import com.example.common.presentation.args
import com.example.common.presentation.lazyViewModel
import com.example.common.presentation.showToast
import javax.inject.Inject


class EnterAuthorisationCodeFragment : Fragment(R.layout.fragment_enter_authorisation_code) {

    class Screen(
        val phoneNumber: String
    ): BaseScreen

    @Inject
    lateinit var viewModelFactory: EnterAuthorisationCodeViewModel.Factory

    private var binding: FragmentEnterAuthorisationCodeBinding? = null

    private val viewModel: EnterAuthorisationCodeViewModel by lazyViewModel {
        viewModelFactory.create(args())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        AuthorisationComponentHolder.get(requireContext())
            .inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentEnterAuthorisationCodeBinding.bind(view)

        binding?.setListeners()

        observeViewModel()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun observeViewModel() {
        with(viewModel) {
            binding?.toolbar?.title = "+$phoneNumber"
            isLoading.observe(viewLifecycleOwner) {
                binding?.switchLoading(it)
            }
            message.observe(viewLifecycleOwner) {
                it?.let { showToast(getString(it)) }
            }
        }
    }

    private fun FragmentEnterAuthorisationCodeBinding.setListeners() {
        etAuthCode.addTextChangedListener {
            if (it?.length == 4) {
                viewModel.sendCode(it.toString())
            }
        }
        toolbar.setNavigationOnClickListener {
            viewModel.navigateBack()
        }
    }

    private fun FragmentEnterAuthorisationCodeBinding.switchLoading(status: Boolean) {
        if (status) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = View.GONE
        }
    }
}